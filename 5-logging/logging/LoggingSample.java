package logging;

/**
 * Based on http://www.vogella.com/tutorials/Logging/article.html
 * see also https://docs.oracle.com/javase/6/docs/technotes/guides/logging/overview.html
 * to set property that points to file
 * -Djava.util.logging.config.file=logging.properties
 */

import logging.details.DetailedLogSample;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggingSample {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(LoggingSample.class.getName());


    public void doSomeThingAndLog() {
        // ... more code

        // now we demo the logging
        // set the LogLevel to severe, warning and info, will override file setting
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log " );
        LOGGER.info("Info Log");
    }

    public static void main(String[] args) {
        LoggingSample tester = new LoggingSample();
        tester.doSomeThingAndLog();
        DetailedLogSample detailed = new DetailedLogSample();
        detailed.doSomeUncommonThingAndLog();
    }

}
