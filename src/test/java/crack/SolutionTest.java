package crack;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testSolutoinIsZero() {
        test((byte)0,(byte)0,(byte)0,(byte)0,(byte)0);
    }

    @Test
    public void testSolutoinIsZeroZeroFF() {
        test((byte) 0, (byte) 0, (byte) 0xff, (byte) 0, (byte) 0xff);
    }

    @Test
    public void testSolutoinIsZeroZero200() {
        test((byte) 0, (byte) 0, (byte) 200, (byte) 0, (byte)200);
    }

    private void test(byte exk1, byte exk2, byte exK3,byte pt, byte ct) {
        Solution actual = Solution.solve(pt, ct);
        sanity(exk1,exk2,exK3,pt,ct);
        assertEquals(exk1, actual.getK1Byte());
        assertEquals(exk2, actual.getK2Byte());
        assertEquals(exK3, actual.getK3Byte());
    }

    private void sanity(byte k1, byte k2, byte k3, byte pt, byte ct){
        assertEquals(xor(pt,ct), xor(k1,xor(k2,k3)));
    }

    private static  byte xor(byte b1, byte b2){
        int one = (int)b1;
        int two = (int)b2;
        int xor = one ^ two;
        return (byte)(0xff & xor);
    }
}