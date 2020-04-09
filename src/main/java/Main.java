import aes.AES3;
import aes.AES3Factory;
import args_parsing.ArgsParser;
import args_parsing.ArgsParserFactory;
import crack.Breaker;
import crack.BreakerFactory;
import io.IOManager;
import io.IOManagerFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArgsParser parser = ArgsParserFactory.create();
        parser.parse(args);
        if(parser.shouldEncrypt()) encrypt(parser);
        if(parser.shouldDecrypt()) decrypt(parser);
        if(parser.shouldBreak()) breakk(parser);
    }

    private static void encrypt(ArgsParser parser) throws IOException {
        AES3 aes3 = AES3Factory.create();
        IOManager io = IOManagerFactory.create();
	    byte[] plaintext = io.read(parser.getPathToInputFile());
	    byte[] keys = io.read(parser.getPathToKeys());
        byte[] cypertext = aes3.encrypt(plaintext, keys);
        io.write(parser.getPathToOutputFile(), cypertext);
    }

    private static void decrypt(ArgsParser parser) throws IOException {
        AES3 aes3 = AES3Factory.create();
        IOManager io = IOManagerFactory.create();
        byte[] input = io.read(parser.getPathToInputFile());
	    byte[] keys = io.read(parser.getPathToKeys());
        byte[] cypertext = aes3.decrypt(input, keys);
        io.write(parser.getPathToOutputFile(), cypertext);
    }


    private static void breakk(ArgsParser parser) throws IOException {
        IOManager io = IOManagerFactory.create();
        byte[] plaintext  = io.read(parser.getPathToPlaintextMsg());
        byte[] cyphertext = io.read(parser.getPathToCyphertextMsg());
        Breaker cracker = BreakerFactory.create();
        byte[] keys = cracker.crack(plaintext,cyphertext);
        io.write(parser.getPathToKeysFound(), keys);
    }
}
