package Projects;

import com.company.Client;

import java.security.SecureRandom;

public class Project {

    public String projectName;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public boolean signed = false;
    public Client projectClient;
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

    public Project(String projectLevel) {
        if (projectLevel == "Easy") {
            this.projectName = randomString(3);
            ;
            this.client = randomString(1);
            this.deadLine = getRandomNumber(6, 10);
            this.penaltyCost = getRandomNumber(100, 400);
            this.income = getRandomNumber(400, 1000);
            this.payDay = getRandomNumber(0, 1);
        }
        if (projectLevel == "Medium") {
            this.projectName = randomString(5);
            this.client = client = randomString(3);
            this.deadLine = getRandomNumber(4,6);
            this.penaltyCost = getRandomNumber(300, 500);
            this.income = getRandomNumber(1000, 2000);
            this.payDay = getRandomNumber(1, 2);
        }
        if (projectLevel == "Hard") {
            this.projectName = randomString(7);
            this.client = randomString(5);
            this.deadLine = getRandomNumber(3, 5);
            this.penaltyCost = getRandomNumber(200, 1000);
            this.income = getRandomNumber(2000, 3000);
            this.payDay = getRandomNumber(1, 2);
        }
    }


    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                ", signed=" + signed +
                '}';
    }
}
