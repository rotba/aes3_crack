package io;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOManagerImpl implements IOManager {
	public byte[] read(String path) throws IOException {
		return IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
	}

	public void write(String path, byte[] content) throws IOException {
		IOUtils.write(content,Files.newOutputStream(Paths.get(path)));
	}
}
