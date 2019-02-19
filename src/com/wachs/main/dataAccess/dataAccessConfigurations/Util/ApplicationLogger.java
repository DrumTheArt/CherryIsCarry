package com.wachs.main.dataAccess.dataAccessConfigurations.Util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;


public class ApplicationLogger {

    private static Logger jlog;
    private static Handler fh;

    public static void loggingQueries(String logInput) {

        jlog = Logger.getLogger("");
        try {
            fh = new FileHandler("info.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getLogger("").addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter() {

            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        };

        fh.setFormatter(formatter);
        jlog.info(logInput);
    }

}