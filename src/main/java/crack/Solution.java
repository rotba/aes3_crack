package crack;

public class Solution {
    private byte k1Byte;
    private byte k2Byte;
    private byte k3Byte;

    public static Solution solve(byte b1, byte b2){
        byte xor = xor(b1,b2);
        return new Solution((byte)0,(byte)0,xor);
    }

    private static byte xor(byte b1, byte b2) {
        // convert to ints and xor
        int one = (int)b1;
        int two = (int)b2;
        int xor = one ^ two;
        return  (byte)(0xff & xor);
    }

    private Solution(byte k1Byte, byte k2Byte, byte k3Byte) {
        this.k1Byte = k1Byte;
        this.k2Byte = k2Byte;
        this.k3Byte = k3Byte;
    }

    public byte getK1Byte() {
        return k1Byte;
    }

    public byte getK2Byte() {
        return k2Byte;
    }

    public byte getK3Byte() {
        return k3Byte;
    }
}
