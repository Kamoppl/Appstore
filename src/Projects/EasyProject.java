package Projects;

import java.security.SecureRandom;
import java.util.ArrayList;

public class EasyProject {
    public String projectName = randomString(3);
    public String client = randomString(1);
    public Integer deadLine = getRandomNumber(6, 10);
    public Integer penaltyCost = getRandomNumber(100, 400);
    public Integer income = getRandomNumber(400, 1000);
    public Integer payDay = getRandomNumber(0, 1);
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();


    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String toString() {
        return "EasyProject{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                '}';
    }

}
