package aes;

public class AES3Factory {
    public static AES3 create(){
        return new AES3Impl();
    }
}
