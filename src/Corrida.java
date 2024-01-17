import java.util.Random;

public class Corrida {
    Random rand = new Random();
    Car cars[] = new Car[5];

    public void MainRace(Car c1, int c2) {
        CarInit();

        switch (c2) {
            case 1:
                RaceCalculator(c1, 1);


                break;


            default:
                break;
        }


    }

    public void StreetRace(Car c1) {

    }

    public void UpdateCar(Car c1) {

        /*
        if (c1.upgrades == 0) {
            c1.upgrades = 1;
            c1.speed += 10;
            c1.maxAcceleration += 1;
            c1.minAcceleration += 1;
        } else if (c1.upgrades == 1) {
            c1.upgrades = 2;
            c1.speed += 10;
            c1.maxAcceleration += 1;
            c1.minAcceleration += 1;
        } else if (c1.upgrades == 2) {
            c1.upgrades = 3;
            c1.speed += 10;
            c1.maxAcceleration += 1;
            c1.minAcceleration += 1;
        } else if (c1.upgrades == 3) {
            c1.upgrades = 4;
            c1.speed += 10;
            c1.maxAcceleration += 1;
            c1.minAcceleration += 1;
        } else if (c1.upgrades == 4) {
            c1.upgrades = 5;
            c1.speed += 10;
            c1.maxAcceleration += 1;
            c1.minAcceleration += 1;
        }

         */


        if (c1.upgrades <= 19) {
            c1.upgrades++;
            c1.minAcceleration++;
            c1.maxAcceleration++;
            c1.speed += 10;
        } else if (c1.upgrades == 20) {

            System.out.println("Atingiu o maximo de upgrades");

        }

    }

    public void RaceCalculator(Car c1, int cpu) {
        int playerDistance = 0, cpuDistance = 0, maxDistance = 0;

        if (cpu == 1)
            maxDistance = 500;


        while (playerDistance < maxDistance && cpuDistance < maxDistance) {

            c1.currentSpeed += (int) Math.floor(Math.random() * (c1.maxAcceleration - c1.minAcceleration + 1) + c1.minAcceleration);
            if (c1.currentSpeed > c1.speed)
                c1.currentSpeed = c1.speed;

            playerDistance = playerDistance + c1.currentSpeed;


            cars[cpu - 1].currentSpeed += (int) Math.floor(Math.random() * (cars[cpu - 1].maxAcceleration - cars[cpu - 1].minAcceleration + 1) + cars[cpu - 1].minAcceleration);
            if (cars[cpu - 1].currentSpeed > cars[cpu - 1].speed)
                cars[cpu - 1].currentSpeed = cars[cpu - 1].speed;

            cpuDistance = cpuDistance + cars[cpu - 1].currentSpeed;

            /*
            System.out.println("\nPlayer distance: " + playerDistance);
            System.out.println("CPU distance: " + cpuDistance);
            System.out.println("\n-----------------------------------");
            */

            System.out.println("Player Speed= " + c1.currentSpeed);
            System.out.println("CPU Speed= " + cars[cpu - 1].currentSpeed);
            System.out.println("\n-----------------------------------");


        }
        if (playerDistance > cpuDistance) {
            System.out.println("\nVITORIA");
            System.out.println("\nPlayer Distance: " + playerDistance);
            System.out.println("\nCPU Distance: " + cpuDistance);
        } else if (cpuDistance > playerDistance) {
            System.out.println("\nPERDESTE");
            System.out.println("\nPlayer Distance: " + playerDistance);
            System.out.println("\nCPU Distance: " + cpuDistance);
        } else
            System.out.println("EMPATE");


    }

    public void CarInit() {
        cars[0] = new Car("FIAT", 100, 9, 1, 0, 0);
        cars[1] = new Car("AUDI", 160, 14, 4, 0, 0);
        cars[2] = new Car("BMW", 220, 19, 9, 0, 0);
        cars[3] = new Car("MUSTANG", 280, 23, 13, 0, 0);
        cars[4] = new Car("FERRARI", 315, 28, 20, 0, 0);
    }

}
