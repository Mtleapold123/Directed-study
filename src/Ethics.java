import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ethics {
    public static void ethics() throws InterruptedException{
        ethicsPart1();
        ethicsPart2();
    }

    public static void ethicsPart1() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nNice job getting the committee job. You won't have it for long though because your dad's\nhelping you move up in the world.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("It's time for your first vote. You'll do great.");
    }

    public static void ethicsPart2() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        System.out.println("Elton\nHere Ye, Here Ye. We now gather for the Ethics committee meeting. There will be 3 cases.\nThe secretary will now read the first case.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Secretary\nThank you Mr. Chair. Case #42, Mr. Housman, Representative from New York's 13th district, is accused of threatening other members of congress.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Elton\nMr. Housman, how do you plea?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Guilty Mr. Chair.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Bowie\nI move to sentence Mr. Housman based on a chair proposal and community vote.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Second his motion 2: stay silent.");
        int A = n.nextInt();
        if (A == 1){
            System.out.println("\nI second Mr. Bowie's motion.");
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
        } else {
            System.out.println("Reeves\nI second Mr. Bowie's motion.");
            mainSystem.Stats.wisdom -= 5;
            mainSystem.Stats.SPC -= 5;
        }
        System.out.println("Elton\nAy's?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: AY 2: NAY");
        int B = n.nextInt();
        if (B == 2 && A == 1){
            mainSystem.Stats.wisdom -= 10;
            mainSystem.Stats.SPC -= 10;
            System.out.println("Nay");
        } else if (B == 2){
            mainSystem.Stats.wisdom -= 5;
            System.out.println("Nay");
        } else if (B == 1){
            System.out.println("Ay");
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Elton\nMotion passed. I propose a $200 fine and a written apology to all members affected that will be in the public record.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("1: AY 2: NAY");
        int C = n.nextInt();
        if (C == 2){
            mainSystem.Stats.wisdom -= 10;
            System.out.println("Nay");
        } else {
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
        }
        System.out.println("Elton\nNext case please Mrs. Secretary.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Secretary\nCase #31an0r3 Louis Ventrion Donald the 3rd is accused of making rotton deals with other members of congress resulting in collusion.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Elton\nMr. Donald, how do you plea?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Lou\nNot Guilty.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Elton\nI will send you over to the Judiciary committee where A trial will be held. Any Objections?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Object 2: Stay quiet.");
        int D = n.nextInt();
        if (D == 2){
            mainSystem.Stats.karma -= 10;
            mainSystem.Stats.wisdom -= 5;
        } else {
            System.out.println("\nI object Mr. Chair on the grounds of impeachment. Lou offered me a deal when I first came into congress and I have evidence and would like to testify to such.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Make an official motion 2: just testify later.");
            int E = n.nextInt();
            if (E == 2){
                System.out.println("(After the meeting)\nElton\nYou can't just accuse people like that in official settings. You're off the committee.");
                mainSystem.Stats.x += 1;
            } else {
                System.out.println("\nI move to sentence Lou now. I know I'm not the only one up here who thinks this.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Reeves\nI second.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Elton\nPasses unanimously. Your trial dates will be sent to you by mail, until then you are disbarred from congress.");
            }
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Secretary\nCase #r1g3y, final case of today, tha accusation against the Speaker for tearing up the presidents speech.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Elton\nHow do you plea?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Balif\nThey skipped the meeting.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Elton\nWell, they will be punished for that. Meeting adjourned.");
    }
}