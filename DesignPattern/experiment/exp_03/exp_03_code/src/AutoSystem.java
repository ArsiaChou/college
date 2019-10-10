import car.AbstractCar;
import car.Ford;
import car.Honda;
import car.Jeep;

public class AutoSystem {
    public void autoDrive(AbstractCar car) {
        car.drive();
    }

    public static void main(String[] args) {
        AutoSystem autoSystem = new AutoSystem();

        autoSystem.autoDrive(new Ford());
        autoSystem.autoDrive(new Honda());
        autoSystem.autoDrive(new Jeep());
    }
}
