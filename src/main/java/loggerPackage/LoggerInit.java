package loggerPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class LoggerInit {
    public static final Logger log = LoggerFactory.getLogger(LoggerInit.class);

    public static void main(String[] args) {
        log.info("slf4j-log4j bridge logger test");

    }
}
