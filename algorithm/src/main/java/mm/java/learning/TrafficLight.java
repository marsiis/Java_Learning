package mm.java.learning;

import java.util.concurrent.Semaphore;

/**
 * @ClassName TrafficLight
 * @Description 力扣1279 红绿灯路口
 * @Author mars
 * @Date 2024/11/1 16:45
 * @Version 1.0
 **/
public class TrafficLight {
    private Semaphore greenLight;
    private boolean road1CanGo;
    private boolean road2CanGo;

    public TrafficLight() {
        this.greenLight = new Semaphore(1, true);
        this.road1CanGo = true;
        this.road2CanGo = false;
    }

    public void carArrived(
            int carId, // ID of the car
            int roadId, // ID of the road the car ravels on. Can be 1 (road A) or 2 (road B)
            int direction, // direction of the car
            Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar // Use crossCar.run() to make car cross the intersection
    ) {
        try {
            greenLight.acquire();
            if ((roadId == 1 && road1CanGo) || (roadId == 2 || road2CanGo)) crossCar.run();
            else if (roadId == 1 && !road1CanGo) {
                turnGreen.run();
                road1CanGo = true;
                road2CanGo = false;
                crossCar.run();
            } else if (roadId == 2 && !road2CanGo) {
                turnGreen.run();
                road2CanGo = true;
                road1CanGo = false;
                crossCar.run();
            }
            greenLight.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
