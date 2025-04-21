package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        ride(taxi);
        System.out.println();
        ride(bus);
    }

    public static void ride(Vehicle vehicle) {
        // checkFare는 Bus 클래스에만 있기 때문에 instanceof로 타입 체크
        // 방법1
        /*
            if(vehicle instanceof Bus) {
            Bus bus = (Bus) vehicle;
            bus.checkFare(); }
        */

        // 방법2
        // instanceof로 
        if (vehicle instanceof Bus bus) {
            bus.checkFare();
        }
        vehicle.run();
    }
}