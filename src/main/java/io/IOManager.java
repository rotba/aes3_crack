package io;

import java.io.IOException;

public interface IOManager {
    byte[] read(String path) throws IOException;
    void write(String path, byte[] content) throws IOException;
}
