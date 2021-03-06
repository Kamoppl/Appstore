package com.company;

import Projects.Project;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Player {
    public static int day = 1;
    public String name;
    public Integer money;
    public Integer employee;
    public Integer availableProjectDays = 0;
    public Integer daySpentOnLookingForEmployee = 0;
    public ArrayList<Project> project = new ArrayList();
    public static ArrayList<Worker> playerWorker = new ArrayList<>();
    public static ArrayList<Worker> friendWorker = new ArrayList<>();
    public Project playerProject;
    public static int numberOfPlayers = 0;
    public static boolean end = false;
    static String playerName;
    public static int b = 0;
    public static boolean skip = false;
    static List<String> playerList = new ArrayList<>(numberOfPlayers);
    public static int currentPlayer = 0;
    public static ArrayList<Player> createdPlayers;
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();
    public static ArrayList<Project> allProjects = new ArrayList<>();
    public static ArrayList<Worker> allWorkers = new ArrayList<>();
    public static ArrayList<Worker> justPlayer = new ArrayList<>();
    public static ArrayList<Worker> allFriends = new ArrayList<>();
    public static ArrayList<PaymentDelay> moneyDelay = new ArrayList<>();
    public Integer zusDay;
    public boolean skipPlayer;
    public static Integer month = 0;
    public boolean firstTurnSkip;
    public Integer bigProject;
    public static Integer startingMoney;


    public Player(String name) {
        this.name = name;
        this.money = 5000;
        this.employee = 0;
        this.availableProjectDays = 0;
        this.daySpentOnLookingForEmployee = 0;
        this.zusDay = 0;
        this.skipPlayer = false;
        this.firstTurnSkip = false;
        this.bigProject = 0;
    }


    public void addProject(Project addProject) {
        this.project.add(addProject);
    }

    public String toString() {
        if (playerProject != null)
            return
                    "Player{" +
                            "Imi?? gracza ='" + name + '\'' +
                            ", Pieni??dze = " + money +
                            ", Dni szukania projektu =" + availableProjectDays +
                            ", Dni przeznaczone na Zus w tym miesi??cu =" + zusDay +
                            ", Dostepne projekty =" + project +
                            '}';


        else {
            return "Player{" +
                    "Imi?? gracza ='" + name + '\'' +
                    ", Pieni??dze = " + money +
                    ", Dni szukania projektu =" + availableProjectDays +
                    ", Dni przeznaczone na Zus w tym miesi??cu = " + zusDay +
                    '}';
        }
    }


    public static void menu() {


        System.out.println("Dzie??" + day);
        System.out.println("Co chcesz dzi?? zrobi??");
        System.out.println("1.Podpisa?? umow?? na realizacj?? jednego z dost??pnych projekt??w");
        System.out.println("2.Przeznaczy?? dzie?? na szukanie klient??w (ka??de 5 dni to jeden nowy dost??pny projekt)");
        System.out.println("3.Przeznaczy?? dzie?? na programowanie ");
        System.out.println("4.Przeznaczy?? dzie?? na testowanie (mo??esz testowa?? w??asny kod, kod podwykonawc??w i kod pracownik??w)");
        System.out.println("5.Odda?? gotowy projekt klientowi");
        System.out.println("6.Zatrudni?? nowego pracownika");
        System.out.println("7.Zwolni?? pracownika");
        System.out.println("8.Przeznaczy?? dzie?? na rozliczenia z urz??dami (je??li nie po??wi??cisz na to 2 dni w miesi??cu ZUS wje??d??a z tak?? kontrol??, ??e zamykasz firm?? z d??ugami)");
        Integer chosenNumber = catchNumber(1, 8);

        switch (chosenNumber) {
            case 1 -> {
                signContract();
                waitClick();
            }
            case 2 -> {
                getClient();
                waitClick();
            }
            case 3 -> {
                playerDoHisJob();
                waitClick();
            }
            case 4 -> {
                testProject();
                waitClick();
            }
            case 5 -> {
                giveClientProject();
                waitClick();
            }
            case 6 -> {
                workersMenu();
                waitClick();
            }
            case 7 -> {
                fireWorker();
                waitClick();
            }
            case 8 -> {
                increaseZusDay();
                waitClick();
            }

            default -> {
                skip = true;
            }
        }

    }

    private static void increaseZusDay() {
        createdPlayers.get(currentPlayer).zusDay += 1;
    }

    public static void taxes() {
        createdPlayers.get(currentPlayer).money = (createdPlayers.get(currentPlayer).money * 9) / 10;
    }

    //gra si?? toczy
    public static void game() {
        addBasicWorkers();
        startingMoney = createdPlayers.get(currentPlayer).money;
        while (!end) {

            currentPlayer = 0;

            for (int i = 1; i <= numberOfPlayers; i++) {
                Date date = new Date(120, month, day);

                if (createdPlayers.get(currentPlayer).firstTurnSkip) {
                    workerPay(date.getDate());
                    zusPunishment(date.getDate());
                }
                System.out.println(createdPlayers.get(currentPlayer) + "\n");
                System.out.println("Kolejno???? graczy to :" + playerList);

                System.out.println("Ruch gracza: " + playerList.get(0)); //pokazuje gracza
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
                System.out.println(dateFormat.format(date));
                if (!createdPlayers.get(currentPlayer).skipPlayer) {

                    payDayMoneyToPlayer();

                    menu();
                    if (!skip) {
                        turnEnd();
                        lowerDayInProject();
                        sellerMove();
                    }
                }


                if (createdPlayers.get(currentPlayer).skipPlayer && createdPlayers.size() == 1) {
                    end = true;
                }

                if (createdPlayers.get(currentPlayer).money < 0) {
                    createdPlayers.get(currentPlayer).skipPlayer = true;
                }


                if (createdPlayers.get(currentPlayer).bigProject >= 3 && createdPlayers.get(currentPlayer).money > startingMoney) {
                    end = true;
                    System.out.println("Zwyci????y?? ==========>  " + createdPlayers.get(currentPlayer).name + "  <==========");
                }

                setNextPlayer();
            }

            currentPlayer = 0;

            if (!skip) {
                day = day + 1;
                b = b + 1; //<=================================================================to ko??czy gre
            }
            skip = false;

            if (b == 999999999) {// < ============================================================to ko??czy gre tu ile dni ma trwa?? gra te?? jest dodane
                end = true;
            }
        }
    }

    public static void workerPay(Integer dateDay) {
        if (dateDay == 1) {
            taxes(); // Podatki 10 % co miesi??c od posaidanych pieni??zk??w
            System.out.println("Op??ata za procwnik??w zosta??a zabrana z konta");
            for (int i = 0; i < playerWorker.size(); i++) {
                createdPlayers.get(currentPlayer).money -= playerWorker.get(i).cost;
            }
        }
    }


    public static void zusPunishment(Integer dateDate) {
        if (dateDate == 1) {
            if (!createdPlayers.get(currentPlayer).firstTurnSkip) {
                createdPlayers.get(currentPlayer).firstTurnSkip = true;
            } else if (createdPlayers.get(currentPlayer).zusDay < 3) {
                System.out.println("Zus ci?? dojecha?? i przegrywasz");
                createdPlayers.get(currentPlayer).skipPlayer = true;
                waitClick();
            }
            createdPlayers.get(currentPlayer).zusDay = 0;
        }
    }

    //pobiera string od uzytkownika
    public static String catchString(String possibleInput1, String possibleInput2) {
        while (possibleInput1.equals("y") && possibleInput2.equals("n")) {
            Scanner scan = new Scanner(System.in);
            String a = scan.nextLine();
            if (a.equals("y") || a.equals("n")) {

                return a;
            }
            System.out.println("Do wyboru masz tylko (y/n)");
        }

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
                    System.out.println("Wprowad?? liczb??");
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
        System.out.println("Ilu graczy we??mie udzia?? w grze");
        numberOfPlayers = catchNumber(0, 99999);

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Wprowad?? imie gracza nr " + i);
            playerName = catchString("0", "0");
            if (playerName == "") {
                System.out.printf("Bozia r??czek nie da??a" + "\n" + "A wi??c b??dziesz graczem o nazwie:" + i);
                playerName = "Gracz " + i;
            }
            playerList.add(playerName);

        }
        System.out.println("Imie graczy to " + playerList);
        System.out.println("Tylu graczy we??mie udzia?? w grze " + numberOfPlayers);
        ArrayList<Player> currentplayers = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {

            Player CreatedPlayer = new Player(playerList.get(i - 1));
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

    public static Project generateEndedProject() {
        return new Project("Ended");
    }

    public static void getClient() {
        System.out.println("Szukanie klienta");
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
            System.out.println("Czy kt??ry?? projekt ci?? interesuje i chcesz zdoby?? klienta?" + "\n" + "Je??li nie naci??nij 0");
            showAllPlayerProjects();
            Integer chosenNumber = catchNumber(0, allProjects.size());
            if (chosenNumber != 0) {
                createdPlayers.get(currentPlayer).project.add(allProjects.get(chosenNumber - 1));
                allProjects.remove(chosenNumber - 1);
            }

            createdPlayers.get(currentPlayer).availableProjectDays = 0;
        } else {

            Integer dayLeft = 5 - createdPlayers.get(currentPlayer).availableProjectDays;
            if (dayLeft > 1) {
                System.out.println("Zosta??y " + dayLeft + " dni, aby znale???? nast??pnego klienta");
            } else {
                System.out.println("Zosta??y ostatni dzie?? poszukiwa??, aby znale???? klienta");
            }
            createdPlayers.get(currentPlayer).availableProjectDays += 1;
        }

    }

    public static void signContract() {
        System.out.println("Podpisanie umowy na dost??pny projekt");
        System.out.println("Kt??ry projekt chcesz podpisa??");

        boolean sure;

        sure = false;
        for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
            Integer projectNumber = i + 1;
            System.out.println("Nr Projektu to " + projectNumber + "    " + createdPlayers.get(currentPlayer).project.get(i));
        }
        do {
            Integer chosenNumber = catchNumber(0, createdPlayers.get(currentPlayer).project.size());
            if (chosenNumber == 0) {
                skip = true;
                break;
            }
            chosenNumber -= 1;
            if (!createdPlayers.get(currentPlayer).project.get(chosenNumber).signed) {
                System.out.println("Potwierd?? (y/n)");
                String confirm = catchString("y", "n");
                if (confirm.equals("y")) {
                    sure = true;
                    createdPlayers.get(currentPlayer).project.get(chosenNumber).signProject();
                    System.out.println(createdPlayers.get(currentPlayer).project.get(chosenNumber));
                }
            } else if (createdPlayers.get(currentPlayer).project.get(chosenNumber).signed) {
                System.out.println("Podpisano ju?? ten kontrakt");
                skip = true;
                sure = true;

            }
        } while (sure == false);

    }

    public static void showPlayerProjects() {
        for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
            Integer projectnumber = i + 1;
            System.out.println("Projekt " + projectnumber + "    " + createdPlayers.get(currentPlayer).project.get(i).Progress);
        }
    }

    public static void showAllPlayerProjects() {
        for (int i = 0; i < allProjects.size(); i++) {
            Integer projectnumber = i + 1;
            System.out.println("Projekt " + projectnumber + "    " + allProjects.get(i));
        }
    }

    public static void waitClick() {
        catchString("0", "0");
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

        boolean quit = false;
        Integer chosenNumber;
        do {
            System.out.println("Menu Pracownik??w");
            System.out.println("0 Wr??c do Menu");
            System.out.println("1 Wy??wietl pracownik??w");
            System.out.println("2 Zatrudnij Pracownika");
            System.out.println("3 Zatrudnij znajomego co zrobi projekt za cb");
            chosenNumber = catchNumber(0, 3);

            switch (chosenNumber) {
                case 1: {
                    showAllWorkers();
                    break;
                }


                case 2: {
                    if (hireWorker()) {
                        quit = true;
                    }
                    break;
                }


                case 3: {
                    if (hireFriend()) {
                        quit = true;
                    }
                    break;

                }

                case 0: {
                    skip = true;
                    quit = true;
                    break;
                }

            }

        }
        while (!quit);

    }

    public static void showAllFriends() {
        for (int i = 0; i < allFriends.size(); i++) {
            int workerNumber = i + 1;
            System.out.println(workerNumber + "    " + allFriends.get(i));
        }
    }

    public static boolean hireFriend() {
        System.out.println("Kt??rego znajomego chcesz zatrudni???" + "\n" + "0 Wraca do Menu");
        System.out.println("1 najlepszy ucze?? bierze 50 % income");
        System.out.println("2 ??redni ucze?? bierze 25%");
        System.out.println("3 kole??, kt??ry wie wszystko najlepiej bierze 15 %");
        Integer chosenNumber = catchNumber(0, allFriends.size());
        Integer chosenFriend;
        if (chosenNumber != 0) {
            chosenFriend = chosenNumber;
            System.out.println(friendWorker.toString());
            System.out.println("Kt??ry projekt ma zrobi??");
            showPlayerProjects();
            chosenNumber = catchNumber(0, createdPlayers.get(currentPlayer).project.size());
            if (chosenNumber != 0) {
                friendDoHisJob(chosenFriend, chosenNumber);
                return true;
            }

        }


        return false;

    }

    public static void showAllWorkers() {
        for (int i = 0; i < allWorkers.size(); i++) {
            int workerNumber = i + 1;
            System.out.println(workerNumber + "    " + allWorkers.get(i));
        }
    }

    public static void showPlayerWorkers() {
        for (int i = 0; i < playerWorker.size(); i++) {
            int workerNumber = i + 1;
            System.out.println(workerNumber + "    " + playerWorker.get(i));
        }
    }

    public static boolean hireWorker() {
        System.out.println("Kt??rego Pracownika chcesz zatrudni???" + "\n" + "0 Wraca do Menu");
        showAllWorkers();
        Integer chosenNumber = catchNumber(0, allWorkers.size());
        if (chosenNumber != 0) {
            addWorkerToPlayer(chosenNumber - 1);
            System.out.println(playerWorker.toString());
            return true;
        } else {
            return false;
        }


    }

    public static void addBasicWorkers() {
        allWorkers.add(new Worker("Kamil"));
        allWorkers.add(new Worker("Adam"));
        allWorkers.add(new Worker("Maciej"));
        allWorkers.add(new Worker("Borek"));
        allWorkers.add(new Worker("Micha??"));
        allWorkers.add(new Worker("Marcin"));
        allWorkers.add(new Worker("Mateusz"));
        allFriends.add(new Worker("Pawe??"));
        allFriends.add(new Worker("Cezary"));
        allFriends.add(new Worker("Artur"));


    }

    public static void justPlayer() {
        Worker Player = new Worker("Player");
        justPlayer.add(Player);
    }

    public static void playerDoHisJob() {
        justPlayer();
        System.out.println("Wybierz projekt nad kt??rym chcesz pracowa??");
        showPlayerProjects();
        Integer chosenNumber = catchNumber(0, createdPlayers.get(currentPlayer).project.size());
        if (chosenNumber != 0) {
            chosenNumber -= 1;
            if (!projectEnded(chosenNumber)) {
                if (checkPlayerSignProject(chosenNumber)) {


                    System.out.println("Przed   " + createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.toString());
                    addingPlayerProjectStatus(chosenNumber);

                    System.out.println("Po      " + createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.toString());

                }
                if (!checkPlayerSignProject(chosenNumber)) {
                    System.out.println("Ten projekt nie jest podpisany, najpierw podpisz go z zleceniodwac?? kontraktu");
                    skip = true;
                }
            }

            if (projectEnded(chosenNumber)) {
                System.out.println("Jak chcesz pracowac nad skonczonnym projektem");
            }
        }
        if (chosenNumber == 0) {
            skip = true;
        }
    }

    public static void fireWorker() {
        System.out.println("0 Wraca do Menu");
        if (playerWorker.size() == 0) {
            System.out.println("Nie masz pracownik??w");
            skip = true;
        }
        if (playerWorker.size() != 0) {
            System.out.println("0 wraca do menu");
            System.out.println("Wybierz pracownika k??rego chcesz zwolni??");
            showPlayerWorkers();
            Integer chosenNumber = catchNumber(0, playerWorker.size());
            if (chosenNumber == 0) {
                skip = true;
            }
            if (chosenNumber != 0) {
                createdPlayers.get(currentPlayer).money -= playerWorker.get(chosenNumber - 1).cost;
                playerWorker.remove(chosenNumber - 1);

            }
        }
    }

    public static boolean checkPlayerSignProject(Integer chosenProject) {
        if (
                !createdPlayers.get(currentPlayer).project.get(chosenProject).signed) {


            return false;
        }
        return true;

    }

    public static void addingPlayerProjectStatus(Integer chosenNumber) {
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend + justPlayer.get(currentPlayer).frontend <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend += justPlayer.get(currentPlayer).frontend;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.backend + justPlayer.get(currentPlayer).backend <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.backend += justPlayer.get(currentPlayer).backend;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.backend = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.bazaDanych + justPlayer.get(currentPlayer).bazaDanych <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.bazaDanych += justPlayer.get(currentPlayer).bazaDanych;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.bazaDanych = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.mobile + justPlayer.get(currentPlayer).mobile <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.mobile += justPlayer.get(currentPlayer).mobile;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.mobile = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.wordpress + justPlayer.get(currentPlayer).wordpress <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.wordpress += justPlayer.get(currentPlayer).wordpress;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.wordpress = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.prestashop + justPlayer.get(currentPlayer).prestashop <= 100) {
            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.prestashop += justPlayer.get(currentPlayer).prestashop;
            createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer = true;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.prestashop = 100;
        }
    }

    public static void testProject() {

        System.out.println("Testowanie projektu");
        System.out.println("Kt??ry projekt chcesz przetestowa??");
        System.out.println("0 wraca do menu");
        boolean sure;

        do {

            sure = false;
            for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
                Integer projectNumber = i + 1;
                System.out.println("Nr Projektu to " + projectNumber + "    " + createdPlayers.get(currentPlayer).project.get(i));
            }

            Integer chosenNumber = catchNumber(0, createdPlayers.get(currentPlayer).project.size());

            if (chosenNumber == 0) {
                skip = true;
                break;
            } else {
                chosenNumber -= 1;
                if (!createdPlayers.get(currentPlayer).project.get(chosenNumber).tested) {
                    if (projectEnded(chosenNumber)) {
                        System.out.println("Potwierd?? (y/n)");
                        String confirm = catchString("y", "n");
                        if (confirm.equals("y")) {
                            sure = true;
                            createdPlayers.get(currentPlayer).project.get(chosenNumber).testProject();
                            System.out.println(createdPlayers.get(currentPlayer).project.get(chosenNumber));
                        }
                    }
                } else if (createdPlayers.get(currentPlayer).project.get(chosenNumber).tested) {
                    System.out.println("Ten Projekt zosta?? ju?? przetestowany");
                    skip = true;
                    sure = true;
                }
            }
        }
        while (sure == false);

    }


    public static boolean projectEnded(Integer chosenNumber) {
        System.out.println(createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend);
        if (
                createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.backend == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.bazaDanych == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.mobile == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.wordpress == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.prestashop == 100

        ) {
            return true;
        } else {
            System.out.println("Projekt si?? jeszcze nie sko??czy??");
            return false;
        }
    }

    public void choseStartingProject() {


        System.out.println("Do wyboru masz 3 projekty");
        System.out.println("Wybierz projekty pod wzgl??dem trudno??ci ");
        System.out.println("Projekt wybiera  ===> " + this.name);
        System.out.println("1. ??awty ");
        System.out.println("2. ??redni ");
        System.out.println("3. Ci????ki ");
        boolean done = false;
        do {
            int chosenNumber = catchNumber(1, 3);
            //generuje projekty na pocz??tek gry
            switch (chosenNumber) {

                case 1 -> {
                    System.out.println("Projekt ??atwy");
                    this.addProject(generateEasyProject());
                    done = true;


                }
                case 2 -> {
                    System.out.println("Projekt ??redni");
                    this.addProject(generateMediumProject());
                    done = true;


                }

                case 3 -> {
                    System.out.println("Projekt ??i????ki");
                    this.addProject(generateHardProject());
                    done = true;

                }
                default -> {
                    System.out.println("Z??y wyb??r.");
                }
            }


        } while (!done);

    }

    public static boolean fortuneWheel(Integer chance) {
        Integer fortune = getRandomNumber(0, 100);
        if (fortune <= chance) {
            return true;
        }
        return false;
    }

    public static boolean checkIfProjectIsCompleted(Integer chosenNumber) {
        if (
                createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.frontend == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.backend == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.bazaDanych == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.mobile == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.wordpress == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).Progress.prestashop == 100
                        && createdPlayers.get(currentPlayer).project.get(chosenNumber).signed

        ) {
            System.out.println("Tw??j projekt jest sko??czony");
            return true;
        }
        System.out.println("Tw??j projekt jest jeszcze nie sko??czony");
        skip = true;
        return false;
    }

    private static boolean checkIfProjectWorks(Integer chosenNumber) {
        if (createdPlayers.get(currentPlayer).project.get(chosenNumber).tested) {
            return true;
        }
        if (getRandomNumber(0, 1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void giveClientProject() {
        System.out.println("0 Wracasz do Menu");
        System.out.println("Wybierz projekt do oddania");
        showPlayerProjects();
        Integer chosenNumber = catchNumber(0, createdPlayers.get(currentPlayer).project.size());
        if (chosenNumber == 0) {
            skip = true;
        }
        if (chosenNumber != 0) {

            chosenNumber -= 1;
            if (checkIfProjectIsCompleted(chosenNumber)) {
                System.out.println("Czy na pewno chcesz odda?? projekt? (y/n)");
                String input = catchString("y", "n");
                if (input.equals("y")) {

                    if (createdPlayers.get(currentPlayer).project.get(chosenNumber).clientBehaviour.ClientType.equals("Wyluzowany")) {


                        if (fortuneWheel(30)) {

                            System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany" + "\n" + "Pieni??dze za projekt przyjd?? za 7 dni");
                            moneyDelay.add(new PaymentDelay(createdPlayers.get(currentPlayer).project.get(chosenNumber).income, 7, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                            removePlayerProject(chosenNumber);
                        } else {
                            System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                            moneyDelay.add(new PaymentDelay(projectIncome(chosenNumber), createdPlayers.get(currentPlayer).project.get(chosenNumber).payDay, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                            removePlayerProject(chosenNumber);
                        }


                    } else if (createdPlayers.get(currentPlayer).project.get(chosenNumber).clientBehaviour.ClientType.equals("Wymagaj??cy")) {
                        if (checkIfProjectWorks(chosenNumber) || countTester() >= countDev() / 3) {
                            System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                            moneyDelay.add(new PaymentDelay(projectIncome(chosenNumber), createdPlayers.get(currentPlayer).project.get(chosenNumber).payDay, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                            removePlayerProject(chosenNumber);


                        } else {
                            if (fortuneWheel(50)) {
                                System.out.println("Projekt mia?? b????d ale klient nie zauwa??y??");
                                moneyDelay.add(new PaymentDelay(projectIncome(chosenNumber), createdPlayers.get(currentPlayer).project.get(chosenNumber).payDay, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                                removePlayerProject(chosenNumber);
                            } else {
                                System.out.println("Projekt przepad?? na zawsze, mia?? b????dy, 0 incomu, unlucki");
                                removePlayerProject(chosenNumber);
                            }
                        }

                    } else if (createdPlayers.get(currentPlayer).project.get(chosenNumber).clientBehaviour.ClientType.equals("Skurwiel")) {
                        if (checkIfProjectWorks(chosenNumber) || countTester() >= countDev() / 3) {
                            if (fortuneWheel(30)) {
                                System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                                System.out.println("Skurwiel da pieni??dze za tydzie??");
                                moneyDelay.add(new PaymentDelay(createdPlayers.get(currentPlayer).project.get(chosenNumber).income, 7, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                                removePlayerProject(chosenNumber);
                            } else if (fortuneWheel(5)) {
                                System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                                System.out.println("Skurwiel da pieni??dze za miesi??c");
                                moneyDelay.add(new PaymentDelay(createdPlayers.get(currentPlayer).project.get(chosenNumber).income, 30, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                                removePlayerProject(chosenNumber);
                            } else if (fortuneWheel(1)) {
                                System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                                System.out.println("Skurwiel nie da ani centa");
                                removePlayerProject(chosenNumber);

                            } else {
                                System.out.println("Projekt nie mia?? b????d??w i zosta?? oddany");
                                moneyDelay.add(new PaymentDelay(projectIncome(chosenNumber), createdPlayers.get(currentPlayer).project.get(chosenNumber).payDay, createdPlayers.get(currentPlayer).project.get(chosenNumber).level, createdPlayers.get(currentPlayer).project.get(chosenNumber).touchedByPlayer, createdPlayers.get(currentPlayer).project.get(chosenNumber).gottenBySeller));
                                removePlayerProject(chosenNumber);
                            }
                        } else {
                            System.out.println("Tw??j projek mia?? b????d, a klient nie godzi si?? na b????dy i m??wi papa");
                            removePlayerProject(chosenNumber);
                        }
                    }
                }

            }
        }


    }


    public static void turnEnd() {
        if (!skip) {


            for (int counterProject = 0; counterProject < createdPlayers.get(currentPlayer).project.size(); counterProject++) {
                if (playerWorker.size() > 0) {

                    for (int workerCounter = 0; workerCounter < playerWorker.size(); workerCounter++) {


                        if (checkPlayerSignProject(counterProject)) {
                            if (!createdPlayers.get(currentPlayer).project.get(counterProject).prePaymenDone) {
                                prepayment(counterProject);
                            }
                            workerJob(workerCounter, counterProject);

                        }
                    }
                }
            }


        }

    }

    private static void workerJob(Integer currentWorker, Integer currentProject) {

        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.frontend + playerWorker.get(currentWorker).frontend <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.frontend += playerWorker.get(currentWorker).frontend;

        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.frontend = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.backend + playerWorker.get(currentWorker).backend <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.backend += playerWorker.get(currentWorker).backend;
        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.backend = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.bazaDanych + playerWorker.get(currentWorker).bazaDanych <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.bazaDanych += playerWorker.get(currentWorker).bazaDanych;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.bazaDanych = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.mobile + playerWorker.get(currentWorker).mobile <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.mobile += playerWorker.get(currentWorker).mobile;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.mobile = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.wordpress + playerWorker.get(currentWorker).wordpress <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.wordpress += playerWorker.get(currentWorker).wordpress;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.wordpress = 100;
        }
        if (createdPlayers.get(currentPlayer).project.get(currentProject).Progress.prestashop + playerWorker.get(currentWorker).prestashop <= 100) {
            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.prestashop += playerWorker.get(currentWorker).prestashop;
            ;
        } else {

            createdPlayers.get(currentPlayer).project.get(currentProject).Progress.prestashop = 100;
        }

    }

    public static void setNextPlayer() {
        if (!skip) {
            playerList.add(playerList.get(0)); //ustawnienie obecnego gracza na koniec kolejki
            playerList.remove(0);  //usuwa gracza obecnego z kolejki
            currentPlayer += 1;

        }

    }


    public static void removePlayerProject(Integer projectIndexToRemove) {
        createdPlayers.get(currentPlayer).project.remove(createdPlayers.get(currentPlayer).project.get(projectIndexToRemove));
    }

    public static void playerAddMoney(Integer moneyToAdd) {
        createdPlayers.get(currentPlayer).money += moneyToAdd;
    }

    public static Integer projectIncome(Integer chosenNumber) {
        return createdPlayers.get(currentPlayer).project.get(chosenNumber).income;
    }

    public static void lowerDayInProject() {
        for (int i = 0; i < createdPlayers.get(currentPlayer).project.size(); i++) {
            if (createdPlayers.get(currentPlayer).project.get(i).signed) {
                createdPlayers.get(currentPlayer).project.get(i).deadLine -= 1;
                if (createdPlayers.get(currentPlayer).project.get(i).deadLine == 0) {
                    System.out.println("Nie zd??zy??e?? odda?? projetku nr" + createdPlayers.get(currentPlayer).project.get(i).projectName + "  na czas");
                    System.out.println("Kara wynosi  " + createdPlayers.get(currentPlayer).project.get(i).penaltyCost);
                    createdPlayers.get(currentPlayer).money -= createdPlayers.get(currentPlayer).project.get(i).penaltyCost;
                    createdPlayers.get(currentPlayer).project.remove(createdPlayers.get(currentPlayer).project.get(i));
                }
            }
        }

    }

    public static void payDayMoneyToPlayer() {
        for (int i = 0; i < moneyDelay.size(); i++) {
            if (moneyDelay.get(i).dayDelay == 0) {
                if (moneyDelay.get(i).level.equals("Hard")) {
                    if (!moneyDelay.get(i).touchedByPlayer) {
                        if (!moneyDelay.get(i).gottenBySeller) {
                            createdPlayers.get(currentPlayer).bigProject += 1;
                            System.out.println("Masz juz " + createdPlayers.get(currentPlayer).bigProject + " du??ych projekt??w");


                        }
                    }
                }
                createdPlayers.get(currentPlayer).money += moneyDelay.get(i).money;
                moneyDelay.remove(moneyDelay.get(i));
            } else {
                moneyDelay.get(i).dayDelay -= 1;
            }
        }
    }

    public static void sellerMove() {
        for (int i = 0; i < countSellers(); i++) {
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
                System.out.println("Czy kt??ry?? projekt ci?? interesuje i chcesz zdoby?? klienta?" + "\n" + "Je??li nie naci??nij 0");
                showAllPlayerProjects();
                Integer chosenNumber = catchNumber(0, allProjects.size());
                if (chosenNumber != 0) {
                    createdPlayers.get(currentPlayer).project.add(allProjects.get(chosenNumber - 1));
                    createdPlayers.get(currentPlayer).project.get(createdPlayers.get(currentPlayer).project.size() - 1).gottenBySeller = true;
                    allProjects.remove(chosenNumber - 1);
                }

                createdPlayers.get(currentPlayer).availableProjectDays = 0;
            } else {

                Integer dayLeft = 5 - createdPlayers.get(currentPlayer).availableProjectDays;
                if (dayLeft > 1) {
                    System.out.println("Zosta??y " + dayLeft + " dni, aby znale???? nast??pnego klienta");
                } else {
                    System.out.println("Zosta??y ostatni dzie?? poszukiwa??, aby znale???? klienta");
                }
                createdPlayers.get(currentPlayer).availableProjectDays += 1;
            }

        }

    }

    public static Integer countSellers() {
        Integer count = 0;
        for (Worker worker : playerWorker) {
            if (worker.seller == 1) {
                count++;
            }
        }
        return count;
    }

    public static Integer countTester() {
        Integer count = 0;
        for (Worker worker : playerWorker) {
            if (worker.tester == 1) {
                count++;
            }
        }
        return count;
    }

    public static Integer countDev() {
        Integer count = 0;
        for (Worker worker : playerWorker) {
            if (worker.jobPostion.equals("Programista")) {
                count++;
            }
        }
        return count;
    }

    public static void friendDoHisJob(Integer chosenFriend, Integer chosenProject) {
        chosenProject -= 1;
        if (chosenFriend == 1) {

            createdPlayers.get(currentPlayer).project.get(chosenProject).income = createdPlayers.get(currentPlayer).project.get(chosenProject).income / 2;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).tested = true;
        }
        if (chosenFriend == 2) {
            if (fortuneWheel(90)) {
                createdPlayers.get(currentPlayer).project.get(chosenProject).income = (createdPlayers.get(currentPlayer).project.get(chosenProject).income * 3) / 4;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).tested = true;

            } else
                createdPlayers.get(currentPlayer).project.get(chosenProject).income = (createdPlayers.get(currentPlayer).project.get(chosenProject).income * 3) / 4;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
            createdPlayers.get(currentPlayer).project.get(chosenProject).tested = false;


        }
        if (chosenFriend == 3) {
            if (fortuneWheel(20)) {
                createdPlayers.get(currentPlayer).project.get(chosenProject).income = (createdPlayers.get(currentPlayer).project.get(chosenProject).income * 17) / 20;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).tested = false;
            } else if (fortuneWheel(20)) {
                createdPlayers.get(currentPlayer).project.get(chosenProject).income = (createdPlayers.get(currentPlayer).project.get(chosenProject).income * 17) / 20;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).tested = true;
                createdPlayers.get(currentPlayer).project.get(chosenProject).deadLine = 0;
            } else {
                createdPlayers.get(currentPlayer).project.get(chosenProject).income = (createdPlayers.get(currentPlayer).project.get(chosenProject).income * 17) / 20;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.frontend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.backend = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.bazaDanych = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.mobile = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.wordpress = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).Progress.prestashop = 100;
                createdPlayers.get(currentPlayer).project.get(chosenProject).tested = true;
            }
        }

    }

    //zaliczka za po??ow?? zap??aty projektu ( Zadanie 2)
    public static void prepayment(Integer projectNumber) {
        if (createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.frontend >= 50 ||
                createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.backend >= 50 ||
                createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.bazaDanych >= 50 ||
                createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.mobile >= 50 ||
                createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.prestashop >= 50 ||
                createdPlayers.get(currentPlayer).project.get(projectNumber).Progress.wordpress >= 50) {

            System.out.println("Przysz??a polowa wyp??aty za projekt");
            createdPlayers.get(currentPlayer).money += createdPlayers.get(currentPlayer).project.get(projectNumber).income / 2;
            createdPlayers.get(currentPlayer).project.get(projectNumber).income = createdPlayers.get(currentPlayer).project.get(projectNumber).income / 2;
            createdPlayers.get(currentPlayer).project.get(projectNumber).halfProjectMoney = true;
            createdPlayers.get(currentPlayer).project.get(projectNumber).prePaymenDone = true;
        }
    }


}
