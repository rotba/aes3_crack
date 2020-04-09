package aes;

import java.util.Arrays;

public class AES3Impl implements AES3 {

	public static final int BLOCKSIZE = 16;
	public static final int BLOCKLENGTH = 4;

	public byte[] encrypt(byte[] plaintext, byte[] keys) {
		byte[][][] blocks = split(plaintext);
		for (byte[][] key : split(keys)){
			for (byte[][] block : blocks){
				shiftColumns(block);
				xorText(block, key);
			}
		}
		return join(blocks);//TODO: test
	}

	private byte[] join(byte[][][] blocks) {
		byte[] result = new byte[blocks.length* BLOCKSIZE];
		for (int i = 0; i < blocks.length* BLOCKSIZE; i++){
			result[i] = blocks[i/ BLOCKSIZE] [(i% BLOCKSIZE )% BLOCKLENGTH] [(i% BLOCKSIZE )/ BLOCKLENGTH];
		}
		return result;// TODO: test
	}

	byte[][][] split(byte[] text) {
		byte[][][] blocks = new byte[text.length/ BLOCKSIZE][BLOCKLENGTH][BLOCKLENGTH];
		for (int i = 0; i < text.length; i++){
			blocks[i/ BLOCKSIZE] [(i% BLOCKSIZE )% BLOCKLENGTH] [(i% BLOCKSIZE )/ BLOCKLENGTH] = text[i];
		}
		return blocks;// TODO: test
	}

	public byte[] decrypt(byte[] cyphertext, byte[] keys) {
		byte[][][] blocks = split(cyphertext);
		for (byte[][] key : reverse(split(keys))){
			for (byte[][] block : blocks){
				shiftBackColumns(block);
				xorText(block, key);
			}
		}
		return join(blocks);//TODO: test
	}

	private byte[][][] reverse(byte[][][] blocks) {
		for (int i = 0; i < blocks.length / 2; i++){
			swap(blocks, i, blocks.length-i-1);
		}
		return blocks;
	}

	private void swap(byte[][][] blocks, int i, int j) {
		byte[][] tmp = blocks[i];
		blocks[i] = blocks[j];
		blocks[j] = tmp;
	}

	void shiftColumns(byte[][] text){
		int len = text.length;
		byte[][] clone = cloneArray(text, len);
		for (int i = 0; i < len*len; i++){
			text[i/len][i%len] = clone[(i/len+i)%len][i%len];
		}
	}

	private byte[][] cloneArray(byte[][] text, int len) {
		byte[][] clone = new byte[len][];
		for (int i = 0; i < len; i++){
			clone[i] = Arrays.copyOf(text[i], len);
		}
		return clone;
	}

	void shiftBackColumns(byte[][] text) {
		int len = text.length;
		byte[][] clone = cloneArray(text, len);
		for (int i = 0; i < len * len; i++){
			text[i / len][i % len] = clone[( len + i / len - i%len ) % len][i % len];
		}
	}

	void xorText(byte[][] text, byte[][] key){// TODO: test
		for (int i = 0; i < BLOCKSIZE; i++){
			text[i/ BLOCKLENGTH][i% BLOCKLENGTH] ^= key[i/ BLOCKLENGTH][i% BLOCKLENGTH];
		}
	}
}
