package args_parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgParserImpl implements ArgsParser {

    private List<String> args;
    @Override
    public void parse(String[] args) {
        this.args=  new ArrayList<>(Arrays.asList(args));
    }

    @Override
    public boolean shouldEncrypt() {
        return args.contains("-e");
    }

    @Override
    public boolean shouldDecrypt() {
        return args.contains("-d");
    }

    @Override
    public boolean shouldBreak() {
        return args.contains("-b");
    }

    @Override
    public String getPathToPlaintextMsg() {
        int i = args.indexOf("-m");
        return args.get(i+1);
    }

    @Override
    public String getPathToCyphertextMsg() {
        int i = args.indexOf("-c");
        return args.get(i+1);
    }

    @Override
    public String getPathToKeys() {
        int i = args.indexOf("-k");
        return args.get(i+1);
    }

    @Override
    public String getPathToKeysFound() {
        int i = args.indexOf("-o");
        return args.get(i+1);
    }

    @Override
    public String getPathToInputFile() {
        int i = args.indexOf("-i");
        return args.get(i+1);
    }

    @Override
    public String getPathToOutputFile() {
        int i = args.indexOf("-o");
        return args.get(i+1);
    }
}
