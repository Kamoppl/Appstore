package com.company;
public class Client {
    String ClientType;



    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Client() {
        int a = getRandomNumber(1, 9);
        String Name = null;
        if (a < 4) {
            this.ClientType  = "Wyluzowany";
        }
        if (a > 3 && a < 7) {
            this.ClientType  = "Wymagający";
        }
        if (a > 6 && a < 10) {
            this.ClientType  = "Skurwiel";
        }

    }


    @Override
    public String toString() {
        return "Client{" +
                "ClientType='" + ClientType + '\'' +
                '}';
    }
}
