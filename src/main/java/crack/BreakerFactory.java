package crack;

public class BreakerFactory {
    public static Breaker create(){
        return new BreakerImpl();
    }

}
