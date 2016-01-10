package loggerPackage;

import org.apache.log4j.Logger;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class LoggerInit {
    public static final Logger log = Logger.getLogger(LoggerInit.class);

    public static void main(String[] args) {
        log.info("logger test");

    }
}
