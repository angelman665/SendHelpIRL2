import java.util.Scanner;

class Car {
    String name;
    int speed;
    int currentSpeed = 0;
    int maxAcceleration = 10;
    int minAcceleration = 1;
    int upgrades = 0;

    public Car(String name, int speed, int maxAcceleration, int minAcceleration, int upgrades, int currentSpeed) {
        this.name = name;
        this.speed = speed;
        this.maxAcceleration = maxAcceleration;
        this.minAcceleration = minAcceleration;
        this.upgrades = upgrades;
        this.currentSpeed = currentSpeed;
    }
}

class Player {
    Car car;
    int raceWins = 0;
    int money = 0;
}


public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida();
        Menus menus = new Menus();
        Scanner scan = new Scanner(System.in);
        Player player = new Player();


        int opc = 0, count = 0, custoUpgrade = 100, opcCprincipal = 0, opcCrua = 0;
        boolean again = true;


        do {
            count = 0;
            System.out.println("\nEscolha uma opção: ");
            System.out.println("\n1 -        Subaru");
            System.out.println("\n2 -        BMW");
            System.out.println("\n3 -        Audi");
            System.out.println("\n4 -        Personalizado");
            opc = scan.nextInt();

            switch (opc) {
                case 1:

                    player.car = new Car("SUBARU", 120, 10, 1, 0, 0);
                    count++;
                    break;
                case 2:
                    player.car = new Car("BMW", 120, 10, 1, 0, 0);
                    count++;
                    break;
                case 3:
                    player.car = new Car("AUDI", 120, 10, 1, 0, 0);
                    count++;
                    break;
                case 4:
                    System.out.println("Nome do carro: ");
                    player.car = new Car(scan.nextLine(), 120, 10, 1, 0, 0);
                    count++;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }


        } while (count == 0);


        opc = 0;

        do {
            menus.MenuPrincipal();
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    while (again) {
                        again = false;

                        menus.MenuCorridaPrincipal();
                        opcCprincipal = scan.nextInt();

                        if (opcCprincipal >= 1 && opcCprincipal < 6) {
                            corrida.MainRace(player.car, opcCprincipal);
                        } else if (opcCprincipal == 6) {
                            break;
                        } else {
                            System.out.println("\nEscolha uma opção valida");
                            again = true;
                        }
                        break;
                    }

                case 2:
                    menus.MenuCorridaRua();
                    break;
                case 3:
                    if (player.money >= custoUpgrade) {
                        corrida.UpdateCar(player.car);
                        custoUpgrade += 50;
                        System.out.println("\nUpgrade Feito com sucesso, proximo upgrade custa: " + custoUpgrade);
                    } else {
                        System.out.println("\nSem dinheiro para upgrade.");
                        System.out.println("\nProximo upgrade custa: " + custoUpgrade);
                    }
                    break;

            }


        } while (opc == 0);


    }
}
