import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Section4 {
    public static void section4() throws InterruptedException{
        section4Part1();
        section4Part2();
    }

    public static void section4Part1() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i<=100; i++){
            System.out.println("\n");
        }
        System.out.println("6 years later");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nThe current nominee for the " + intro.callFromIntro.party + "s wants you to campaign for him.\nYou interested?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yes 2: No");
        int A = n.nextInt();
        if (A == 2){
            System.out.println("Your failure to take chances lead you to miss opportunities. You Loose.");
            TimeUnit.SECONDS.sleep(2);
            mainSystem.Stats.x += 1;
        } else {
            System.out.println("Sounds good. I'll let him know.");
        }
    }

    public static void section4Part2() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Trump\nGood morning " + intro.callFromIntro.firstName);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Good Morning! 2: Who are you?");
        int A = n.nextInt();
        if (A == 2){
            System.out.println("Trump\nYou don't know who I am? You're fired.");
            TimeUnit.SECONDS.sleep(2);
            mainSystem.Stats.x += 1;
        }
        System.out.println("So you're gonna help me win huh? Perfect. Amazing. Greatest Country Ever.");
        TimeUnit.SECONDS.sleep(2);
        int donation = cashDonation();
        System.out.println("Trump\nAwesome, terrific. Amazing.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Checking to see if Stats are good enough to help trump.");
        TimeUnit.SECONDS.sleep(2);
        if (mainSystem.Stats.wisdom >= 50 && mainSystem.Stats.SPC >= 50 && mainSystem.Stats.OPC >= 50 && mainSystem.Stats.karma >= 50 && mainSystem.Stats.billsPassed >= 1){
            System.out.println("You help Trump get elected, Hurray.");
        } else {
            System.out.println("Your Stats weren't good enough. I'm Sorry.");
            TimeUnit.SECONDS.sleep(2);
            mainSystem.Stats.x += 1;
        }
        System.out.println("You are officially secretary of state (That's boring we are jumping to 8 years later to have you run.");
    }

    public static int cashDonation(){
        Scanner n = new Scanner(System.in);
        System.out.println("You have $" + mainSystem.Stats.cash + ", how much would you like to donate to Trump?");
        int ammount = n.nextInt();
        while (ammount > mainSystem.Stats.cash){
            System.out.println("You only have $" + mainSystem.Stats.cash+ ". Try Again.");
            ammount = n.nextInt();
        }
        if ((mainSystem.Stats.cash - ammount) >= 100){
            System.out.println("Trump\nNot enough, you're fired.");
        }
        mainSystem.Stats.cash -= ammount;
        return ammount;
    }
}