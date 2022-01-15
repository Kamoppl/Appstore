package com.company;

import Projects.AllProjects;
import Projects.Project;

import java.util.ArrayList;

public class Player {
    public String name;
    public Integer money = 1000;
    public Integer employee;
    public Integer availbleProjectDays = 0;
    public Integer daySpentOnLookingForEmployee = 0;
    public ArrayList project;


    public Player(String name, Integer money, Integer employee, Integer availbleProjectDays, Integer daySpentOnLookingForEmployee) {
        this.name = name;
        this.money = money = 1000;
        this.employee = employee = 0;
        this.availbleProjectDays = Player.this.availbleProjectDays = 0;
        this.daySpentOnLookingForEmployee = daySpentOnLookingForEmployee = 0;
    }


    public void signProject() {
        if (availbleProjectDays > 0) {
            showavailbleProjectDayss();
        } else {
            System.out.println("Nie ma dostępnych projektów");
        }
    }

    @Override
    public String toString() {
        if (project != null)
            return

                    "\n" + "Player{" +
                            "name='" + name + '\'' +
                            ", money=" + money +
                            ", employee=" + employee +
                            ", availbleProjectDays=" + availbleProjectDays +
                            ", daySpentOnLookingForEmployee=" + daySpentOnLookingForEmployee +
                            ", project=" + project +
                            '}';
        else {
            return
                    "\n" + "Player{" +
                            "name='" + name + '\'' +
                            ", money=" + money +
                            ", employee=" + employee +
                            ", availbleProjectDays=" + availbleProjectDays +
                            ", daySpentOnLookingForEmployee=" + daySpentOnLookingForEmployee +
                            '}';
        }
    }

    public void showavailbleProjectDayss() {
        System.out.println(availbleProjectDays);
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