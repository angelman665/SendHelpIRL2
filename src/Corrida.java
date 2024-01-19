import java.util.Random;

public class Corrida implements ICorrida {

    Random rand = new Random();
    Car cars[] = new Car[5];
    int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

    public void MainRace(Player player, Car c1, int c2) {
        CarInit();
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

    int sRaceCounter = 0;

    public void StreetRace(Player player, int opc) {
        player.car.currentSpeed = 0;

        if (opc == 1) {
            StreetRaceCalculator(player.car, opc);
            if (sRaceCounter == 0)
                player.addMoney(50);
            else if (sRaceCounter == 1)
                player.addMoney(100);
        } else if (opc == 2) {
            StreetRaceCalculator(player.car, opc);
            if (sRaceCounter == 0)
                player.addMoney(250);
            else if (sRaceCounter == 1)
                player.addMoney(500);
        } else if (opc == 3) {
            StreetRaceCalculator(player.car, opc);
            if (sRaceCounter == 0)
                player.addMoney(500);
            else if (sRaceCounter == 1)
                player.addMoney(1000);
        }

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


            cars[cpu - 1].currentSpeed += (int) Math.floor(Math.random() * (cars[cpu - 1].maxAcceleration - cars[cpu - 1].minAcceleration + 1) + cars[cpu - 1].minAcceleration);
            if (cars[cpu - 1].currentSpeed > cars[cpu - 1].speed)
                cars[cpu - 1].currentSpeed = cars[cpu - 1].speed;

            cpuDistance = cpuDistance + cars[cpu - 1].currentSpeed;


            System.out.println("Player Speed= " + c1.currentSpeed);
            System.out.println("CPU Speed= " + cars[cpu - 1].currentSpeed);
            System.out.println("-----------------------------------");


        }
        if (playerDistance > cpuDistance) {
            System.out.println("VITORIA");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);
            if (count1 == 0 && cpu == 1) {
                System.out.println("################");
                System.out.println("PREMIO = 500€");
                System.out.println("################");
                count1++;
            } else if (count2 == 0 && cpu == 2) {
                System.out.println("################");
                System.out.println("PREMIO = 1000€");
                System.out.println("################");
                count2++;
            } else if (count3 == 0 && cpu == 3) {
                System.out.println("################");
                System.out.println("PREMIO = 1500€");
                System.out.println("################");
                count3++;

            } else if (count4 == 0 && cpu == 4) {
                System.out.println("################");
                System.out.println("PREMIO = 2000€");
                System.out.println("################");
                count4++;

            } else if (count5 == 0 && cpu == 5) {
                System.out.println("################");
                System.out.println("PREMIO = 2500€");
                System.out.println("################");
                count5++;

            }

        } else if (cpuDistance > playerDistance) {
            System.out.println("PERDESTE");
            System.out.println("Player Distance: " + playerDistance);
            System.out.println("CPU Distance: " + cpuDistance);
        } else
            System.out.println("EMPATE");
    }


    /*
        public void RaceCalculator(Car c1, int cpu) {
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


                cars[cpu - 1].currentSpeed += (int) Math.floor(Math.random() * (cars[cpu - 1].maxAcceleration - cars[cpu - 1].minAcceleration + 1) + cars[cpu - 1].minAcceleration);
                if (cars[cpu - 1].currentSpeed > cars[cpu - 1].speed)
                    cars[cpu - 1].currentSpeed = cars[cpu - 1].speed;

                cpuDistance = cpuDistance + cars[cpu - 1].currentSpeed;


                System.out.println("Player Speed= " + c1.currentSpeed);
                System.out.println("CPU Speed= " + cars[cpu - 1].currentSpeed);
                System.out.println("-----------------------------------");


            }
            if (playerDistance > cpuDistance) {
                System.out.println("VITORIA");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                if (count1 == 0 && cpu == 1) {
                    System.out.println("################");
                    System.out.println("PREMIO = 500€");
                    System.out.println("################");
                    count1++;
                } else if (count2 == 0 && cpu == 2) {
                    System.out.println("################");
                    System.out.println("PREMIO = 1000€");
                    System.out.println("################");
                    count2++;
                } else if (count3 == 0 && cpu == 3) {
                    System.out.println("################");
                    System.out.println("PREMIO = 1500€");
                    System.out.println("################");
                    count3++;

                } else if (count4 == 0 && cpu == 4) {
                    System.out.println("################");
                    System.out.println("PREMIO = 2000€");
                    System.out.println("################");
                    count4++;

                } else if (count5 == 0 && cpu == 5) {
                    System.out.println("################");
                    System.out.println("PREMIO = 2500€");
                    System.out.println("################");
                    count5++;

                }

            } else if (cpuDistance > playerDistance) {
                System.out.println("PERDESTE");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
            } else
                System.out.println("EMPATE");


        }
    */
    public void CarInit() {
        cars[0] = new Car("FIAT", 120, 0, 10, 1, 0);
        cars[1] = new Car("AUDI", 160, 0, 14, 4, 0);
        cars[2] = new Car("BMW", 220, 0, 19, 9, 0);
        cars[3] = new Car("MUSTANG", 280, 0, 23, 13, 0);
        cars[4] = new Car("FERRARI", 315, 0, 28, 20, 0);
    }

    private void StreetRaceCalculator(Car c1, int opc) {
        int playerDistance = 0, cpuDistance = 0, maxDistance = 0;
        sRaceCounter = 0;

        if (opc == 1) {
            maxDistance = 500;

            Car easyCar = new Car("EASYCAR", 100, 0, 9, 1, 0);


            while (playerDistance < maxDistance && cpuDistance < maxDistance) {

                c1.currentSpeed += (int) Math.floor(Math.random() * (c1.maxAcceleration - c1.minAcceleration + 1) + c1.minAcceleration);
                if (c1.currentSpeed > c1.speed)
                    c1.currentSpeed = c1.speed;

                playerDistance = playerDistance + c1.currentSpeed;


                easyCar.currentSpeed += (int) Math.floor(Math.random() * (easyCar.maxAcceleration - easyCar.minAcceleration + 1) + easyCar.minAcceleration);
                if (easyCar.currentSpeed > easyCar.speed)
                    easyCar.currentSpeed = easyCar.speed;

                cpuDistance = cpuDistance + easyCar.currentSpeed;


                System.out.println("Player Speed= " + c1.currentSpeed);
                System.out.println("CPU Speed= " + easyCar.currentSpeed);
                System.out.println("-----------------------------------");
            }

            if (playerDistance > cpuDistance) {
                System.out.println("\nVITORIA");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);

                System.out.println("\n################");
                System.out.println("PREMIO = 100€");
                System.out.println("################");
                sRaceCounter++;
            } else if (cpuDistance > playerDistance) {
                System.out.println("\nPERDESTE");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                sRaceCounter--;
            } else {
                System.out.println("\nEMPATE");
                System.out.println("\n################");
                System.out.println("PREMIO = 50€");
                System.out.println("################");
            }


        } else if (opc == 2) {
            maxDistance = 1500;
            Car midCar = new Car("MIDCAR", 200, 0, 17, 10, 0);
            while (playerDistance < maxDistance && cpuDistance < maxDistance) {

                c1.currentSpeed += (int) Math.floor(Math.random() * (c1.maxAcceleration - c1.minAcceleration + 1) + c1.minAcceleration);
                if (c1.currentSpeed > c1.speed)
                    c1.currentSpeed = c1.speed;

                playerDistance = playerDistance + c1.currentSpeed;


                midCar.currentSpeed += (int) Math.floor(Math.random() * (midCar.maxAcceleration - midCar.minAcceleration + 1) + midCar.minAcceleration);
                if (midCar.currentSpeed > midCar.speed)
                    midCar.currentSpeed = midCar.speed;

                cpuDistance = cpuDistance + midCar.currentSpeed;


                System.out.println("Player Speed= " + c1.currentSpeed);
                System.out.println("CPU Speed= " + midCar.currentSpeed);
                System.out.println("-----------------------------------");
            }

            if (playerDistance > cpuDistance) {
                System.out.println("\nVITORIA");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                System.out.println("\n################");
                System.out.println("PREMIO = 500€");
                System.out.println("################");
                sRaceCounter++;
            } else if (cpuDistance > playerDistance) {
                System.out.println("\nPERDESTE");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                sRaceCounter--;
            } else {
                System.out.println("\nEMPATE");
                System.out.println("\n################");
                System.out.println("PREMIO = 250€");
                System.out.println("################");
            }
        } else {
            maxDistance = 2000;
            Car hardCar = new Car("HARDCAR", 300, 0, 25, 15, 0);
            while (playerDistance < maxDistance && cpuDistance < maxDistance) {

                c1.currentSpeed += (int) Math.floor(Math.random() * (c1.maxAcceleration - c1.minAcceleration + 1) + c1.minAcceleration);
                if (c1.currentSpeed > c1.speed)
                    c1.currentSpeed = c1.speed;

                playerDistance = playerDistance + c1.currentSpeed;


                hardCar.currentSpeed += (int) Math.floor(Math.random() * (hardCar.maxAcceleration - hardCar.minAcceleration + 1) + hardCar.minAcceleration);
                if (hardCar.currentSpeed > hardCar.speed)
                    hardCar.currentSpeed = hardCar.speed;

                cpuDistance = cpuDistance + hardCar.currentSpeed;


                System.out.println("Player Speed= " + c1.currentSpeed);
                System.out.println("CPU Speed= " + hardCar.currentSpeed);
                System.out.println("-----------------------------------");
            }

            if (playerDistance > cpuDistance) {
                System.out.println("\nVITORIA");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                System.out.println("\n################");
                System.out.println("PREMIO = 1000€");
                System.out.println("################");
                sRaceCounter++;
            } else if (cpuDistance > playerDistance) {
                System.out.println("\nPERDESTE");
                System.out.println("Player Distance: " + playerDistance);
                System.out.println("CPU Distance: " + cpuDistance);
                sRaceCounter--;
            } else {
                System.out.println("\nEMPATE");
                System.out.println("\n################");
                System.out.println("PREMIO = 500€");
                System.out.println("################");
            }
        }


    }

}
