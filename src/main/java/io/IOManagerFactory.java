package io;

public class IOManagerFactory {
    public static IOManager create(){
        return new IOManagerImpl();
    }
}
