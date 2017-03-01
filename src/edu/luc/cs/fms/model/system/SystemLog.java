package edu.luc.cs.fms.model.system;

import java.util.Date;

public interface SystemLog {

    /**
     * logs creation of an object
     * @param object
     */
    public void logCreate(Object object);

    /**
     * logs vacating an object
     * @param object
     */
    public void logVacate(Object object);

    /**
     * logs inspection of an object
     * @param object
     */
    public void logInspect(Object object);

    /**
     * logs adding an object to another
     * @param object1
     * @param object2
     */
    public void logAdd(Object object1, Object object2);

    /**
     * logs the closing of an object
     * @param object
     */
    public void logClose(Object object);

    /**
     * logs the scheduling of two dates for maintenance
     * @param start
     * @param end
     */
    public void logSchedule(Date start, Date end);
}
