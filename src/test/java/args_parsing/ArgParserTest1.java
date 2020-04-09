package args_parsing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgParserTest1 {

    private ArgsParser out;

    @Before
    public void setUp() throws Exception {
        out = ArgsParserFactory.create();
        out.parse(new String[]{"-e", "-k", "key.txt", "-i", "message.txt", "-o", "cypther.txt"});
    }

    @Test
    public void shouldEncrypt() {
        assertEquals(true,out.shouldEncrypt());
    }

    @Test
    public void shouldDecrypt() {
        assertEquals(false,out.shouldDecrypt());
    }

    @Test
    public void shouldBreak() {
        assertEquals(false,out.shouldBreak());
    }

    @Test
    public void getPathToPlaintextMsg() {
        assertEquals("",out.shouldBreak());
    }



    @Test
    public void getPathToKeys() {
        assertEquals("key.txt",out.getPathToInputFile());
    }

    @Test
    public void getPathToInputFile() {
        assertEquals("message.txt",out.getPathToInputFile());
    }

    @Test
    public void getPathToOutputFile() {
        assertEquals("cypther.txt",out.getPathToOutputFile());
    }
}