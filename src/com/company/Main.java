package com.company;

import static com.company.Player.*;

public class Main {


    public static void main(String[] args) {
        // Dodaj graczy


        createdPlayers = createPlayers();

        for (int a = 0; a < createdPlayers.size(); a++) {
            createdPlayers.get(a).choseStartingProject();

        }
        //Gra się toczy
        while (!end) {
            currentPlayer = 0;
            game();
        }
    }


}









