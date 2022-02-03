package com.company;

import Projects.*;
import org.w3c.dom.ls.LSOutput;

import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static int day = 0;
    public static int numberOfPlayers = 0;
    public static boolean end = false;
    static String playerName;
    public static int b = 0;
    public static boolean skip = false;
    public static int mistake = 0;
    static List<String> playerList = new ArrayList<>(numberOfPlayers);
    List<Integer> playersList = new ArrayList<>();

    public static int currentPlayer = 0;
    public Integer currentProject = 0;
    public static ArrayList<Player> createdPlayers;
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();
    public static ArrayList<ArrayList> AllProjects = new ArrayList<>();
    static com.company.Client Client = new Client();

    public static void main(String[] args) {
        System.out.println(Client.toString());
        createdPlayers = createPlayers();                                         // Dodaj graczy

        showAllProjects();
        System.out.println(createdPlayers);
        choseStartingProject();
        while (!end) {
            currentPlayer = 0;
            game();
        }
    }

    public static void menu() {


        try {


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
                Scanner in = new Scanner(System.in);
                int chosenNumber = in.nextInt();

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

                                AllProjects.add(generateEasyProject());


                            }
                            if (RNG == 2) {

                                AllProjects.add(generateMediumProject());
                            }
                            if (RNG == 3) {

                                AllProjects.add(generateHardProject());
                            }
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

        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Błąd wyboru z menu");
            skip = true;
            mistake = mistake + 1;


        }
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

    public static void addReserverdProject(Integer currentPlayer, ArrayList playerProjectToAdd) {
        Player a = createdPlayers.get(currentPlayer);
        a.project.add(playerProjectToAdd);
    }


    public static void game() {

        while (!end) {
            currentPlayer = 0;
            try {
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

                mistake = 0;
                currentPlayer = 0;
            } catch (Exception IndexOutOfBoundsException) {
                System.out.println("Error 404");
                System.out.println("problematic one");
            }

            System.out.println(skip + "aaaaaaaa");
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


    public static ArrayList<Player> createPlayers() {
        Integer wrong = 0;


        for (int q = 0; q <= wrong; q++) {
            System.out.println(wrong + "aaaaaaa");
            Scanner scan = new Scanner(System.in);
            Scanner in = new Scanner(System.in);
            try {

                System.out.println("Ilu graczy weźmie udział w grze");
                numberOfPlayers = in.nextInt();
                for (int i = 1; i <= numberOfPlayers; i++) {
                    System.out.println("Wprowadź imie gracza nr " + i);
                    playerName = scan.nextLine();
                    if (playerName == "") {
                        System.out.printf("Bozia rączek nie dała" + "\n" + "A więc będziesz graczem o nazwie:" + i);
                        playerName = "Gracz " + i;
                    }
                    playerList.add(playerName);
                    System.out.println(" Imie gracza to " + playerName);

                }


                System.out.println("Imie graczy to " + playerList);
                System.out.println("Tylu graczy weźmie udział w grze " + numberOfPlayers);

            } catch (Exception IndexOutOfBoundsException) {
                System.out.println("Błąd tworzenia zawodników");
                System.out.println("Spróbuj ponownie, może nastepnym razem się uda");
                wrong++;
            }
        }

        ArrayList<Player> currentplayers = new ArrayList<>();


        for (int i = 1; i <= numberOfPlayers; i++) {

            Player CreatedPlayer = new Player(playerList.get(i - 1), 1000, 0, 0, 0);
            currentplayers.add(CreatedPlayer);
        }
        return currentplayers;
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }


    public static ArrayList<EasyProject> generateEasyProject() {


        ArrayList<EasyProject> easyProject = new ArrayList<>();
        easyProject.add(new EasyProject());


        return easyProject;

    }

    public static ArrayList<MediumProject> generateMediumProject() {


        ArrayList<MediumProject> mediumProject = new ArrayList<>();
        mediumProject.add(new MediumProject());

        return mediumProject;

    }

    public static ArrayList<HardProject> generateHardProject() {


        ArrayList<HardProject> hardProject = new ArrayList<HardProject>();
        hardProject.add(new HardProject());

        return hardProject;

    }

    public static void showAllProjects() {
        for (int i = 1; i <= AllProjects.size(); i++) {
            System.out.println(AllProjects.get(i - 1));
        }
    }

    public static void choseStartingProject() {
        currentPlayer = 0;

        int startingProjectLoop = 0;
        int wrongMenuNumber = 0;
        for (int i = 0; i <= numberOfPlayers + wrongMenuNumber - 1; i++) {
            System.out.println("Do wyboru masz 3 projekty");
            System.out.println("Wybierz projekty pod względem trudności ");

            System.out.println("Projekt wybiera  ===> " + createdPlayers.get(currentPlayer).name);
            System.out.println("1. Ławty ");
            System.out.println("2. Średni ");
            System.out.println("3. Ciężki ");
            try {

                do {
                    Scanner in = new Scanner(System.in);
                    int chosenProject = in.nextInt();

                    //generuje projekty na początek gry
                    switch (chosenProject) {

                        case 1 -> {
                            System.out.println("Projekt łatwy");
                            Player a = createdPlayers.get(currentPlayer);
                            a.project = generateEasyProject();
                            createdPlayers.set(startingProjectLoop, a);
                            currentPlayer = currentPlayer + 1;
                            System.out.println(AllProjects);

                        }
                        case 2 -> {
                            System.out.println("Projekt średni");
                            Player a = createdPlayers.get(currentPlayer);
                            a.project = generateMediumProject();
                            createdPlayers.set(currentPlayer, a);
                            currentPlayer = currentPlayer + 1;


                        }

                        case 3 -> {
                            System.out.println("Projekt ciężki");
                            Player a = createdPlayers.get(currentPlayer);
                            a.project = generateHardProject();
                            createdPlayers.set(currentPlayer, a);
                            currentPlayer = currentPlayer + 1;

                        }
                        default -> {
                            System.out.println("Zły wybór.");
                            wrongMenuNumber++;
                        }
                    }
                } while (false);
            } catch (Exception IndexOutOfBoundsException) {
                System.out.println("Błąd wyboru z menu");
                wrongMenuNumber++;
            }

        }
    }
}




