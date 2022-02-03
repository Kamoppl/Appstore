package com.company;

import java.security.SecureRandom;

public class Client {
    String ClientType;



    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Client() {
        this.ClientType = ClientTypeGet();
    }

    public String toString() {
        return  ClientType ;
    }
//tworzy losowego klienta
    static String ClientTypeGet() {
        int a = getRandomNumber(1, 9);
        String Name = null;
        if (a < 4) {
            Name = "Wyluzowany";
        }
        if (a > 3 && a < 7) {
            Name = "Wymagający";
        }
        if (a > 6 && a < 10) {
            Name = "Skurwiel";
        }
        return Name;
    }
}
