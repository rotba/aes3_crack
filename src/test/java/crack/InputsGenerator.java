package crack;

import org.apache.commons.lang.ArrayUtils;

public class InputsGenerator {
    public static byte[] pt1() {
        return new byte[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    private static byte[] k_zeros() {
        return new byte[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    private static byte[] k_1_zeros() {
        return new byte[]{
                1, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    private static byte[] k_ff() {
        return new byte[]{
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff
        };
    }

    private static byte[] k_ff_200() {
        return new byte[]{
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 200
        };
    }

    public static byte[] k1() {
        return ArrayUtils.addAll(
                k_zeros(),
                ArrayUtils.addAll(
                        k_zeros(),
                        k_zeros()
                )
        );
    }

    public static byte[] ct1() {
        return new byte[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    public static byte[] pt2() {
        return pt1();
    }
    public static byte[] ct2() {
        return new byte[]{
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff
        };
    }

    public static byte[] k2() {
        return ArrayUtils.addAll(
                k_zeros(),
                ArrayUtils.addAll(
                        k_zeros(),
                        k_ff()
                )
        );
    }

    public static byte[] pt3() {
        return pt1();
    }
    public static byte[] ct3() {
        return new byte[]{
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 200
        };
    }

    public static byte[] k3() {
        return ArrayUtils.addAll(
                k_zeros(),
                ArrayUtils.addAll(
                        k_zeros(),
                        k_ff_200()
                )
        );
    }

    public static byte[] pt4() {
        return new byte[]{
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }
    public static byte[] ct4() {
        return new byte[]{
                0, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    public static byte[] k4() {
        return ArrayUtils.addAll(
                k_zeros(),
                ArrayUtils.addAll(
                        k_zeros(),
                        k_zeros()
                )
        );
    }


    public static byte[] k_tricky() {
        return new byte[]{
                0, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }

    public static byte[] pt5() {
        return new byte[]{
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        };
    }
    public static byte[] ct5() {
        return new byte[]{
                0, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 1, 0, 0
        };
    }

    public static byte[] k5() {
        return ArrayUtils.addAll(
                k_tricky(),
                ArrayUtils.addAll(
                        k_zeros(),
                        k_zeros()
                )
        );
    }
}
