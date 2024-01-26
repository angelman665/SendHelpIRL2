public class StreetRace extends Corrida {

    @Override
    public void RaceCalculator(Player p1, int cpu, Car c2) {
        int playerDistance = 0, cpuDistance = 0, maxDistance = 0;
        p1.car.currentSpeed = 0;
        c2.currentSpeed = 0;

        if (cpu == 1)
            maxDistance = 500;
        else if (cpu == 2)
            maxDistance = 1500;
        else if (cpu == 3)
            maxDistance = 2000;


        while (playerDistance < maxDistance && cpuDistance < maxDistance) {

            p1.car.currentSpeed += (int) Math.floor(Math.random() * (p1.car.maxAcceleration - p1.car.minAcceleration + 1) + p1.car.minAcceleration);
            if (p1.car.currentSpeed > p1.car.speed)
                p1.car.currentSpeed = p1.car.speed;

            playerDistance = playerDistance + p1.car.currentSpeed;


            c2.currentSpeed += (int) Math.floor(Math.random() * (c2.maxAcceleration - c2.minAcceleration + 1) + c2.minAcceleration);
            if (c2.currentSpeed > c2.speed)
                c2.currentSpeed = c2.speed;

            cpuDistance = cpuDistance + c2.currentSpeed;


            System.out.println("Player Speed= " + p1.car.currentSpeed + "Km/h");
            System.out.println("CPU Speed= " + c2.currentSpeed + "Km/h");
            System.out.println("-----------------------------------");


        }
        if (playerDistance > cpuDistance) {
            System.out.println("VITORIA");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);
            if (cpu == 1) {
                p1.addMoney(100);
                System.out.println("\n################");
                System.out.println("PREMIO = 100€");
                System.out.println("################");

            } else if (cpu == 2) {
                p1.addMoney(500);
                System.out.println("\n################");
                System.out.println("PREMIO = 500€");
                System.out.println("################");
            } else if (cpu == 3) {
                p1.addMoney(1000);
                System.out.println("\n################");
                System.out.println("PREMIO = 1000€");
                System.out.println("################");
            }

        } else if (cpuDistance > playerDistance) {
            System.out.println("PERDESTE");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);
        } else
            System.out.println("EMPATE");


    }
}
