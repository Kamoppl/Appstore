package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class MediumProject {
    public String projectName = randomString(5);
    public String client = randomString(3);
    public Integer deadLine = getRandomNumber(4, 6);
    public Integer penaltyCost = getRandomNumber(300, 500);
    public Integer income = getRandomNumber(1000, 2000);
    public Integer payDay = getRandomNumber(1, 2);
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

    @Override
    public String toString() {
        return "MediumProject{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                '}';
    }
}
