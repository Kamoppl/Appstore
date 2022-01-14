package com.company;

import Projects.AllProjects;
import Projects.Project;

public class Player {
    public String name;
    public Integer money = 1000;
    public Integer employee;
    public Integer availableProject=0;
    public Integer daySpentOnLookingForEmployee = 0;



    public Player(String name, Integer money, Integer employee, Integer availableProject, Integer daySpentOnLookingForEmployee) {
        this.name = name;
        this.money = money=1000;
        this.employee = employee=0;
        this.availableProject = availableProject=0;
        this.daySpentOnLookingForEmployee = daySpentOnLookingForEmployee=0;
    }



    public void signProject() {
        if (availableProject > 0) {
            showAvailableProjects();
        } else {
            System.out.println("Nie ma dostępnych projektów");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "Imie='" + name + '\'' +
                ", Hajs=" + money +
                ", Prawcownicy=" + employee +
                ", Ilość dostępnych projektów=" + availableProject +
                '}';
    }

    public void showAvailableProjects() {
        System.out.println(availableProject);
    }

    public void getEmployee() {
        if (daySpentOnLookingForEmployee == 5) {
            employee = employee + 1;
            daySpentOnLookingForEmployee = 0;

        } else {
            daySpentOnLookingForEmployee = daySpentOnLookingForEmployee + 1;
        }


    }

}