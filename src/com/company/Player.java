package com.company;

import Projects.Project;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Player {
    public static int day = 1;
    public String name;
    public Integer money = 1000;
    public Integer employee;
    public Integer availableProjectDays = 0;
    public Integer daySpentOnLookingForEmployee = 0;
    public ArrayList<Project> project = new ArrayList();
    public static ArrayList<Worker> playerWorker = new ArrayList<>();
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
    public static ArrayList<Project> allProjects = new ArrayList<>();
    public static ArrayList<Worker> allWorkers = new ArrayList<>();
    public static Integer moneySpentOnLookingForEmployer;
    public boolean doneCreatingWorkers = false;

    public Player(String name, Integer money, Integer employee, Integer availableProjectDays, Integer daySpentOnLookingForEmployee) {
        this.name = name;
        this.money = money = 1000;
        this.employee = employee = 0;
        this.availableProjectDays = Player.this.availableProjectDays = 0;
        this.daySpentOnLookingForEmployee = daySpentOnLookingForEmployee = 0;
        this.moneySpentOnLookingForEmployer = 0;
    }

    public void addProject(Project addProject) {
        this.project.add(addProject);
    }


    public String toString() {
        if (playerProject != null)
            return

                    "\n" + "Player{" +
                            "name='" + name + '\'' +
                            ", money=" + money +
                            ", employee=" + employee +
                            ", availbleProjectDays=" + availableProjectDays +
                            ", daySpentOnLookingForEmployee=" + daySpentOnLookingForEmployee +
                            ", project=" + project +
                            '}';
        else {
            return
                    "\n" + "Player{" +
                            "name='" + name + '\'' +
                            ", money=" + money +
                            ", employee=" + employee +
                            ", availbleProjectDays=" + availableProjectDays +
                            ", daySpentOnLookingForEmployee=" + daySpentOnLookingForEmployee +
                            '}';
        }
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
        boolean done = false;
        do {
            int chosenNumber = catchNumber(1, 3);
            //generuje projekty na początek gry
            switch (chosenNumber) {

                case 1 -> {
                    System.out.println("Projekt łatwy");
                    this.addProject(generateEasyProject());
                    done = true;


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
                    done = false;
                }
            }


        } while (!done);

    }

    public static void menu() {


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
        Integer chosenNumber = catchNumber(1, 9);

        switch (chosenNumber) {
            case 1 -> signContract();
            case 2 -> getClient();

            case 3 -> {

                System.out.println(createdPlayers.get(currentPlayer).availableProjectDays);
            }
            // do something...

            case 4 -> showAllPlayerProjects();


            // do something...

            case 5 -> System.out.println("You've chosen option #5");


            // do something...

            case 6 -> workersMenu();


            // do something...

            case 7 -> System.out.println("You've chosen option #7");


            // do something...

            case 8 -> System.out.println("You've chosen option #8");
            case 9 -> showPlayerProjects();

            default -> {
                skip = true;
            }
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
        a.availableProjectDays = a.availableProjectDays + availbleProjectDays;
        createdPlayers.set(currentPlayer, a);
    }

    public static void changeDaySpentOnLookingForEmployee(Integer currentPlayer, Integer daySpentOnLookingForEmployee) {
        Player a = createdPlayers.get(currentPlayer);
        a.daySpentOnLookingForEmployee = a.daySpentOnLookingForEmployee + daySpentOnLookingForEmployee;
        createdPlayers.set(currentPlayer, a);
    }


    //gra się toczy
    public static void game() {
        addBasicWorkers();
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

            if (!skip) {
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
        boolean number = false;
        while (!number) {
            try {
                do {
                    System.out.println("Wprowadź liczbę");
                    Scanner in = new Scanner(System.in);
                    chosenNumber = in.nextInt();
                    if (chosenNumber >= min && chosenNumber <= max) {
                        end = true;
                        number = true;
                    }
                }
                while (!end);
            } catch (
                    Exception IndexOutOfBoundsException) {
                System.out.println("Niepoprawna liczba");
                number = false;
            }
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
    public static Project generateEasyProject() {
        return new Project("Easy");
    }

    public static Project generateMediumProject() {
        return new Project("Medium");
    }

    public static Project generateHardProject() {
        return new Project("Hard");
    }


    public static void getClient() {
        System.out.println("Chcesz szukać klienta?");
        if (createdPlayers.get(currentPlayer).availableProjectDays == 5) {
            Integer RNG = getRandomNumber(1, 3);
            if (RNG == 1) {

                allProjects.add(new Project("Easy"));
            }
            if (RNG == 2) {

                allProjects.add(new Project("Medium"));
            }
            if (RNG == 3) {

                allProjects.add(new Project("Hard"));
            }
            System.out.println("Czy któryś projekt cię interesuje i chcesz zdobyć klienta?" + "\n" + "Jeśli nie naciśnij 0");
            showAllPlayerProjects();
            Integer chosenNumber = catchNumber(0, allProjects.size());
            if (chosenNumber != 0) {
                createdPlayers.get(currentPlayer).project.add(allProjects.get(chosenNumber - 1));
                allProjects.remove(chosenNumber - 1);
            }

            createdPlayers.get(currentPlayer).availableProjectDays = 0;
        } else {
            createdPlayers.get(currentPlayer).availableProjectDays += 1;
        }

    }

    public static void signContract() {
        System.out.println("Podpisanie umowy na dostępny projekt");
        System.out.println("Który projekt chcesz podpisać");

        boolean sure = false;
        do {
            sure = false;
            for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
                System.out.println("Nr Projektu to " + i + 1 + "    " + createdPlayers.get(currentPlayer).project);
            }
            Integer chosenNumber = catchNumber(1, createdPlayers.get(currentPlayer).project.size());
            chosenNumber -= 1;
            System.out.println("Potwierdź (y/n)");
            String confirm = catchString();
            if (confirm.equals("y")) {
                sure = true;
                createdPlayers.get(currentPlayer).project.get(chosenNumber).signProject();
                System.out.println(createdPlayers.get(currentPlayer).project.get(chosenNumber));
            }
        } while (sure == false);

    }

    public static void showPlayerProjects() {
        for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
            Integer projectnumber = i + 1;
            System.out.println("Projekt " + projectnumber + "    " + createdPlayers.get(currentPlayer).project.get(i));
        }
    }

    public static void showAllPlayerProjects() {
        for (int i = 0; i < allProjects.size(); i++) {
            Integer projectnumber = i + 1;
            System.out.println("Projekt " + projectnumber + "    " + allProjects.get(i));
        }
    }

    public static void waitClick() {
        catchString();
    }

    public Integer checkPlayerWorkersTester() {
        Integer playerWorkersTesters = 0;
        for (int i = 0; i < playerWorker.size(); i++) {
            if (this.playerWorker.get(i).tester == 1) {
                playerWorkersTesters++;
            }
        }
        return playerWorkersTesters;
    }

    public Integer checkPlayerWorkersSeller() {
        Integer playerWorkersSeller = 0;
        for (int i = 0; i < playerWorker.size(); i++) {
            if (this.playerWorker.get(i).seller == 1) {
                playerWorkersSeller++;
            }
        }
        return playerWorkersSeller;
    }

    public static void addWorkerToPlayer(Integer workerIndex) {
        playerWorker.add(allWorkers.get(workerIndex));
    }


    public static void workersMenu() {
        System.out.println("Menu Pracowników");
        System.out.println("1 Wyświetl pracowników");
        System.out.println("2 Zatrudnij Pracownika");

        Integer chosenNumber;
        do {
            chosenNumber = catchNumber(1, 3);

            switch (chosenNumber) {
                case 1: {
                    showAllWorkers();
                    break;
                }
                case 2: {
                    hireWorker();
                    break;
                }


            }

        }
        while (chosenNumber != 0);

    }

    public static void showAllWorkers() {
        for (int i = 0; i < allWorkers.size(); i++) {
            int workerNumber = i + 1;
            System.out.println(workerNumber + "    " + allWorkers.get(i));
        }
    }

    public static void showPlayerWorkers() {
        for (int i = 0; i < allWorkers.size(); i++) {
            int workerNumber = i + 1;
            System.out.println(workerNumber + "    " + playerWorker.get(i));
        }
    }

    public static void hireWorker() {
        System.out.println("0 Wraca do Menu");
        showAllWorkers();
        Integer chosenNumber = catchNumber(0, allWorkers.size());
        if (chosenNumber != 0) {
            addWorkerToPlayer(chosenNumber = catchNumber(1, allWorkers.size()) + 1);
            System.out.println(playerWorker.toString());
        }


    }

    public static void addBasicWorkers() {
        Worker Kamil = new Worker("Kamil");
        Worker Adam = new Worker("Adam");
        Worker Maciej = new Worker("Maciej");
        Worker Borek = new Worker("Borek");
        Worker Michał = new Worker("Michał");
        Worker Marcin = new Worker("Marcin");
        Worker Mateusz = new Worker("Mateusz");
        allWorkers.add(Kamil);
        allWorkers.add(Adam);
        allWorkers.add(Maciej);
        allWorkers.add(Borek);
        allWorkers.add(Michał);
        allWorkers.add(Marcin);
        allWorkers.add(Mateusz);

    }
}


