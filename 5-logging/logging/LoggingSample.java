package i.logging;

/**
 * Based on http://www.vogella.com/tutorials/Logging/article.html
 */

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggingSample {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(LoggingSample.class.getName());


    public void doSomeThingAndLog() {
        // ... more code

        // now we demo the logging

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
    }

    public static void main(String[] args) {
        LoggingSample tester = new LoggingSample();
        tester.doSomeThingAndLog();
    }
}
