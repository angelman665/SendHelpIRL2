import java.util.Scanner;

class Car {
    String name;
    int speed;
    int maxAcceleration = 10;
    int minAcceleration = 0;
    int upgrades = 0;
}

class Player {
    Car car;
    int raceWins = 0;
    int money = 0;
}
//abcddasdsa

public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida();
        Menus menus = new Menus();
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        Car cars[] = new Car[10];
        int opc = 0, count = 0, custoUpgrade = 100, opcCprincipal = 0, opcCrua = 0;




        do {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("\n1 -        Subaru");
            System.out.println("\n2 -        BMW");
            System.out.println("\n3 -        Audi");
            System.out.println("\n4 -        Personalizado");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    player.car.name = "Subaru";
                    player.car.speed = 120;
                    count++;
                    break;
                case 2:
                    player.car.name = "BMW";
                    player.car.speed = 120;
                    count++;
                    break;
                case 3:
                    player.car.name = "Audi";
                    player.car.speed = 120;
                    count++;
                    break;
                case 4:
                    System.out.println("Nome do carro: ");
                    player.car.name = scan.nextLine();
                    player.car.speed = 120;
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
                    menus.MenuCorridaPrincipal();
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
