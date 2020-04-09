import io.IOManager;
import io.IOManagerFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;

import static org.junit.Assert.*;

public class MainTest {
    private IOManager io;

    @Before
    public void setUp() throws Exception {
        io = IOManagerFactory.create();
    }

//    private void abstractTest(String msg, String cypehr,Lambda l){
//        String out_key = "test_files/ans_short";
//        try {
//            Main.main(new String[]{"-b", "-m", msg, "-c", cypehr, "-o", out_key});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        l.invoke();
//        testEncryptP2C("test_files/message_short", "test_files/cipher_short", "test_files/ans_short");
//    }

    @Test
    public void mainEncShort() {
        try {
            Main.main(new String[]{"-b", "-m", "test_files/message_short", "-c", "test_files/cipher_short", "-o", "test_files/ans_short"});
        } catch (IOException e) {
            e.printStackTrace();
        }
        testEncryptP2C("test_files/message_short", "test_files/cipher_short", "test_files/ans_short");
    }

    @Test
    public void mainDecShort() {
        try {
            Main.main(new String[]{"-b", "-m", "test_files/message_short", "-c", "test_files/cipher_short", "-o", "test_files/ans_short"});
        } catch (IOException e) {
            e.printStackTrace();
        }
        testDecryptC2P("test_files/message_short", "test_files/cipher_short", "test_files/ans_short");
    }

    @Test
    public void mainEncLong() {
        String msg = "test_files/message_long";
        String out_keys = "test_files/ans_long";
        String cypher = "test_files/cipher_long";
        try {

            Main.main(new String[]{"-b", "-m", msg, "-c", cypher, "-o", out_keys});
        } catch (IOException e) {
            e.printStackTrace();
        }
        testEncryptP2C(msg,cypher,out_keys);
    }

    @Test
    public void mainDecLong() {
        String cipher = "test_files/cipher_long";
        String message = "test_files/message_long";
        String out_keys = "test_files/ans";
        try {
            Main.main(new String[]{"-b", "-m", message, "-c", cipher, "-o", out_keys});
        } catch (IOException e) {
            e.printStackTrace();
        }
        testDecryptC2P(message, cipher, out_keys);
    }

    private void testEncryptP2C(String ptPath, String ctPath, String kPath){
        String ansTmp = "test_files/ans_tmp";
        try {
            Main.main(new String[]{"-e", "-k", kPath, "-i", ptPath, "-o", ansTmp});
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assertArrayEquals(io.read(ctPath), io.read(ansTmp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testDecryptC2P(String ptPath, String ctPath, String kPath){
        String ansTmp = "test_files/ans_tmp";
        try {
            Main.main(new String[]{"-d", "-k", kPath, "-i", ctPath, "-o", ansTmp});
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assertArrayEquals(io.read(ptPath), io.read(ansTmp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}