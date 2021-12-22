package Projects;

import com.company.Dayneeded;

import java.security.SecureRandom;

public class HardProject {
    public String projectName = randomString(7) ;
    public String client=randomString(5);
    public Integer deadLine=getRandomNumber(3,5);
    public Integer penaltyCost=getRandomNumber(200,1000);
    public Integer income=getRandomNumber(2000,3000);
    public Integer payDay=getRandomNumber(1,2);
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();


    @Override
    public String toString() {
        return "HardProject{" +
                "projectName='" + projectName + '\'' +
                ", client='" + client + '\'' +
                ", deadLine=" + deadLine +
                ", penaltyCost=" + penaltyCost +
                ", income=" + income +
                ", payDay=" + payDay +
                '}';
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
