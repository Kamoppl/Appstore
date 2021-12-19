package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class HardProject {
    public String projectName;
    public Dayneeded dayNeeded;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public Integer difficulty=2;

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();



    public void Project(String projectName, Dayneeded dayNeeded, String client, Integer deadLine, Integer penaltyCost, Integer cost, Integer payDay,Integer Difficulty){
        this.projectName = randomString(7);
        this.dayNeeded = dayNeeded;
        this.client = randomString(5);
        this.deadLine = getRandomNumber(3,5);
        this.penaltyCost = getRandomNumber(200,1000);
        this.income = getRandomNumber(2000,3000);
        this.payDay = getRandomNumber(0,1);
        this.difficulty=2;

    }

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
