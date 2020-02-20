import java.util.concurrent.TimeUnit;

public class End {
    public static void loose() throws InterruptedException{
        System.out.println("You lost the game, for whatever reason time to tally up.");
        pointCalculation();
        System.exit(0);
    }

    public static void win() throws InterruptedException{
        System.out.println("You Won!!!! tally up the points.");
        pointCalculation();
        System.exit(0);
    }

    public static int pointCalculation() throws InterruptedException{
        int points = 0;
        System.out.println("Look at your stats and compare to points to see explanation.");
        int contactPoints = mainSystem.Stats.n * 10;
        points += contactPoints;
        System.out.println("you had " + mainSystem.Stats.n + " contacts. " + contactPoints + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.karma;
        System.out.println("you had " + mainSystem.Stats.karma + " karma. " + mainSystem.Stats.karma + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.SPC;
        System.out.println("you had " + mainSystem.Stats.SPC + " same party charisma points. " + mainSystem.Stats.SPC + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.OPC;
        System.out.println("you had " + mainSystem.Stats.OPC + " opposite party charisma points. " + mainSystem.Stats.OPC + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.wisdom;
        System.out.println("you had " + mainSystem.Stats.wisdom + " wisdom. " + mainSystem.Stats.wisdom + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.billsProposed;
        System.out.println("you had " + mainSystem.Stats.billsProposed + "bills proposed. " + mainSystem.Stats.billsProposed + " Points!");
        TimeUnit.SECONDS.sleep(1);
        points += mainSystem.Stats.billsPassed;
        System.out.println("you had " + mainSystem.Stats.billsPassed + "bills passed. " + mainSystem.Stats.billsPassed + " Points!");
        TimeUnit.SECONDS.sleep(1);
        if (mainSystem.Stats.x == 1){
            System.out.println("You Won!! So you get an extra 500 points");
            points += 500;
        }
        TimeUnit.SECONDS.sleep(1);
        if (mainSystem.Stats.x == 1){
            System.out.println("You Won with a grand total of ");
        } else {
            System.out.println("You lost (loser) with a total of ");
        }
        System.out.print(points);
        return points;
    }
}