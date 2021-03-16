import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:yaobin
 * @date:2021/3/14,16:30
 */

public class Test {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
//        atomicInteger.compareAndSet( );
        atomicInteger.getAndIncrement();
    }
}
