package Projects;

import java.security.SecureRandom;
import java.util.ArrayList;

public class AllProjects {
    public String projectName;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;


    public String toString() {
        return "\n"+"AllProjects{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                '}';
    }

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();
    public void GEasyProject() {
        this.projectName=randomString(3);
        this.client=randomString(1);
        this.deadLine=getRandomNumber(6,10);
        this.penaltyCost=getRandomNumber(100,400);
        this.income=getRandomNumber(400,1000);
        this.payDay=getRandomNumber(0,1);
    }
    static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }
}
