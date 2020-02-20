import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Section5 {
    public static void section5() throws InterruptedException{
        section5Part1();
    }

    public static void section5Part1() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nI was thinking you could run for president.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yes 2: No");
        int A = n.nextInt();
        if (A == 2){
            System.out.println("Take more risks.");
        } else {
            if (mainSystem.Stats.wisdom >= 50 && mainSystem.Stats.SPC >= 50 && mainSystem.Stats.OPC >= 50 && mainSystem.Stats.karma >= 50 && mainSystem.Stats.billsPassed >= 1) {
                System.out.println("You Win the Election and win the game.");
                TimeUnit.SECONDS.sleep(2);
            } else{
                System.out.println("You loose the Election.");
                mainSystem.Stats.x += 1;
            }
        }
    }
}
