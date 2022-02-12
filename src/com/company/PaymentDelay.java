package com.company;

public class PaymentDelay {
    public Integer money;
    public Integer dayDelay;
    public Boolean touchedByPlayer;
    public  Boolean gottenBySeller;
public String level;
    public PaymentDelay(Integer money, Integer dayDelay,String level, Boolean touchedByPlayer,Boolean gottenBySeller) {
        this.money = money;
        this.dayDelay = dayDelay;
        this.level=level;
        this.touchedByPlayer=touchedByPlayer;
        this.gottenBySeller=false;

    }


    public String toString() {
        return "PaymentDelay{" +
                "money=" + money +
                ", dayDelay=" + dayDelay +
                '}';
    }
}
