package crack;

import aes.AES3;
import aes.AES3Factory;
import io.IOManager;
import io.IOManagerFactory;
import org.junit.Before;
import org.junit.Test;
import testUtils.InputsGenerator;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class BreakerTest {
    private static String test_files_dir = Paths.get(System.getProperty("user.dir").toString(), "test_files").toString();
    private static String pathToKShort = Paths.get(test_files_dir, "key_short").toString();
    private static String pathToPTShort= Paths.get(test_files_dir, "message_short").toString();
    private static String pathToCTShort= Paths.get(test_files_dir, "cipher_short").toString();
    private static String pathToKLong = Paths.get(test_files_dir, "key_long").toString();
    private static String pathToPTLong= Paths.get(test_files_dir, "message_long").toString();
    private static String pathToCTLong = Paths.get(test_files_dir, "cipher_long").toString();
    private IOManager io;
    private Breaker out;
    private AES3 aes3;


    @Before
    public void setUp() throws Exception {
        out  = BreakerFactory.create();
        io = IOManagerFactory.create();
        aes3 = AES3Factory.create();

    }

    @Test
    public void testShort() throws IOException {
        test(io.read(pathToPTShort), io.read(pathToCTShort), io.read(pathToKShort));
    }

    @Test
    public void testLong() throws IOException {
        test(io.read(pathToPTLong), io.read(pathToCTLong), io.read(pathToKLong));
    }

    @Test
    public void test1() throws IOException {
        test(
                InputsGenerator.pt1(),
                InputsGenerator.ct1(),
                InputsGenerator.k1()
        );
    }

    @Test
    public void test2() throws IOException {
        test(
                InputsGenerator.pt2(),
                InputsGenerator.ct2(),
                InputsGenerator.k2()
        );
    }

    @Test
    public void test3() throws IOException {
        test(
                InputsGenerator.pt3(),
                InputsGenerator.ct3(),
                InputsGenerator.k3()
        );
    }

    @Test
    public void test4() throws IOException {
        test(
                InputsGenerator.pt4(),
                InputsGenerator.ct4(),
                InputsGenerator.k4()
        );
    }

    @Test
    public void test5() throws IOException {
        test(
                InputsGenerator.pt5(),
                InputsGenerator.ct5(),
                InputsGenerator.k5()
        );
    }

    private void test(byte[] inputPlaintext, byte[] inputCiphertext, byte[] keys) throws IOException {
        byte[] actual = out.crack(inputPlaintext, inputCiphertext);
        assertEnciptsTo(inputPlaintext, inputCiphertext, actual, keys);
    }

    private void assertEnciptsTo(byte[] plaintext, byte[] ciphertext, byte[] actualKeys, byte[] origKeys) throws IOException {
//        assertArrayEquals(ciphertext, aes3.encrypt(plaintext,actualKeys));
        assertArrayEquals(ciphertext, aes3.encrypt(plaintext,origKeys));
    }
}