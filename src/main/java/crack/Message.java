package crack;

import java.util.Arrays;
import java.util.List;

public class Message {
    protected Block[] blocks;
    public Message(byte[] bytes){
        assert bytes.length%16==0;
        blocks = new Block[bytes.length/16];
        for (int i = 0; i < blocks.length; i+=16) {
            blocks[i] = new Block(Arrays.copyOfRange(bytes, i, i+16));
        }
    }

    private Message(Block[] blocks){
        this.blocks=blocks;
    }
    public Message shift(int amount){
        Block[] ans = new Block[blocks.length];
        for (int i = 0; i <blocks.length ; i++) {
            ans[i] = blocks[i].shift(amount);
        }
        return new Message(ans);
    }

    public Block getBlock(int i) {
        return blocks[i];
    }


}
