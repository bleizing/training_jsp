package com.bleizing.web.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author nuriman
 * @By coovy,
 * 12-MAR-2018, menambahkan group
 */
public class ServletSchedulerListener implements ServletContextListener {
//    public static final Map<String, JobDetail> JOB_MAP = new HashMap<>();
//    public static Scheduler scheduler;
//
//    public final static String GROUP = "scheduler-group";
//    private String ctx;

    public void contextDestroyed(final ServletContextEvent event) {
//        try {
//            scheduler.shutdown(false);
//            System.out.println("ALL_SCHEDULLER_HAS_BEEN_SHUTDOWN ON " + ctx);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void contextInitialized(final ServletContextEvent event) {
//        ctx = event.getServletContext().getContextPath();
//
//        String schedulerGroup = event.getServletContext().getInitParameter(GROUP);
//        System.out.println("GROUP_ADALAH "+schedulerGroup);
//        resetRunningStatus();
//        try {
//            scheduler = new StdSchedulerFactory().getScheduler();
//            scheduler.start();
//            if (schedulerGroup == null) schedulerGroup = "";
//            startOnStartupSchedule(schedulerGroup);
//
//            System.out.println("All schedulers are started ON " + ctx);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }


//    public static boolean isSchedulerAlreadyRunning(String scheduleName) {
//        return JOB_MAP.containsKey(scheduleName);
//    }
//
//    private void resetRunningStatus() {
//        Logging logging = new SchedulerLoging();
//        try {
//            BristarHibernateManager.INSTANCE.executeUpdate("UPDATE SchedulerEntity SET isActive=false", null);
//            logging.append("Success to reset running scheduler status").appendLine();
//        } catch (ProcessException pe) {
//            logging.append("Fail to reset running scheduler status " + pe).appendLine();
//        }
//        logging.info();
//    }
//
//    private void startOnStartupSchedule(String group) {
//        Logging logging = new SchedulerLoging();
//        try {
//            SchedulerServices.startOnStartupSchedule(group, logging);
//        } catch (ProcessException pe) {
//        }
//        logging.info();
//    }

}
