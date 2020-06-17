// The Adapter pattern allows otherwise incompatible classes to work together by converting the interface of one class into an interface expected by the clients. 
// Socket wrenches provide an example of the Adapter. A socket attaches to a ratchet, provided that the size of the drive is the same. 


interface Moveable {
    double getSpeed(); // get speed in m/s
}

class BMW implements Moveable {

    @Override
    public double getSpeed() {
        return 50;
    }
}

interface MoveableAdapter {
    double getSpeed(); // get speed in mph
}

class MoveableAdapterImpl implements MoveableAdapter {

    private Movable car;

    public MoveableAdapterImpl(Moveable car) {
        this.car = car;
    }

    @Override
    public double getSpeed() {
        return convertMsToMph(car.getSpeed());
    }

    private double convertMsToMph(double ms) {
        return ms * 2.23694;
    }
}

public class AdapterDemo {

    public static void main(String[] args) {
        Moveable bmw = new BMW();
        MoveableAdapter moveableAdapter = new MoveableAdapterImpl(bmw);
        moveableAdapter.getSpeed(); // should be 111.85 mph
    }
} 

/* When to use? (From https://www.baeldung.com/java-adapter-pattern)
 * When an outside component provides captivating functionality that we'd like to reuse, but it's incompatible with our current application. 
 * A suitable Adapter can be developed to make them compatible with each other
 * When our application is not compatible with the interface that our client is expecting
 * When we want to reuse legacy code in our application without making any modification in the original code
 */