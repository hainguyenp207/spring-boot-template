package com.spring.boot.coffeine.utils;
import org.slf4j.Logger;

public class Log {
    public static void write(Logger logger, String... objects){
        String content = "";
        for(int i = 0 ; i< objects.length - 1; i++){
            content += objects[i] + " | ";
        }
        content += objects[objects.length-1];
        logger.info(content);
    }

    public static void error(Logger logger,  Throwable e, String... objects){
        String content = "";
        for(int i = 0 ; i< objects.length - 1; i++){
            content += objects[i] + " | ";
        }
        if(objects.length > 1){
            content += objects[objects.length-1];
        }

        logger.error(content, e);
    }
}
