public enum Money {

    VALUE_0(0),
    VALUE_100(100),
    VALUE_200(200),
    VALUE_300(300),
    VALUE_400(400),
    VALUE_500(500),
    VALUE_600(600),
    VALUE_700(700),
    VALUE_800(800),
    VALUE_900(900),
    VALUE_1000(1000),
    VALUE_1100(1100),
    VALUE_1200(1200),
    VALUE_1300(1300),
    VALUE_1400(1400),
    VALUE_1500(1500),
    VALUE_1600(1600),
    VALUE_1700(1700),
    VALUE_1800(1800),
    VALUE_1900(1900),
    VALUE_2000(2000),
    VALUE_2100(2100),
    VALUE_2200(2200),
    VALUE_2300(2300),
    VALUE_2400(2400),
    VALUE_2500(2500),
    VALUE_2600(2600),
    VALUE_2700(2700),
    VALUE_2800(2800),
    VALUE_2900(2900),
    VALUE_3000(3000),
    VALUE_3100(3100),
    VALUE_3200(3200),
    VALUE_3300(3300),
    VALUE_3400(3400),
    VALUE_3500(3500),
    VALUE_3600(3600),
    VALUE_3700(3700),
    VALUE_3800(3800),
    VALUE_3900(3900),
    VALUE_4000(4000),
    VALUE_4100(4100),
    VALUE_4200(4200),
    VALUE_4300(4300),
    VALUE_4400(4400),
    VALUE_4500(4500),
    VALUE_4600(4600),
    VALUE_4700(4700),
    VALUE_4800(4800),
    VALUE_4900(4900),
    VALUE_5000(5000);


    private final int amount;

    Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}