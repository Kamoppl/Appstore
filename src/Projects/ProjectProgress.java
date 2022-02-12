package Projects;


import java.util.ArrayList;
import java.util.Random;

import static com.company.Player.getRandomNumber;

public class ProjectProgress {
    public Integer frontend = 100;
    public Integer backend = 100;
    public Integer bazaDanych = 100;
    public Integer mobile = 100;
    public Integer wordpress = 100;
    public Integer prestashop = 100;


    public Integer[] properties = {this.frontend, this.backend, this.bazaDanych, this.mobile, this.wordpress, this.prestashop};

    public ProjectProgress(String level) {
        if (level.equals("Easy")) {
            randomDeleteParametrs(getRandomNumber(1, 1));

        }
        if (level.equals("Medium")) {
            randomDeleteParametrs(getRandomNumber(2, 3));

        }
        if (level.equals("Hard")) {
            randomDeleteParametrs(getRandomNumber(3, 4));

        }
        if (level.equals("Ended")) {
            this.frontend = 100;
            this.backend = 100;
            this.bazaDanych = 100;
            this.mobile = 100;
            this.wordpress = 100;
            this.prestashop = 100;
        }
    }

    public void randomDeleteParametrs(Integer counter) {


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        //ilość generowanego inta
        while (numbers.size() < counter) {
            // zakres inta
            int RNG = randomGenerator.nextInt(6);
            if (!numbers.contains(RNG)) {
                numbers.add(RNG);

                properties[RNG] = 0;

                if (this.frontend != 0) {
                    this.frontend = properties[0];
                }

                if (this.backend != 0) {
                    this.backend = properties[1];
                }

                if (this.bazaDanych != 0) {
                    this.bazaDanych = properties[2];
                }


                if (this.mobile != 0) {
                    this.mobile = properties[3];
                }


                if (this.wordpress != 0) {
                    this.wordpress = properties[4];
                }


                if (this.prestashop != 0) {
                    this.prestashop = properties[5];
                }

            }

        }


    }



    public String toString() {
        return "Statystyki projektu na dzień dzisiejszy" +
                "frontend = " + frontend +
                ", backend = " + backend +
                ", bazaDanych = " + bazaDanych +
                ", mobile = " + mobile +
                ", wordpress = " + wordpress +
                ", prestashop = " + prestashop +
                '}';
    }
}