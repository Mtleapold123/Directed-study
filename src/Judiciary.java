import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Judiciary {
    public static void judiciary() throws InterruptedException{
        judiciaryPart1();
        judiciaryPart2();
    }

    public static void judiciaryPart1() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nNice job getting the committee job. You won't have it for long though because your dad's\nhelping you move up in the world.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("It's time for your first vote. You'll do great.");
    }

    public static void judiciaryPart2() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Elton\nHere ye, here ye, we are now gathered for the Judiciary Committee case. We will hear one case today.\nThe secretary will now read the case.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Secretary\nThank you Mr. John, The case being argued today is that of Mr. Louis Ventrion Donald the 3rd.\nHe is accused of bribing government officials.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Elton\nI now open the floor to committee members to ask 1 question before your vote.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Would you like to ask a question 1: Yes 2: no");
        int A = n.nextInt();
        if (A == 1){
            System.out.println("1: Why are you tempting new and upcoming politicians into your trickery? 2: Why shouldn't you be ruled guilty.");
            int B = n.nextInt();
            if (B == 1){
                System.out.println("\nLou\nI was not trying to bribe or influence them. I was trying to help them with their voting.");
            } else {
                System.out.println("\nLou\nBecause I've done nothing wrong in offering help to others.");
            }
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Elton\nTime to vote.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Guilty 2: Not Guilty");
        int C = n.nextInt();
        if (C == 1){
            if (mainSystem.Stats.contacts.contains("Lou")){
                mainSystem.Stats.contacts.remove("Lou");
            }
            System.out.println("Elton\nThe Judiciary Committee finds the defendant guilty as charged. It's up to the Department of Justice now.");
        } else if (C == 2){
            if (mainSystem.Stats.contacts.contains("Lou")){
                mainSystem.Stats.SPC += 5;
            } else {
                mainSystem.addToContacts("Lou");
            }
            System.out.println("Elton\nThe Judiciary Committee finds the defendant not guilty.");
        }
    }
}