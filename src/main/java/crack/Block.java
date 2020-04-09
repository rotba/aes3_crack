package crack;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class Block {
    private Column[] cols;

    public Block(byte[] copyOfRange) {
        assert copyOfRange.length == 16;
        cols = new Column[4];
        for (int i = 0; i < 4; i++) {
            byte[] colContent = new byte[4];
            for (int j = 0; j <colContent.length ; j++) {
                colContent[j] =copyOfRange[i +j*4];
            }
            cols[i] = new Column(colContent);
        }
    }

    private Block(Column c0, Column c1, Column c2, Column c3) {
        cols = new Column[]{c0, c1, c2, c3};
    }

    public Block shift(int amount) {
        return new Block(
                cols[0].shift(amount, 0),
                cols[1].shift(amount, 1),
                cols[2].shift(amount, 2),
                cols[3].shift(amount, 3)
        );
    }

    public int getWidth() {
        return cols.length;
    }

    public int getHeigth() {
        return cols[0].getHeight();
    }

    public byte getByte(int i, int j) {
        return cols[j].getByte(i);
    }

    public void setByte(byte b, int i, int j) {
        cols[j].setByte(i, b);
    }

    public byte[] getContents() {
        byte[] ans = new byte[getHeigth()*getWidth()];
        for (int i = 0; i < getHeigth(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                ans[i+4*j] = cols[j].getByte(i);
            }
        }
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeigth(); j++) {
                ans[i+4*j] = cols[i].getByte(j);
            }
        }
        return ans;
    }
}
