package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;

/**
 * This class implements the interval interface.
 * @author TeamDK
 *
 */
public class ConcreteInterval implements Interval {

  private Date startDate;
  private Date endDate;
  private SystemLog sysLog;

  public ConcreteInterval() {/*default*/}
  
  
  @Override
  public void setSysLog(SystemLog sysLog) {
    this.sysLog = sysLog ;
  }
  
  @Override
  public void log() {
    sysLog.logCreate(this);
  }

  @Override
  public Date getStartDate() {
    return startDate;
  }

  @Override
  public Date getEndDate() {
    return endDate;
  }
  
  @Override
  public void setStartDate(Date startDate) {
    this.startDate = startDate ; 
  }

  @Override
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public int compareTo(Interval interval) {
    return this.startDate.compareTo(interval.getStartDate());
  }

  @Override
  public String toString() {
    return startDate.toString() + " - " + endDate.toString();
  }
}
