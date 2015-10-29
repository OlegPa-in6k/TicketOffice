package StreamFactory;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by employee on 10/27/15.
 */
public class StreamFactory {

    public static PrintStream getSystemOut() {
        return System.out;
    }

    public static InputStream getSystemIn() {
        return System.in;
    }
}
