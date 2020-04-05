package crack;

import io.IOManager;
import io.IOManagerFactory;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class BreakerTest {
    private static String test_files_dir = Paths.get(System.getProperty("user.dir").toString(), "test_files").toString();
    private static String pathToKShort = Paths.get(test_files_dir, "key_short").toString();
    private String pathToPTShort= Paths.get(test_files_dir, "message_short").toString();
    private String pathToCTShort= Paths.get(test_files_dir, "cipher_short").toString();
    private IOManager io;
    private Breaker out;

    @Before
    public void setUp() throws Exception {
        out  = BreakerFactory.create();
        io = IOManagerFactory.create();

    }

    @Test
    public void testShort() throws IOException {
        byte[] inputPlaintext = io.read(pathToPTShort);
        byte[] inputCiphertext = io.read(pathToCTShort);
        byte[] expected = io.read(pathToKShort);
        byte[] actual = out.crack(inputPlaintext,inputCiphertext);
        assertArrayEquals(expected,actual);
    }
}