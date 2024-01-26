import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida();
        Menus menus = new Menus();
        Scanner scan = new Scanner(System.in);
        Player player = new Player(Money.VALUE_0);
        MainRace mainRace = new MainRace();
        StreetRace streetRace = new StreetRace();

        Car cars[] = new Car[5];
        Car streetCars[] = new Car[3];

        cars[0] = new Car("FIAT", 120, 0, 10, 1, 0);
        cars[1] = new Car("AUDI", 160, 0, 14, 4, 0);
        cars[2] = new Car("BMW", 220, 0, 19, 9, 0);
        cars[3] = new Car("MUSTANG", 280, 0, 23, 13, 0);
        cars[4] = new Car("FERRARI", 315, 0, 28, 20, 0);

        streetCars[0] = new Car("EASYCAR", 100, 0, 9, 1, 0);
        streetCars[1] = new Car("MIDCAR", 200, 0, 17, 10, 0);
        streetCars[2] = new Car("HARDCAR", 300, 0, 25, 15, 0);


        int opc = 0, count = 0, opcCprincipal = 0, opcCrua = 0, countcount = 0;

        // 1º MENU - ESCOLHER CARRO - CRIAÇÃO DE CARRO
        do {
            count = 0;
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 -        Subaru");
            System.out.println("2 -        BMW");
            System.out.println("3 -        Audi");
            //System.out.println("4 -        Personalizado");

            do {
                while (!scan.hasNextInt()) {
                    System.out.println("Opção invalida");
                    scan.next();
                }
                opc = scan.nextInt();
            } while (opc <= 0);


            //CRIAÇÃO DE CARRO PARA PLAYER
            switch (opc) {
                case 1:

                    player.car = new Car("SUBARU", 120, 0, 10, 1, 0);
                    count++;
                    break;
                case 2:
                    player.car = new Car("BMW", 120, 0, 10, 1, 0);
                    count++;
                    break;
                case 3:
                    player.car = new Car("AUDI", 120, 0, 10, 1, 0);
                    count++;
                    break;
                    /*
                case 4:
                    //scan.close();
                    System.out.println("Nome do carro: ");
                    String abc = scan.nextLine();
                    player.car = new Car(abc, 120, 0, 10, 1, 0);
                    count++;
                    break
                    */
                default:
                    System.out.println("Opção invalida");
                    break;
            }


        } while (count == 0);


        // DO WHILE DE MENUS
        do {
            // MOSTRA MENU PRINCIPAL

            menus.MenuPrincipal();

            System.out.println("######");
            System.out.println("Carro: " + player.car.name);
            if (player.getMoney() != null)
                System.out.println("Money: " + player.getMoney().getAmount());
            System.out.println("Upgrades: " + player.car.upgrades + " / 20");
            System.out.println("######");

            do {
                while (!scan.hasNextInt()) {
                    System.out.println("Opção invalida");
                    scan.next();
                }
                opc = scan.nextInt();
            } while (opc <= 0);


            switch (opc) {
                // MENU DE CORRIDAS PRINCIPAIS
                case 1:
                    menus.MenuCorridaPrincipal();
                    do {
                        while (!scan.hasNextInt()) {
                            System.out.println("Opção invalida");
                            scan.next();
                        }
                        opcCprincipal = scan.nextInt();
                    } while (opcCprincipal <= 0);

                    if (opcCprincipal >= 1 && opcCprincipal < 6) {
                        mainRace.RaceCalculator(player, opcCprincipal, cars[opcCprincipal - 1]);
                        break;
                    } else {
                        System.out.println("Opção invalida");
                        break;
                    }

                    // MENU DE CORRIDAS DE RUA
                case 2:
                    menus.MenuCorridaRua();
                    do {
                        while (!scan.hasNextInt()) {
                            System.out.println("Opção invalida");
                            scan.next();
                        }
                        opcCrua = scan.nextInt();
                    } while (opcCrua <= 0);


                    if (opcCrua >= 1 && opcCrua < 4) {
                        streetRace.RaceCalculator(player, opcCrua, streetCars[opcCrua - 1]);
                        break;
                    } else {
                        System.out.println("Opção invalida");
                        break;
                    }


                case 3:
                    corrida.UpdateCar(player);
                    break;

                case 4:
                    System.out.println("CARRO: " + player.car.name);
                    System.out.println("VELOCIDADE MAX: " + player.car.speed);
                    System.out.println("Aceleração MAX: " + player.car.maxAcceleration);
                    System.out.println("Aceleração MIN: " + player.car.minAcceleration);
                    System.out.println("Upgrades: " + player.car.upgrades);
                    break;
                case 5:
                    countcount = 1;
                    break;
                default:
                    System.out.println("\nESCOLHA UMA OPÇÃO VALIDA");

                    break;

            }


        } while (countcount == 0);


    }


}
