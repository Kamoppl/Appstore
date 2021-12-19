package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class EasyProject {
    public String projectName;
    public Dayneeded dayNeeded;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public Integer difficulty=0;

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();



    public void Project(String projectName, Dayneeded dayNeeded, String client, Integer deadLine, Integer penaltyCost, Integer cost, Integer payDay,Integer Difficulty){
        this.projectName = randomString(3);
        this.dayNeeded = dayNeeded;
        this.client = randomString(1);
        this.deadLine = getRandomNumber(5,8);
        this.penaltyCost = getRandomNumber(0,200);
        this.income = getRandomNumber(500,1500);
        this.payDay = getRandomNumber(0,2);
        this.difficulty=0;
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
