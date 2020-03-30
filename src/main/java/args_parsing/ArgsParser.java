package args_parsing;

public interface ArgsParser {
    public void parse(String[] args);
    public boolean shouldEncrypt();
    public boolean shouldDecrypt();
    public boolean shouldBreak();
    public String getPathToPlaintextMsg();
    public String getPathToCyphertextMsg();
    public String getPathToKeys();
    public String getPathToKeysFound();
    public String getPathToInputFile();
    public String getPathToOutputFile();
}
