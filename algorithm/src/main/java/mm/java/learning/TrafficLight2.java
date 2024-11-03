package mm.java.learning;

import java.util.concurrent.Semaphore;

/**
 * @ClassName TrafficLight
 * @Description 力扣1279 红绿灯路口
 * @Author mars
 * @Date 2024/11/1 16:45
 * @Version 1.0
 **/
public class TrafficLight2 {
    private volatile int road = 1;

    public TrafficLight2() {
    }

    public void carArrived(
            int carId, // ID of the car
            int roadId, // ID of the road the car ravels on. Can be 1 (road A) or 2 (road B)
            int direction, // direction of the car
            Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            if (road != roadId) {
                turnGreen.run();
                road = roadId;
            }
            crossCar.run();
        }
    }
}
