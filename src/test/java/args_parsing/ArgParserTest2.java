package args_parsing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgParserTest2 {

    private ArgsParser out;

    @Before
    public void setUp() throws Exception {
        out = ArgsParserFactory.create();
        out.parse(new String[]{"-b", "-m", "foo_pt.txt", "-c", "foo_ct.txt", "-o", "foo_out.txt"});
    }

    @Test
    public void shouldEncrypt() {
        assertEquals(false,out.shouldEncrypt());
    }

    @Test
    public void shouldDecrypt() {
        assertEquals(false,out.shouldDecrypt());
    }

    @Test
    public void shouldBreak() {
        assertEquals(true,out.shouldBreak());
    }

    @Test
    public void getPathToPlaintextMsg() {
        assertEquals("foo_pt.txt",out.getPathToPlaintextMsg());
    }

    @Test
    public void getPathToOutputFile() {
        assertEquals("foo_out.txt",out.getPathToOutputFile());
    }

    @Test
    public void getPathToKeysFound() {
        assertEquals("foo_out.txt",out.getPathToKeysFound());
    }
}