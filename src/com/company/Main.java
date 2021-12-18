package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Players.PlayerOne;
import Projects.Project;

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
    public Project project;
    public static int currentPlayer = 0;
    public PlayerOne playerOne;
    public static ArrayList<Player> createdPlayers;


    public static void main(String[] args) {
                  /// Dodaj graczy
        createdPlayers=createPlayers();

        while (!end){
            day();
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
                    System.out.println("9.Sprawdź jak tam twoje staty na dzień dzisiejszy");
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
                        case 9 -> System.out.println("You've chosen option #8");


                        // do something...

                        default -> System.out.println("Zły wybór.");
                    }
a

                }
                while (false);
            }
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Błąd wyboru z menu");
            skip = true;
            mistake = mistake + 1;


        }

    }


    public static void getProjects() {
        System.out.println("Które projekt chcesz wybrać:" + "\r\n" + "Łatwy wybierz 1" + "\r\n" + "Średni wybierz 2" + "\r\n" + "Ciężki wybierz 3");
        Scanner in = new Scanner(System.in);
        int choseProject = in.nextInt();
        if (choseProject == 1) {createdPlayers.get(1);
        }
        if (choseProject == 2) {
        }
        if (choseProject == 3) {
        }


    }

    public static ArrayList createPlayers() {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ilu graczy weźmie udział w grze");
        numberOfPlayers = in.nextInt();

        try {
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println("Wprowadź imie gracza nr " + i);
                playerName = scan.nextLine();
                playerList.add(playerName);
                System.out.println(" Imie gracza to " + playerName);

            }






            System.out.println("Imie graczy to " + playerList);
            System.out.println("Tylu graczy weźmie udział w grze " + numberOfPlayers);
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Błąd tworzenia zawodników");
            end = true;
        }
        ArrayList<Player> currentplayers = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {

            Player Player = new Player(playerList.get(i-1), 1000, 0, 0, 0);
            currentplayers.add(Player);
        }
        return currentplayers;
    }

    public static void day() {
        while (!end) {

            try {
                for (int i = 1; i <= numberOfPlayers + mistake; i++) {
                    System.out.println("Kolejność graczy to :" + playerList);
                    System.out.println("Ruch gracza: " + playerList.get(0)); //pokazuje gracza
                    menu();

                    if (!skip) {
                        playerList.add(playerList.get(0)); //ustawnienie obecnego gracza na koniec kolejki
                        playerList.remove(0);  //usuwa gracza obecnego z kolejki

                    }
                    currentPlayer = currentPlayer + 1;
                    skip = false;
                }
                mistake = 0;
            } catch (Exception IndexOutOfBoundsException) {
                System.out.println("Błąd tworzenia zawodników");
                end = true;
            }
            currentPlayer = 0;

            day = day + 1;
            b = b + 1; //<=================================================================to konczy gre
            if (b == 5) {// < ============================================================to konczy gre tu ile dni ma trwac gra też jest dodane
                end = true;
            }
        }
    }

}

