import java.util.Random;

public class Corrida implements ICorrida {


    int custoUpgrade = 100;

    //void RaceCalculator(Player p1, int cpu, Car c2);
        /*
        int playerDistance = 0, cpuDistance = 0, maxDistance = 0;

        if (cpu == 1)
            maxDistance = 500;
        else if (cpu == 2) {
            maxDistance = 1000;
        } else if (cpu == 3) {
            maxDistance = 1500;
        } else if (cpu == 4) {
            maxDistance = 2000;
        } else if (cpu == 5) {
            maxDistance = 2500;
        }


        while (playerDistance < maxDistance && cpuDistance < maxDistance) {

            c1.currentSpeed += (int) Math.floor(Math.random() * (c1.maxAcceleration - c1.minAcceleration + 1) + c1.minAcceleration);
            if (c1.currentSpeed > c1.speed)
                c1.currentSpeed = c1.speed;

            playerDistance = playerDistance + c1.currentSpeed;


            c2.currentSpeed += (int) Math.floor(Math.random() * (c2.maxAcceleration - c2.minAcceleration + 1) + c2.minAcceleration);
            if (c2.currentSpeed > c2.speed)
                c2.currentSpeed = c2.speed;

            cpuDistance = cpuDistance + c2.currentSpeed;


            System.out.println("Player Speed= " + c1.currentSpeed + "Km/h");
            System.out.println("CPU Speed= " + c2.currentSpeed + "Km/h");
            System.out.println("-----------------------------------");


        }
        if (playerDistance > cpuDistance) {
            System.out.println("VITORIA");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);

        } else if (cpuDistance > playerDistance) {
            System.out.println("PERDESTE");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);
        } else
            System.out.println("EMPATE");
            */


    @Override
    public void RaceCalculator(Player p1, int cpu, Car c2) {

    }

    public void UpdateCar(Player p1) {


        if (p1.car.upgrades == 20) {
            System.out.println("Atingiu o maximo de upgrades");
        } else if (p1.getMoney().getAmount() >= custoUpgrade) {
            int a, b, c;
            a = p1.car.speed;
            b = p1.car.maxAcceleration;
            c = p1.car.minAcceleration;


            p1.deductMoney(custoUpgrade);
            custoUpgrade += 100;

            p1.car.upgrades++;
            p1.car.minAcceleration++;
            p1.car.maxAcceleration++;
            p1.car.speed += 10;

            System.out.println("#######");
            System.out.println("Upgrade Feito com sucesso, proximo upgrade custa: " + custoUpgrade);
            System.out.println("\nVELOCIDADE MAX: " + a + "---> VELOCIDADE MAX: " + p1.car.speed);
            System.out.println("Aceleração MAX: " + b + "---> Aceleração MAX: " + p1.car.maxAcceleration);
            System.out.println("Aceleração MIN: " + c + "---> Aceleração MIN: " + p1.car.minAcceleration);
            System.out.println("#######");
        } else {
            System.out.println("\nSem dinheiro para upgrade.");
            System.out.println("Proximo upgrade custa: " + custoUpgrade);
        }


    }


}
