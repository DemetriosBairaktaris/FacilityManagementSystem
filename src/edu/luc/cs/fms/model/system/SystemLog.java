package edu.luc.cs.fms.model.system;

import java.util.Date;

public abstract class SystemLog {

    public SystemLog() {
        
    }

    /**
     * logs creation of an object
     * @param object
     */
    public void logCreate(Object object) {
        System.out.println("Creating " + object.getClass().getSimpleName() + ":\n" + object.toString());
        System.out.println();
    }

    /**
     * logs vacating an object
     * @param object
     */
    public void logVacate(Object object) {
        System.out.println("Vacating " + object.getClass().getSimpleName() + ":\n" + object.toString());
        System.out.println();
    }

    /**
     * logs inspection of an object
     * @param object
     */
    public void logInspect(Object object) {
        System.out.println("Inspecting " + object.getClass().getSimpleName() + ":\n" + object.toString());
        System.out.println();
    }

    /**
     * logs adding an object to another
     * @param object1
     * @param object2
     */
    public void logAdd(Object object1, Object object2) {
        System.out.println("Adding " + object1.getClass().getSimpleName() + ":\n" + object1.toString());
        System.out.println("To " + object2.getClass().getSimpleName() + ":\n" + object2.toString());
        System.out.println();
    }

    /**
     * logs the closing of an object
     * @param object
     */
    public void logClose(Object object) {
        System.out.println("Closing " + object.getClass().getSimpleName() + ":\n" + object.toString() + "\n");
    }

    /**
     * logs the scheduling of two dates for maintenace
     * @param start
     * @param end
     */
    public void logSchedule(Date start, Date end) {
        System.out.println("Maintenance Scheduled for " + start.toString() + " to " + end.toString());
    }
}
