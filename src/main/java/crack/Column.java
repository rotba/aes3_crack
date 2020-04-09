package crack;

public class Column {
    private byte[] content;

    public Column(byte[] copyOfRange) {
        content = copyOfRange;
    }

    public Column shift(int amount, int dilation){
        byte[] ans = new byte[content.length];
        int shifting = amount*dilation;
        for (int i = 0; i < content.length; i++) {
            ans[Math.floorMod((i-shifting), content.length)] = content[i];
        }
        return new Column(ans);
    }

    public int getHeight() {
        return content.length;
    }

    public byte getByte(int j) {
        return content[j];
    }

    public void setByte(int j, byte b) {
        content[j]=b;
    }

    public byte[] getContents() {
        return content;
    }
}
