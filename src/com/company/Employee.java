package com.company;

public class Employee {
    public Integer employee = 0;
    public Integer freeEmployee = 0;

    public void getEmplyee() {
        if (freeEmployee > 0) {
            employee = employee + 1;
        }
    }
}
