package org.koreait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    private static LocalDateTime time = null;
    private static String formatedTime = null;

    public static String getNowTime() {
        time = LocalDateTime.now();
        formatedTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return formatedTime;
    }
}
