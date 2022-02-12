package Projects;
import com.company.Client;

import java.security.SecureRandom;

public class Project {
public String level;
    public String projectName;
    public String client;
    public Client clientBehaviour;
    public Integer deadLine;
    public Integer penaltyCost;
    public Integer income;
    public Integer payDay;
    public boolean tested=false;
    public boolean signed = false;
    public ProjectProgress Progress;
    public boolean touchedByPlayer;
    public boolean gottenBySeller;
    public boolean halfProjectMoney;
    public boolean prePaymenDone;
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();




    public  Project (String projectLevel) {
        if (projectLevel.equals( "Easy")) {
            this.level="Easy";
            this.projectName = randomString(3);
            this.client = randomString(1);
            this.clientBehaviour= new Client();
            this.deadLine = getRandomNumber(6, 10);
            this.penaltyCost = getRandomNumber(100, 400);
            this.income = getRandomNumber(400, 1000);
            this.payDay = getRandomNumber(0, 1);
            this.Progress= new ProjectProgress("Easy");
            this.touchedByPlayer=false;
            this.gottenBySeller=false;
            this.halfProjectMoney=false;
            this.prePaymenDone=false;

        }
        if (projectLevel.equals( "Medium")) {
            this.level="Medium";
            this.projectName = randomString(5);
            this.client = client = randomString(3);
            this.clientBehaviour= new Client();
            this.deadLine = getRandomNumber(4, 6);
            this.penaltyCost = getRandomNumber(300, 500);
            this.income = getRandomNumber(1000, 2000);
            this.payDay = getRandomNumber(1, 2);
            this.Progress= new ProjectProgress("Medium");
            this.touchedByPlayer=false;
            this.gottenBySeller=false;
            this.halfProjectMoney=false;
            this.prePaymenDone=false;

        }
        if (projectLevel.equals( "Hard")) {
            this.level="Hard";
            this.projectName = randomString(7);
            this.client = randomString(5);
            this.clientBehaviour= new Client();
            this.deadLine = getRandomNumber(3, 5);
            this.penaltyCost = getRandomNumber(200, 1000);
            this.income = getRandomNumber(2000, 3000);
            this.payDay = getRandomNumber(1, 2);
            this.Progress= new ProjectProgress("Hard");
            this.touchedByPlayer=false;
            this.gottenBySeller=false;
            this.halfProjectMoney=false;
            this.prePaymenDone=false;


        }
        if (projectLevel.equals( "Ended")) {
            this.level="Hard";
            this.projectName = randomString(1);
            this.client = randomString(1);
            this.deadLine = getRandomNumber(1,1);
            this.clientBehaviour= new Client();
            this.penaltyCost = getRandomNumber(200, 1000);
            this.income = getRandomNumber(2000, 3000);
            this.payDay = getRandomNumber(1, 2);
            this.signed=true;
            this.tested=false;
            this.Progress= new ProjectProgress("Ended");
            this.touchedByPlayer=false;
            this.gottenBySeller=true;
            this.halfProjectMoney=false;
            this.prePaymenDone=false;


        }
    }

    public void signProject() {
        this.signed = true;

    }
    public void testProject(){
        this.tested=true;
    }

    public String toString() {
        return "Project{" +
                "Nazwa Projektu='" + projectName + '\'' +
                ", Nazwa Klienta='" + client + '\'' +
                ", ilość dni na zrobienie projektu = " + deadLine +
                ", koszt w razie nie dotrzymania terminu = " + penaltyCost +
                ", zysk = " + income +
                ", umówiona ilość dni do otrzymania wypłaty=" + payDay +
                ", czy podpisano projekt z klientem = " + signed +
                ", czy proejkt został przetestowany = " + tested +
                '}';
    }
    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
