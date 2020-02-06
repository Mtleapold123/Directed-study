import javax.swing.*;
import javax.swing.event.TableModelEvent;
import java.awt.event.PaintEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class intro extends JFrame {

    public static void Introduction() throws InterruptedException {
        Scanner n = new Scanner(System.in);
        System.out.println("This is a Political Simulator. You have just been elected as a Congressman as a \nrepresentative of Michigan's 12th district. You stand in a line waiting for a mentor and a desk.\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Secretary\nHello Sir, what's your first name?\n");
        callFromIntro.firstName = n.next();
        System.out.println("\n");
        System.out.println("Secretary\nAnd Last name?\n");
        callFromIntro.lastName = n.next();
        System.out.println("Secretary\nLast thing is Your Political Party. 1: Democrat 2: Republican 3: Independent");
        int yourParty = n.nextInt();
        if (yourParty == 1){
            callFromIntro.party = "Democrat";
        } else if (yourParty == 2){
            callFromIntro.party = "Republican";
        } else {
            callFromIntro.party = "Independent";
        }
        mainSystem.Stats.party = callFromIntro.party;
        System.out.println("\n");
        System.out.println("Secretary\nWell then " + callFromIntro.firstName + " We are so happy to have you serve in the greatest \ngoverning body on the planet. You will be working with Kieren.\n");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nGood Morning (He has a very thick british accent)\n");
        mainSystem.addToContacts("Kieren");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: And Good Morning to you");
        System.out.println("2: You're my american political advisor? really?\n");
        int A = n.nextInt();
        if (A == 1) {
            System.out.println("Kieren\nLet me take you to your office and I'll explain some stuff on the way.");
            mainSystem.Stats.karma = mainSystem.Stats.karma + 5;
        } else if (A == 2) {
            System.out.println("I see. In reality I am the Smartest Political Scientist you could of gotten. Bad move Mr. " + callFromIntro.lastName);
            mainSystem.Stats.karma = mainSystem.Stats.karma - 5;
        }
        System.out.println("Kieren\nSo first things first, the most important thing to know is your stats.");
        mainSystem.table();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Those will affect how others react to you. keep track of them so you know what you need to \nimprove on.");
        if (A == 2) {
            System.out.print("As you can see, you're already behind Mr. " + callFromIntro.lastName);
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Another thing to know is it is scary here in Washington, so I will try to help you as much\n as possible. Here is your Office. Would that be all?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yes, Thank You.");
        System.out.println("2: Wait I have questions.");
        int B = n.nextInt();
        if (B == 2) {
            System.out.println("Everything will be explained in time, in time.");
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("You sit down in office and get settled in for starting tomorrow, you will never have peace again.");
    }

    public static class callFromIntro{
        public static String firstName;
        public static String lastName;
        public static String party;
    }
}