import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida();
        Menus menus = new Menus();
        Scanner scan = new Scanner(System.in);
        Player player = new Player(Money.VALUE_0);


        int opc = 0, count = 0, custoUpgrade = 100, opcCprincipal = 0, opcCrua = 0, countcount = 0;
        boolean again = true, again2 = true;

        // 1º MENU - ESCOLHER CARRO - CRIAÇÃO DE CARRO
        do {
            count = 0;
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 -        Subaru");
            System.out.println("2 -        BMW");
            System.out.println("3 -        Audi");
            //System.out.println("4 -        Personalizado");
            opc = scan.nextInt();

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


        opc = 0;

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
            opc = scan.nextInt();

            switch (opc) {
                // MENU DE CORRIDAS PRINCIPAIS
                case 1:
                    while (again) {


                        menus.MenuCorridaPrincipal();
                        opcCprincipal = scan.nextInt();

                        if (opcCprincipal >= 1 && opcCprincipal < 6) {
                            corrida.MainRace(player, player.car, opcCprincipal);
                            break;
                        } else if (opcCprincipal == 6) {
                            again = false;
                            break;
                        } else {
                            System.out.println("\nEscolha uma opção valida");
                        }

                    }
                    break;
                // MENU DE CORRIDAS DE RUA
                case 2:
                    while (again2) {

                        menus.MenuCorridaRua();
                        opcCrua = scan.nextInt();

                        if (opcCrua >= 1 && opcCrua < 4) {
                            corrida.StreetRace(player, opcCrua);
                            break;
                        } else if (opcCrua == 4) {
                            again2 = false;
                            break;
                        } else {
                            System.out.println("\nEscolha uma opção valida");

                        }
                    }
                    break;


                case 3:
                    if (player.getMoney().getAmount() >= custoUpgrade) {
                        corrida.UpdateCar(player.car);
                        player.deductMoney(custoUpgrade);
                        custoUpgrade += 100;
                        System.out.println("\nUpgrade Feito com sucesso, proximo upgrade custa: " + custoUpgrade);
                    } else {
                        System.out.println("\nSem dinheiro para upgrade.");
                        System.out.println("Proximo upgrade custa: " + custoUpgrade);
                    }
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
                    opc = 0;
                    break;

            }


        } while (countcount == 0);


    }

    public static void clearConsole() {
        // Number of newlines to clear the console (adjust as needed)
        int linesToClear = 50;

        for (int i = 0; i < linesToClear; i++) {
            System.out.println();
        }
    }


}
