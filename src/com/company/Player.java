package com.company;

import Projects.Project;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.*;

public class Player {
    public static int day = 1;
    public String name;
    public Integer money = 1000;
    public Integer employee;
    public Integer availbleProjectDays = 0;
    public Integer daySpentOnLookingForEmployee = 0;
    public ArrayList project = new ArrayList();
    public Project playerProject;
    public static int numberOfPlayers = 0;
    public static boolean end = false;
    static String playerName;
    public static int b = 0;
    public static boolean skip = false;
    public static int mistake = 0;
    static List<String> playerList = new ArrayList<>(numberOfPlayers);
    public static int currentPlayer = 0;
    public static ArrayList<Player> createdPlayers;
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();
    public static ArrayList<ArrayList> AllProjects = new ArrayList<>();



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

    public void addProject(ArrayList addProject) {
        this.project.add(addProject);
        System.out.println(this.project + "daaaaaaaa");
    }


    public void removeProject(ArrayList removeProject) {
        this.project.remove(removeProject)
        ;
    }

    @Override
    public String toString() {
        if (playerProject != null)
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

    public void choseStartingProject() {


        System.out.println("Do wyboru masz 3 projekty");
        System.out.println("Wybierz projekty pod względem trudności ");
        System.out.println("Projekt wybiera  ===> " + this.name);
        System.out.println("1. Ławty ");
        System.out.println("2. Średni ");
        System.out.println("3. Ciężki ");
        int chosenNumber = catchNumber(1, 3);
        boolean done = false;
        do {
            //generuje projekty na początek gry
            switch (chosenNumber) {

                case 1 -> {
                    System.out.println("Projekt łatwy");
                    this.addProject(generateEasyProject());
                    done = true;
                    // System.out.println(createdPlayers.get(currentPlayer).playerProject);

                }
                case 2 -> {
                    System.out.println("Projekt średni");
                    this.addProject(generateMediumProject());
                    done = true;


                }

                case 3 -> {
                    System.out.println("Projekt ćiężki");
                    this.addProject(generateHardProject());
                    done = true;

                }
                default -> {
                    System.out.println("Zły wybór.");

                }
            }
        } while (done == false);
    }

    public static void menu() {


        do {

            System.out.println("Dzień" + day);
            System.out.println("Co chcesz dziś zrobić");
            System.out.println("1.Podpisać umowę na realizację jednego z dostępnych projektów");
            System.out.println("2.Przeznaczyć dzień na szukanie klientów (każde 5 dni to jeden nowy dostępny projekt)");
            System.out.println("3.Przeznaczyć dzień na programowanie ");
            System.out.println("4.Przeznaczyć dzień na testowanie (możesz testować własny kod, kod podwykonawców i kod pracowników)");
            System.out.println("5.Oddać gotowy projekt klientowi");
            System.out.println("6.Zatrudnić nowego pracownika");
            System.out.println("7.Zwolnić pracownika");
            System.out.println("8.Przeznaczyć dzień na rozliczenia z urzędami (jeśli nie poświęcisz na to 2 dni w miesiącu ZUS wjeżdża z taką kontrolą, że zamykasz firmę z długami)");
            Integer chosenNumber = catchNumber(1, 8);

            switch (chosenNumber) {
                case 1 -> {
                    System.out.println("Podpisanie umowy na dostępny projekt");

                }
                //projekt

                case 2 -> {
                    System.out.println("Chcesz szukać klienta?");
                    if (createdPlayers.get(currentPlayer).availbleProjectDays == 5) {
                        Integer RNG = getRandomNumber(1, 3);
                        if (RNG == 1) {

                            //              AllProjects.add(generateEasyProject());


                        }
                        /*    if (RNG == 2) {

                                AllProjects.add(generateMediumProject());
                            }
                            if (RNG == 3) {

                                AllProjects.add(generateHardProject());
                            }*/
                        System.out.println("Czy któryś projekt cię interesuje i chcesz zdobyć klienta?" + "\n" + "Jeśli nie naciśnij 0");
                        showAllProjects();
                        Scanner qwe = new Scanner(System.in);
                        chosenNumber = qwe.nextInt();
                        if (chosenNumber != 0) {
                            addReserverdProject(currentPlayer, AllProjects.get(chosenNumber));
                        } else {
                            mistake += 1;
                        }

                        createdPlayers.get(currentPlayer).availbleProjectDays = 0;
                    } else {
                        createdPlayers.get(currentPlayer).availbleProjectDays += 1;
                    }


                }
                case 3 -> {

                    System.out.println(createdPlayers.get(currentPlayer).availbleProjectDays);
                }
                // do something...

                case 4 -> System.out.println("You've chosen option #4");


                // do something...

                case 5 -> System.out.println("You've chosen option #5");


                // do something...

                case 6 -> System.out.println("You've chosen option #6");


                // do something...

                case 7 -> System.out.println("You've chosen option #7");


                // do something...

                case 8 -> System.out.println("You've chosen option #8");

                default -> {
                    skip = true;
                }
            }

        }
        while (false);
        System.out.println("coś nie działa");

    }


    public static void changeMoney(Integer currentPlayer, Integer money) {
        Player a = createdPlayers.get(currentPlayer);
        a.money = a.money + money;
        createdPlayers.set(currentPlayer, a);
    }

    public static void changeEmployee(Integer currentPlayer, Integer employee) {
        Player a = createdPlayers.get(currentPlayer);
        a.employee = a.employee + employee;
        createdPlayers.set(currentPlayer, a);
    }

    public static void changeProject(Integer currentPlayer, Integer availbleProjectDays) {
        Player a = createdPlayers.get(currentPlayer);
        a.availbleProjectDays = a.availbleProjectDays + availbleProjectDays;
        createdPlayers.set(currentPlayer, a);
    }

    public static void changeDaySpentOnLookingForEmployee(Integer currentPlayer, Integer daySpentOnLookingForEmployee) {
        Player a = createdPlayers.get(currentPlayer);
        a.daySpentOnLookingForEmployee = a.daySpentOnLookingForEmployee + daySpentOnLookingForEmployee;
        createdPlayers.set(currentPlayer, a);
    }
    //dodaje konkretny projekty
    public static void addReserverdProject(Integer currentPlayer, ArrayList playerProjectToAdd) {
        Player a = createdPlayers.get(currentPlayer);
        a.project.add(playerProjectToAdd);
    }
    //gra się toczy
    public static void game() {

        while (!end) {

            currentPlayer = 0;

            for (int i = 1; i <= numberOfPlayers + mistake; i++) {
                System.out.println(createdPlayers.get(currentPlayer) + "\n");
                System.out.println("Kolejność graczy to :" + playerList);
                System.out.println("Ruch gracza: " + playerList.get(0)); //pokazuje gracza
                menu();
                if (!skip) {
                    playerList.add(playerList.get(0)); //ustawnienie obecnego gracza na koniec kolejki
                    playerList.remove(0);  //usuwa gracza obecnego z kolejki
                    currentPlayer += 1;

                }

            }
            currentPlayer = 0;

            if (false == skip) {
                day = day + 1;
                b = b + 1; //<=================================================================to kończy gre
            }
            skip = false;
            if (b == 995) {// < ============================================================to kończy gre tu ile dni ma trwać gra też jest dodane
                end = true;
            }
        }
    }
    //pobiera string od uzytkownika
    public static String catchString() {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        return a;
    }
    //pobiera cyfre od uzytkownika
    public static Integer catchNumber(Integer min, Integer max) {
        boolean end = false;
        int chosenNumber = 0;
        try {
            do {
                System.out.println("Wprowadź liczbę");
                Scanner in = new Scanner(System.in);
                chosenNumber = in.nextInt();
                if (chosenNumber >= min && chosenNumber <= max) {
                    end = true;
                }
            }
            while (end != true);
        } catch (
                Exception IndexOutOfBoundsException) {

            System.out.println("Niepoprawna liczba");
        }
        return chosenNumber;
    }
    //tworzy random stringa
    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    //tworzy random liczbe
    public static int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }
    //tworzy graczy
    public static ArrayList<Player> createPlayers() {
        System.out.println("Ilu graczy weźmie udział w grze");
        numberOfPlayers = catchNumber(0, 99999);

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Wprowadź imie gracza nr " + i);
            playerName = catchString();
            if (playerName == "") {
                System.out.printf("Bozia rączek nie dała" + "\n" + "A więc będziesz graczem o nazwie:" + i);
                playerName = "Gracz " + i;
            }
            playerList.add(playerName);

        }
        System.out.println("Imie graczy to " + playerList);
        System.out.println("Tylu graczy weźmie udział w grze " + numberOfPlayers);
        ArrayList<Player> currentplayers = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {

            Player CreatedPlayer = new Player(playerList.get(i - 1), 1000, 0, 0, 0);
            currentplayers.add(CreatedPlayer);
        }
        return currentplayers;
    }
    //Tworzy projekty
    public static ArrayList<Project> generateEasyProject() {
        ArrayList<Project> easyProject = new ArrayList<>();
        easyProject.add(new Project("Easy"));
        return easyProject;
    }

    public static ArrayList<Project> generateMediumProject() {
        ArrayList<Project> easyProject = new ArrayList<>();
        easyProject.add(new Project("Medium"));
        return easyProject;
    }

    public static ArrayList<Project> generateHardProject() {
        ArrayList<Project> easyProject = new ArrayList<>();
        easyProject.add(new Project("Hard"));
        return easyProject;
    }
    //pokazuje projekty
    public static void showAllProjects() {
        for (int i = 1; i <= AllProjects.size(); i++) {
            System.out.println(AllProjects.get(i - 1));
        }
    }

}

