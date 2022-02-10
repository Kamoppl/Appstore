package com.company;


public class Worker {
    Integer cost;
    public String jobPostion;
    public Integer frontend = 0;
    public Integer backend = 0;
    public Integer bazaDanych = 0;
    public Integer mobile = 0;
    public Integer wordpress = 0;
    public Integer prestashop = 0;
    public Integer tester = 0;
    public Integer seller = 0;


    public Worker(Integer cost, Integer frontend, Integer backend, Integer bazaDanych, Integer mobile, Integer wordpress, Integer prestashop, Integer tester, Integer selller) {
        this.cost = cost;
        this.frontend = frontend;
        this.backend = backend;
        this.bazaDanych = bazaDanych;
        this.mobile = mobile;
        this.wordpress = wordpress;
        this.prestashop = prestashop;
    }


    public String toString() {
        return "Worker{" +
                "cost=" + cost +
                ", jobPostion='" + jobPostion + '\'' +
                ", frontend=" + frontend +
                ", backend=" + backend +
                ", bazaDanych=" + bazaDanych +
                ", mobile=" + mobile +
                ", wordpress=" + wordpress +
                ", prestashop=" + prestashop +
                ", tester=" + tester +
                ", seller=" + seller +
                '}';
    }

/*    public String toString() {
        return "Worker" + jobPostion+" to jego cena =>" + cost;
    }*/

    public Worker(String workerName) {
        if (workerName.equals("Player")) {
            this.jobPostion = "Gracz";
            this.cost = 0;
            this.frontend = 30;
            this.backend = 20;
            this.bazaDanych = 10;
            this.mobile = 0;
            this.prestashop = 0;
            this.wordpress = 0;
        }
        if (workerName.equals("Kamil")) {
            this.jobPostion = "Programista";
            this.cost = 2000;
            this.frontend = 25;
            this.backend = 40;
            this.bazaDanych = 20;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 30;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Adam")) {
            this.jobPostion = "Programista";
            this.cost = 1800;
            this.frontend = 15;
            this.backend = 10;
            this.bazaDanych = 40;
            this.mobile = 10;
            this.wordpress = 10;
            this.prestashop = 10;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Maciej")) {
            this.jobPostion = "Programista";
            this.cost = 3000;
            this.frontend = 40;
            this.backend = 40;
            this.bazaDanych = 10;
            this.mobile = 30;
            this.wordpress = 35;
            this.prestashop = 30;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Borek")) {
            this.jobPostion = "Programista";
            this.cost = 2200;
            this.frontend = 30;
            this.backend = 20;
            this.bazaDanych = 10;
            this.mobile = 15;
            this.wordpress = 40;
            this.prestashop = 40;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Michał")) {
            this.jobPostion = "Programista";
            this.cost = 1500;
            this.frontend = 10;
            this.backend = 30;
            this.bazaDanych = 15;
            this.mobile = 40;
            this.wordpress = 0;
            this.prestashop = 30;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Marcin")) {
            this.jobPostion = "Programista";
            this.cost = 1600;
            this.frontend = 15;
            this.backend = 10;
            this.bazaDanych = 20;
            this.mobile = 20;
            this.wordpress = 20;
            this.prestashop = 25;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Marcin")) {
            this.jobPostion = "Tester";
            this.cost = 1500;
            this.frontend = 0;
            this.backend = 0;
            this.bazaDanych = 0;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 0;
            this.tester = 1;
            this.seller = 0;
        }
        if (workerName.equals("Mateusz")) {
            this.jobPostion = "Sprzedawca";
            this.cost = 1000;
            this.frontend = 0;
            this.backend = 0;
            this.bazaDanych = 0;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 0;
            this.tester = 0;
            this.seller = 1;
        }


    }
}
/*
    public static void createWorkers() {

        //programisci
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        Worker Kamil = new Worker(2000, 25, 40, 30, 20, 0, 30, 0, 0);
        allWorkers.set(0,Kamil);
        Worker Adam = new Worker(1800, 15, 10, 40, 10, 10, 10, 0, 0);
        allWorkers.add(Adam);
        Worker Maciej = new Worker(3000, 40, 40, 10, 30, 35, 30, 0, 0);
        allWorkers.add(Maciej);
        Worker Borek = new Worker(2200, 30, 20, 10, 15, 40, 40, 0, 0);
        allWorkers.add(Borek);
        Worker Michał = new Worker(1500, 10, 30, 15, 40, 0, 0, 0, 0);
        allWorkers.add(Michał);
        Worker Marcin = new Worker(1600, 15, 10, 20, 20, 20, 25, 0, 0);
        allWorkers.add(Marcin);
        //tester
        Worker Anna = new Worker(1500, 0, 0, 0, 0, 0, 0, 1, 0);
        allWorkers.add(Anna);
        //sprzedawca
        Worker Mateusz = new Worker(1000, 0, 0, 0, 0, 0, 0, 0, 1);
        allWorkers.add(Mateusz);



    }
}
*/

/*

    public static void addWorkers() {
        createWorkers(false);
        allWorkers.add(Kamil);
        allWorkers.add(Adam);
        allWorkers.add(Maciej);
        allWorkers.add(Borek);
        allWorkers.add(Michał);
        allWorkers.add(Marcin);
        //tester
        allWorkers.add(Anna);
        //programiści
        allWorkers.add(Mateusz);
    }

}
*/

