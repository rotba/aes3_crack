package args_parsing;

public class ArgParserImpl implements ArgsParser {

    private String[] args;
    @Override
    public void parse(String[] args) {

    }

    @Override
    public boolean shouldEncrypt() {
        return false;
    }

    @Override
    public boolean shouldDecrypt() {
        return false;
    }

    @Override
    public boolean shouldBreak() {
        return false;
    }

    @Override
    public String getPathToPlaintextMsg() {
        return null;
    }

    @Override
    public String getPathToCyphertextMsg() {
        return null;
    }

    @Override
    public String getPathToKeys() {
        return null;
    }

    @Override
    public String getPathToKeysFound() {
        return null;
    }

    @Override
    public String getPathToInputFile() {
        return null;
    }

    @Override
    public String getPathToOutputFile() {
        return null;
    }
}
