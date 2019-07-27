package com.onlineExam.common;

public class Common {
    private static String initStartTime = "06:00:00";

    private static String initEndTime = "08:00:00";

    public static String startTime;

    public static String endTime;

    public static void initialize(){
        startTime = initStartTime;
        endTime = initEndTime;
    }
}
