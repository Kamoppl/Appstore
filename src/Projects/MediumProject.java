package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class MediumProject {
    public String projectName;
    public Dayneeded dayNeeded;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public Integer difficulty=1;

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();



    public  MediumProject(){
        this.projectName = randomString(5);
        this.client = randomString(3);
        this.deadLine = getRandomNumber(4,6);
        this.penaltyCost = getRandomNumber(300,500);
        this.income = getRandomNumber(1000,2000);
        this.payDay = getRandomNumber(1,2);

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
