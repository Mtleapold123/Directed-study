import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Budget {
    public static void budget() throws InterruptedException{
        budgetPart1();
        budgetPart2();
    }

    public static void budgetPart1() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nNice job getting the committee job. You won't have it for long though because your dad's\nhelping you move up in the world.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("It's time for your first vote. You'll do great.");
    }

    public static void budgetPart2() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Elton\nHere ye, Here ye, I call together the Budget committee. We will read 2 requests for more money.\nThe Secretary will now read the case.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Secretary\nThank You Mr. John, The two budget proposals are a raise in pay for all Rep.'s case two is a raise in funding for Medicare.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("*People Talked about it but obviously no one changed minds*");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Elton\nTime to vote. Case 1, raise in pay for all rep.'s.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yay 2: Nay");
        int A = n.nextInt();
        if (A == 1){
            mainSystem.Stats.cash += 10000;
            mainSystem.Stats.karma -= 10;
        } else {
            mainSystem.Stats.karma += 15;
        }
        System.out.println("Elton\nTime to vote on case 2, raise medicare spending.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yay 2: nay");
        int B = n.nextInt();
        if (B == 1){
            if (mainSystem.Stats.party == "Democrat"){
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.karma += 5;
            } else {
                mainSystem.Stats.SPC -= 5;
                mainSystem.Stats.wisdom -= 5;
                mainSystem.Stats.karma -= 5;
            }
        } else{
            if (mainSystem.Stats.party == "Democrat"){
                mainSystem.Stats.SPC -= 5;
                mainSystem.Stats.wisdom -= 5;
            } else {
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.wisdom += 10;
            }
        }
        System.out.println("Elton\nThank you all, committee adjourned.");
    }
}
