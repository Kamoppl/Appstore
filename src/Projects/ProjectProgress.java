package Projects;

import static com.company.Player.getRandomNumber;

public class ProjectProgress {
    public Integer frontend = 100;
    public Integer backend = 100;
    public Integer bazaDanych = 100;
    public Integer mobile = 100;
    public Integer wordpress = 100;
    public Integer prestashop = 100;

    public ProjectProgress(String poziom) {

        if (poziom.equals("Easy")) {
            int RNG;
            int max = getRandomNumber(1, 2);
            while (max < 3) {
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.frontend != 0) {
                    this.frontend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.backend != 0) {
                    this.backend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.bazaDanych != 0) {
                    this.bazaDanych = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.mobile != 0) {
                    this.mobile = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.wordpress != 0) {
                    this.wordpress = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.prestashop != 0) {
                    this.prestashop = 0;
                    max++;

                }
            }
        }
        if (poziom.equals("Medium")) {
            int RNG;
            int max = getRandomNumber(2, 3);
            while (max < 6) {
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.frontend != 0) {
                    this.frontend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.backend != 0) {
                    this.backend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.bazaDanych != 0) {
                    this.bazaDanych = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.mobile != 0) {
                    this.mobile = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.wordpress != 0) {
                    this.wordpress = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.prestashop != 0) {
                    this.prestashop = 0;
                    max++;

                }
            }
        }


        if (poziom.equals("Hard")) {
            int RNG;
            int max = getRandomNumber(3, 4);
            while (max < 5) {
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.frontend != 0) {
                    this.frontend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.backend != 0) {
                    this.backend = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.bazaDanych != 0) {
                    this.bazaDanych = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.mobile != 0) {
                    this.mobile = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.wordpress != 0) {
                    this.wordpress = 0;
                    max++;
                }
                RNG = getRandomNumber(0, 1);
                if (RNG == 1 && this.prestashop != 0) {
                    this.prestashop = 0;
                    max++;

                }
            }
        }
    }

    public void increaseFrontEndComplete(Integer frontIncrease) {
        this.frontend += frontIncrease;
    }

    public void increaseBackEndComplete(Integer backendIncrease) {
        this.frontend += backendIncrease;
    }

    public void increaseBazaDanychComplete(Integer bazaDanychIncrease) {
        this.frontend += bazaDanychIncrease;
    }

    public void increaseMobileComplete(Integer mobileIncrease) {
        this.frontend += mobileIncrease;
    }

    public void increaseWordPressComplete(Integer wordPressIncrease) {
        this.frontend += wordPressIncrease;
    }

    public void increasePrestaShopComplete(Integer prestaShopIncrease) {
        this.frontend += prestaShopIncrease;
    }
}