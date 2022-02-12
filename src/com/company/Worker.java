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
        if (this.jobPostion.equals("Programista"))
            return jobPostion +
                    "    pensja  = " + cost +
                    " To umie =>  " +
                    ", frontend = " + frontend +
                    ", backend = " + backend +
                    ", bazaDanych = " + bazaDanych +
                    ", mobile = " + mobile +
                    ", wordpress = " + wordpress +
                    ", prestashop = " + prestashop +
                    '}';
        if (this.jobPostion.equals("Tester")) {
            return "Tester";
        }
        if (this.jobPostion.equals("Sprzedawca")) {
            return "Sprzedawca";
        }
        return "";
    }


    public Worker(String workerName) {
        if (workerName.equals("Player")) {
            this.jobPostion = "Gracz";
            this.cost = 0;
            this.frontend = 30;
            this.backend = 20;
            this.bazaDanych = 10;
            this.mobile = 0;
            this.prestashop = 20;
            this.wordpress = 20;
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
        if (workerName.equals("Paweł")) {
            this.jobPostion = "friend";
            this.cost = 1000;
            this.frontend = 0;
            this.backend = 0;
            this.bazaDanych = 0;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 0;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Cezary")) {
            this.jobPostion = "friend";
            this.cost = 1000;
            this.frontend = 0;
            this.backend = 0;
            this.bazaDanych = 0;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 0;
            this.tester = 0;
            this.seller = 0;
        }
        if (workerName.equals("Artur")) {
            this.jobPostion = "friend";
            this.cost = 1000;
            this.frontend = 0;
            this.backend = 0;
            this.bazaDanych = 0;
            this.mobile = 0;
            this.wordpress = 0;
            this.prestashop = 0;
            this.tester = 0;
            this.seller = 0;
        }


    }
}

