package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projects.Project;
import Projects.EasyProject;
import Projects.MediumProject;
import Projects.HardProject;

public class Main {
    public static int day = 0;
    public static int numberOfPlayers = 0;
    public static boolean end = false;
    static String playerName;
    public static int b = 0;
    public static boolean skip = false;
    public static int mistake = 0;
    static List<String> playerList = new ArrayList<>(numberOfPlayers);
    public Project project;

    public class Difficulty {
        public static int easy = 0;
        public static int medium = 1;
        public static int hard = 2;
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ilu graczy weźmie udział w grze");
        numberOfPlayers = in.nextInt();

        getProjects();
        try {
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println("Wprowadź imie gracza nr " + i);
                playerName = scan.nextLine();
                Player player = new Player(playerName);
                playerList.add(playerName);
                System.out.println(" Imie gracza to " + playerName);

            }
            System.out.println(playerList.get(0));
            System.out.println("Imie graczy to " + playerList);
            System.out.println("Tylu graczy weźmie udział w grze " + numberOfPlayers);
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Błąd tworzenia zawodników");
            end = true;
        }
        int currentPlayer = 0;
/// Dodaj graczy
        while (!end) {

            try {
                for (int i = 1; i <= numberOfPlayers + mistake; i++) {
                    System.out.println("Kolejność graczy to :" + playerList);
                    System.out.println("Ruch gracza: " + playerList.get(currentPlayer)); //pokazuje gracza
                    menu();

                    if (!skip) {
                        playerList.add(playerList.get(currentPlayer)); //ustawnienie nastepnych graczy
                        playerList.remove(0);  //ustawnienie nastepnych graczy
                    }
                    skip = false;
                }
                mistake = 0;
            } catch (Exception IndexOutOfBoundsException) {
                System.out.println("Błąd tworzenia zawodników");
                end = true;
            }
            day = day + 1;
            b = b + 1; //<=================================================================to konczy gre
            if (b == 5) {// < ============================================================to konczy gre tu ile dni ma trwac gra też jest dodane
                end = true;
            }
        }

    }

    public static void menu() {
        try {

            if (numberOfPlayers == 0) {
                System.out.println("Ciężko grać bez graczy");
            } else {
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
                        case 1 -> System.out.println("You've chosen option #1");


                        //projekt

                        case 2 -> System.out.println("You've chosen option #2");
                        case 3 -> System.out.println("You've chosen option #3");


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


                        // do something...

                        default -> System.out.println("Zły wybór.");
                    }


                }
                while (false);
            }
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Błąd wyboru z menu");
            skip = true;
            mistake = mistake + 1;


        }

    }

    @Override
    public String toString() {
        return "Main{" +
                "project=" + project +
                '}';
    }

    public static void getProjects() {
        System.out.println("Które projekt chcesz wybrać:" + "\r\n" + "Łatwy wybierz 1" + "\r\n" + "Średni wybierz 2" + "\r\n" + "Ciężki wybierz 3");
        Scanner in = new Scanner(System.in);
        Player player = new Player("Kamil");
        int choseProject = in.nextInt();
        if (choseProject == 1) {
            player.project = new Project();
            System.out.println(player.project.toString());
        }
        if (choseProject == 2) {
        }
        if (choseProject == 3) {
        }


    }
}

