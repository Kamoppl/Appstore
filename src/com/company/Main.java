package com.company;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static boolean end = false;
    static int numberOfPlayers;


    public static void main(String[] args) {
        String playerName;
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ilu graczy weźmie udział w grze");
        numberOfPlayers = in.nextInt();
        List<String> playerList = new ArrayList<>(numberOfPlayers);
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Wprowadź imie gracza nr " + i);
            playerName = scan.nextLine();
            Player currentPlayer = new Player(playerName);
            playerList.add(playerName);
            System.out.println(" Imie gracza to " + playerName);

        }

        System.out.println("Imie gracz to "+ playerList);
        System.out.println("Tylu graczy weźmie udział w grze " + numberOfPlayers);
/// Dodaj graczy













    }


    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

}