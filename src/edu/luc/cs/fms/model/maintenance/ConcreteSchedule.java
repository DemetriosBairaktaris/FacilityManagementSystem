package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class handles all the scheduling of orders and maintenance.
 * 
 * @author TeamDK
 *
 */
public class ConcreteSchedule implements Schedule {

  private Date currentDate;
  private List<Date> startDate;
  private List<Date> endDate;
  private long downTime;
  private SystemLog sysLog;

  public ConcreteSchedule() {/*default*/}

  @Override
  public void setSysLog(SystemLog sysLog){
      this.sysLog = sysLog ; 
  }
  
  @Override
  public void setCurrentDate(Date currentDate) {
    this.currentDate = currentDate;
  }

  @Override
  public void setStartDate(List<Date> startDate) {
    this.startDate = startDate;
  }

  @Override
  public void setEndDate(List<Date> endDate) {
    this.endDate = endDate;
  }

  @Override
  public void setDownTime(long downTime) {
    this.downTime = downTime;
  }

  @Override
  public boolean scheduleMaintenance(Date start, Date end) {
    if (currentDate.getTime() > start.getTime()) {
      return false;
    } else if (start.getTime() >= end.getTime()) {
      return false;
    } else if (checkAvailability(start, end)) {
      startDate.add(start);
      endDate.add(end);
      sysLog.logSchedule(start, end);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public long calcDownTimeForFacility() {
    if (startDate.size() == 0) {
      return 0;
    } else {
      for (int i = 0; i < endDate.size(); i++) {
        downTime += endDate.get(i).getTime() - startDate.get(i).getTime();
      }
      downTime = TimeUnit.MILLISECONDS.toDays(downTime);
      return downTime;
    }
  }

  private boolean checkAvailability(Date start, Date end) {
    if (startDate.size() == 0) {
      return true;
    }
    for (int i = 0; i < startDate.size(); i++) {
      if (startDate.get(i).before(start)) {
        if (endDate.get(i).after(end)) {
          return false;
        } else if (endDate.get(i).before(end)) {
          return false;
        }
      }
    }
    return true;
  }
}