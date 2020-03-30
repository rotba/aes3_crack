package crack;

public interface Breaker {
    /**
     * Preconditions:
     *  plaintext.length == cyphertext.length
     *  plaintext.length%4==0
     *  cyphertext.length%4==0
     * Poostconditions:
     *  ret.length = 3*4
     */
    public byte[] crack(byte[] plaintext, byte[] cypertext);
}
