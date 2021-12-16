package com.company;

public class Employee {
    public Integer employee = 0;
    public Integer daySpentOnLookingForEmployee = 0;

    public void getEmployee() {
        if (daySpentOnLookingForEmployee == 5) {
            employee = employee + 1;
            daySpentOnLookingForEmployee = 0;

        } else {
            daySpentOnLookingForEmployee = daySpentOnLookingForEmployee + 1;
        }
    }
}
