public class Player {

    Car car;
    int raceWins = 0;
    Money money;

    public Player(Car car, int raceWins, Money money) {
        this.car = car;
        this.raceWins = raceWins;
        this.money = money;
    }

    public Player() {

    }

    public Player(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void deductMoney(int amount) {
        int currentAmount = money.getAmount();
        int newAmount = currentAmount - amount;

        // Ensure the new amount is non-negative
        if (newAmount >= 0) {
            setMoney(getMoneyForAmount(newAmount));
        } else {
            System.out.println("Deduction failed. Insufficient funds.");
        }
    }


    public void addMoney(int amount) {
        int currentAmount = money.getAmount();
        int newAmount = currentAmount + amount;

        // Check if the new amount exceeds the maximum (5000)
        if (newAmount > 5000) {
            System.out.println("Warning: Money exceeds 5000. Setting to 5000.");
            newAmount = 5000;
        }

        setMoney(getMoneyForAmount(newAmount));
    }

    private Money getMoneyForAmount(int amount) {
        for (Money m : Money.values()) {
            if (m.getAmount() == amount) {
                return m;
            }
        }
        throw new IllegalArgumentException("No enum constant for amount: " + amount);
    }

}

