package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Main.getNumberOfPlayers;

public class Menu {

    public static int switchPlayer(int currentPlayer, ArrayList playerList) {
        // move to the next player
        currentPlayer++;

        // reset back to the first player if we reached the end player
        if (currentPlayer < getNumberOfPlayers()) {
            return currentPlayer;
        }
        currentPlayer = 0;

        return currentPlayer;
    }

    public void memu() {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int day = 0;

        boolean end = false;
        if (getNumberOfPlayers() == 0) {
            System.out.println("Ciężko grać bez graczy");

        } else {
            System.out.println("Ruch gracza nr" );
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
                System.out.print("Choose menu number: ");

                int chosenNumber = in.nextInt();

                switch (chosenNumber) {

                    case 1:

                        System.out.println("You've chosen option #1");

                        //projekt

                        break;

                    case 2:

                        System.out.println("You've chosen option #2");


                        break;

                    case 3:

                        System.out.println("You've chosen option #3");

                        // do something...

                        break;

                    case 4:

                        System.out.println("You've chosen option #4");

                        // do something...

                        break;

                    case 5:

                        System.out.println("You've chosen option #5");

                        // do something...

                        break;
                    case 6:

                        System.out.println("You've chosen option #6");

                        // do something...

                        break;
                    case 7:

                        System.out.println("You've chosen option #7");

                        // do something...

                        break;
                    case 8:

                        System.out.println("You've chosen option #8");

                        // do something...

                        break;
                    //koniec gry
                    case 0:
                        // end = true; kończy grę
                        end = true;

                        break;

                    default:

                        System.out.println("Zły wybór.");

                }

                day = day + 1;
            }
            while (!end);

            System.out.println("Koniec gry!");
        }
    }
}