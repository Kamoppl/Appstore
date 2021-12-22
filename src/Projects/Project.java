package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class Project {
    public String projectName;
    public String client;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public Integer difficulty;
    public Project project;

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();



    public void Project(String projectName, String client, Integer deadLine, Integer penaltyCost, Integer cost, Integer payDay, Integer Difficulty){
        this.projectName = randomString(6);
        this.client = randomString(6);
        this.deadLine = getRandomNumber(0,5);
        this.penaltyCost = getRandomNumber(0,5);
        this.income = getRandomNumber(0,5);
        this.payDay = getRandomNumber(0,5);
        this.difficulty=getRandomNumber(0,2);

    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                ", difficulty=" + difficulty +
                ", project=" + project +
                '}'+"\n";
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
