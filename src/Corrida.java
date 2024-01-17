public class Corrida {


    public void MainRace(Car c1) {

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

}
