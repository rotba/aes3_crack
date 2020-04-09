package aes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testUtils.InputsGenerator;

import static org.junit.Assert.*;

public class AES3ImplTest {
	private AES3Impl impl;

	@Before
	public void setUp(){
		impl = new AES3Impl();
	}

	@After
	public void tearDown(){
		impl = null;
	}

	@Test
	public void encrypt() {

	}
//
//	@Test
//	public void decrypt() {
//	}

	@Test
	public void shiftColumns(){
		byte[] input = InputsGenerator.ascending();
		byte[] output = InputsGenerator.shifted();
		byte[][][] split = impl.split(input);
		byte[][][] result = impl.split(output);
		for (int i = 0; i< split.length; i++){
			impl.shiftColumns(split[i]);
			assertArrayEquals(split[i], result[i]);
		}
	}

	@Test
	public void shiftBackColumns(){
		byte[] input = InputsGenerator.ascending();
		byte[] output = InputsGenerator.shifted();
		byte[][][] split = impl.split(output);
		byte[][][] result = impl.split(input);
		for (int i = 0; i< split.length; i++){
			impl.shiftBackColumns(split[i]);
			assertArrayEquals(split[i], result[i]);
		}
	}

	@Test
	public void xorTextZeros(){
		byte[] input = InputsGenerator.ct1();
		byte[] key = InputsGenerator.ct1();
		byte[] output = InputsGenerator.ct1();
		byte[][][] split = impl.split(input);
		byte[][][] result = impl.split(output);
		byte[][][] xor = impl.split(key);
		for (int i = 0; i< split.length; i++){
			impl.xorText(split[i], xor[i]);
			assertArrayEquals(split[i], result[i]);
		}
	}
}