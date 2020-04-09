package args_parsing;

public class ArgsParserFactory {
    public static ArgsParser create(){
        return new ArgParserImpl();
    }
}
