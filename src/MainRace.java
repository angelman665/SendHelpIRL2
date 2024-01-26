public class MainRace extends Corrida {
    //int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

    /*
    public void MainRacee(Player player, Car c1, int c2) {
        player.car.currentSpeed = 0;

        switch (c2) {
            case 1:
                RaceCalculator(c1, 1);
                if (count1 == 1) {
                    player.addMoney(500);
                    count1++;
                }
                break;
            case 2:
                RaceCalculator(c1, 2);
                if (count2 == 1) {
                    player.addMoney(1000);
                    count2++;
                }
                break;
            case 3:
                RaceCalculator(c1, 3);
                if (count3 == 1) {
                    player.addMoney(1500);
                    count3++;
                }
                break;
            case 4:
                RaceCalculator(c1, 4);
                if (count4 == 1) {
                    player.addMoney(2000);
                    count4++;
                }
                break;
            case 5:
                RaceCalculator(c1, 5);
                if (count5 == 1) {
                    player.addMoney(2500);
                    count5++;
                }
                break;

            default:
                break;
        }


    }
*/

    @Override
    public void RaceCalculator(Player p1, int cpu, Car c2) {
        int playerDistance = 0, cpuDistance = 0, maxDistance = 0;
        p1.car.currentSpeed = 0;
        c2.currentSpeed = 0;

        if (cpu == 1) {
            maxDistance = 500;

        } else if (cpu == 2) {
            maxDistance = 1000;

        } else if (cpu == 3) {
            maxDistance = 1500;

        } else if (cpu == 4) {
            maxDistance = 2000;

        } else if (cpu == 5) {
            maxDistance = 2500;

        }


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

            if (p1.raceWins == 0 && cpu == 1) {
                p1.addMoney(500);
                System.out.println("\n################");
                System.out.println("PREMIO = 500€");
                System.out.println("################");
                p1.raceWins++;
            } else if (p1.raceWins == 1 && cpu == 2) {
                p1.addMoney(1000);
                System.out.println("\n################");
                System.out.println("PREMIO = 1000€");
                System.out.println("################");
                p1.raceWins++;
            } else if (p1.raceWins == 2 && cpu == 3) {
                p1.addMoney(1500);
                System.out.println("\n################");
                System.out.println("PREMIO = 1500€");
                System.out.println("################");
                p1.raceWins++;
            } else if (p1.raceWins == 3 && cpu == 4) {
                p1.addMoney(2000);
                System.out.println("\n################");
                System.out.println("PREMIO = 2000€");
                System.out.println("################");
                p1.raceWins++;
            } else if (p1.raceWins == 4 && cpu == 5) {
                p1.addMoney(2500);
                System.out.println("\n################");
                System.out.println("PREMIO = 2500€");
                System.out.println("################");
                p1.raceWins++;
            } else {
                System.out.println("\n################");
                System.out.println("JÁ RECEBESTE O PRÉMIO UNICO");
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
