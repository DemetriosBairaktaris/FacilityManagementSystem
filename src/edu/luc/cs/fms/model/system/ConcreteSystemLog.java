package edu.luc.cs.fms.model.system;

import java.util.Date;

public class ConcreteSystemLog implements SystemLog {
    
  public ConcreteSystemLog() { }
    
  @Override
  public void logCreate(Object object) {
    System.out.println("Creating " + object.getClass().getSimpleName() + ":\n" + object.toString());
    System.out.println();
  }

  @Override
  public void logVacate(Object object) {
    System.out.println("Vacating " + object.getClass().getSimpleName() + ":\n" + object.toString());
    System.out.println();
  }

  @Override
  public void logInspect(Object object) {
    System.out.println("Inspecting " + object.getClass().getSimpleName()
        + ":\n" + object.toString());
    System.out.println();
  }

  @Override
  public void logAdd(Object object1, Object object2) {
    System.out.println("Adding " + object1.getClass().getSimpleName() + ":\n" + object1.toString());
    System.out.println("To " + object2.getClass().getSimpleName() + ":\n" + object2.toString());
    System.out.println();
  }

  @Override
  public void logClose(Object object) {
    System.out.println("Closing " + object.getClass().getSimpleName()
        + ":\n" + object.toString() + "\n");
  }

  @Override
  public void logSchedule(Date start, Date end) {
    System.out.println("Maintenance Scheduled for " + start.toString()
        + " to " + end.toString() + "\n");
  }
}
