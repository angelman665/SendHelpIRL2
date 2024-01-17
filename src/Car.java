public class Car {
    String name;
    int speed;
    int currentSpeed = 0;
    int maxAcceleration = 10;
    int minAcceleration = 1;
    int upgrades = 0;

    public Car(String name, int speed, int currentSpeed, int maxAcceleration, int minAcceleration, int upgrades) {
        this.name = name;
        this.speed = speed;
        this.currentSpeed = currentSpeed;
        this.maxAcceleration = maxAcceleration;
        this.minAcceleration = minAcceleration;
        this.upgrades = upgrades;
    }


}
