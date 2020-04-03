package aes;

public interface AES3 {
    byte[] encrypt(byte[] plaintext, byte[] keys);
    byte[] decrypt(byte[] cyphertext, byte[] keys);
}
