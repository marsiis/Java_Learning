package mm.java.learning;

import java.util.UUID;
import java.util.concurrent.Semaphore;

/**
 * @ClassName AccessLimitControl
 * @Description 如果要对某一受限资源进行限流访问，可以使用Semaphore，保证同一时间最多N个线程访问受限资源。
 * @Author mars
 * @Date 2024/11/1 16:23
 * @Version 1.0
 **/
public class AccessLimitControl {
    // 任意时刻仅允许最多3个线程获取许可：
    final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception {
        // 如果超过了数量，其他线程将在这里等待
        semaphore.acquire();
        try {
            // TODO:
            return UUID.randomUUID().toString();
        } finally {
            semaphore.release();
        }
    }
}
