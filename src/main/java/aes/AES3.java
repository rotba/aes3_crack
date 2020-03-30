package aes;

public interface AES3 {
    public byte[] encrypt(byte[] plaintext);
    public byte[] decrypt(byte[] cyphertext);
}
