package mm.java.learning;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SequentialPrinting
 * @Description 力扣1114 按序打印
 * @Author mars
 * @Date 2024/11/4 8:42
 * @Version 1.0
 **/
public class SequentialPrinting {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public SequentialPrinting() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 0) {

        }
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 0) {

        }
        printThird.run();
    }

}
