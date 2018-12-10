package logging.details;

/**
 * Based on http://www.vogella.com/tutorials/Logging/article.html
 * see also https://docs.oracle.com/javase/6/docs/technotes/guides/logging/overview.html
 * to set property that points to file
 * -Djava.util.logging.config.file=logging.properties
 */

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DetailedLogSample {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(DetailedLogSample.class.getName());

    public void doSomeUncommonThingAndLog(){

            // LOG this level to the log
            LOGGER.setLevel(Level.FINEST);

            ConsoleHandler handler = new ConsoleHandler();
            // PUBLISH this level
            handler.setLevel(Level.FINER);
            LOGGER.addHandler(handler);

            LOGGER.finer("Info Log");
            LOGGER.finest("Info Log");

    }

}
