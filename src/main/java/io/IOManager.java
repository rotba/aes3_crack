package io;

import java.io.IOException;

public interface IOManager {
    public byte[] read(String path) throws IOException;
    public void write(String path, byte[] content) throws IOException;
}
