package crack;

import org.apache.commons.lang.ArrayUtils;

import static crack.Solution.solve;

public class BreakerImpl implements Breaker{
    private Message pt;
    private Message ct;
    @Override
    public byte[] crack(byte[] plaintext, byte[] cipertext) {
        pt = new Message(plaintext);
        ct = new Message(cipertext);
        Block sc2K1 = new Block(new byte[16]);
        Block sc1K2 = new Block(new byte[16]);
        Block k3 = new Block(new byte[16]);
        Message sc3Pt = pt.shift(3);
        Block sc3PtFirstBlock = sc3Pt.getBlock(0);
        Block ctFirstBlock = ct.getBlock(0);
        for (int i = 0; i <sc3PtFirstBlock.getWidth() ; i++) {
            for (int j = 0; j <sc3PtFirstBlock.getHeigth() ; j++) {
                Solution solution = solve(
                        sc3PtFirstBlock.getByte(i,j),
                            ctFirstBlock.getByte(i,j)
                );
                sc2K1.setByte(solution.getK1Byte(),i,j);
                sc1K2.setByte(solution.getK2Byte(),i,j);
                k3.setByte(solution.getK3Byte(),i,j);
            }
        }
        Block k1 = sc2K1.shift(-2);
        Block k2 = sc2K1.shift(-1);
        return ArrayUtils.addAll(k1.getContents(),ArrayUtils.addAll(k2.getContents(),k3.getContents()));

    }

}
