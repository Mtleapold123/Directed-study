import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Section2 {
    public static int plato = 1;
    public static int beatles = 0;

    public static void section2() throws InterruptedException {
        int promise = section2Part1();
        section2Part2(promise);
        if (beatles == 1){
            System.out.println("Mr. Beatles\nHere is your cash, even though we lost, keep in touch.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Cash Added: $5,000");
            mainSystem.Stats.cash += 5000;
        }
        shopping();
    }

    public static void shopping(){
        Scanner n = new Scanner(System.in);
        System.out.println("You can now buy upgrades to some of your stats.");
        while (true){
            System.out.println("1: karma 2: SPC 3: OPC 4: Wisdom");
            int A = n.nextInt();
            System.out.println("You have $" + mainSystem.Stats.cash + " left. How much do you want to spend on this?");
            int B = n.nextInt();
            int C = 0;
            while (B > 200000 || B > mainSystem.Stats.cash){
                System.out.println("You cannot spend more than $200,000 on a Stat at a time nor can you spend more than you have.\n Try again.");
                B = n.nextInt();
            }
            if (B >= 150000){
                C = 20;
            } else if (B >= 100000){
                C = 15;
            } else if (B >= 10000){
                C = 10;
            } else if (B >= 1000){
                C = 5;
            } else if (B > 0){
                C = 1;
            }
            mainSystem.Stats.cash -= B;
            if (A == 1){
                mainSystem.Stats.karma += C;
            } else if (A == 2){
                mainSystem.Stats.SPC += C;
            } else if (A == 3){
                mainSystem.Stats.OPC += C;
            } else if (A == 4){
                mainSystem.Stats.wisdom += C;
            }
            System.out.println("Would you like to shop again?");
            System.out.println("1: yes 2: no");
            int D = n.nextInt();
            if (D == 1){
                break;
            }
        }
    }

    public static int section2Part1() throws InterruptedException {
        for (int i = 1; i < 50; i++) {
            System.out.println("\n");
        }
        System.out.println("The next day...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("You turn on the news before you go to work...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\nNews Reporter\nAnd news from the capital today, Representative Louis Ventrion Donald has passed away.");
        TimeUnit.SECONDS.sleep(1);
        mainSystem.removeFromContacts("Lou");
        System.out.println("Lou is removed from contacts.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You go to work as usual for now and head to the meeting networking session for your party.");
        TimeUnit.SECONDS.sleep(1);
        int promice = networking();
        TimeUnit.SECONDS.sleep(2);
        return promice;
    }

    public static void section2Part2(int promise) throws InterruptedException {
        Scanner n = new Scanner(System.in);
        String speaker;
        String speakerGender;
        String speakerFullName;
        if (intro.callFromIntro.party == "Democrat"){
            speaker = "Nancy";
            speakerGender = "Madame";
            speakerFullName = "Nancy Pelosi";
        } else{
            speaker = "Paul";
            speakerGender = "Mr. ";
            speakerFullName = "Paul Ryan";
        }
        System.out.println("Kieren\nLet's go to the congress voting sesion shall we?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(speaker + "\nHere ye, here ye, I hearby call the House of Representatives to order. First on the docket bill #31013, the Jerusalem Capital Act");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yes 2: No 3: Obstaining");
        int A = n.nextInt();
        if (A == 1){
            if (promise == 1){
                mainSystem.Stats.karma += 15;
            }
        } else {
            if (promise == 0){
                mainSystem.Stats.karma += 5;
            }
        }
        System.out.println(speaker + "\nVotes are in, The Jerusalem Capital Act passed and is heading to the Senate.\nNext on the docket, bill #8675309. The Abolishment of Net Neutrality.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("1: Yes 2: No 3: Obstaining");
        int B = n.nextInt();
        if (B == 2 || B == 3){
            if (plato == 1){
                plato = 0;
            }
        } else {
            System.out.println("Contact added: Plato");
            mainSystem.addToContacts("Plato");
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(speaker + "\nThe Abolishment of Net Neutrality died in congress. Next on the docket, bill #727398, ");
        if (intro.callFromIntro.party == "Democrat"){
            System.out.print("The Child Protection Act which bans all semi-automatic weapons.");
        } else {
            System.out.print("The 2A Protection Act\nwhich insures the legal sale of semi-automatic weapons in the United States.");
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: Yes 2: No 3: Obstaining");
        int C = n.nextInt();
        if (C == 1){
            System.out.println("Contact added: Mr. Beatles");
            mainSystem.addToContacts("Mr. Beatles");
            TimeUnit.SECONDS.sleep(2);
            beatles = 1;
        }
        System.out.println(speaker + "\nThis bill has been denied. Congress is adjourned.");
        TimeUnit.SECONDS.sleep(2);
    }

    public static int networking() throws InterruptedException {
        int promise;
        while (true) {
            Scanner n = new Scanner(System.in);
            String speaker;
            String speakerGender;
            String speakerFullName;
            if (mainSystem.Stats.party == "Democrat") {
                speaker = "Nancy";
                speakerGender = "Madame";
                speakerFullName = "Nancy Pelosi";
            } else {
                speaker = "Paul";
                speakerGender = "Mr.";
                speakerFullName = "Paul Ryan";
            }
            System.out.println("Kieren\n Good morning " + intro.callFromIntro.firstName + ", all you're doing today is going around,\nand making these lobyists like you ok, go.");
            TimeUnit.SECONDS.sleep(2);
            if (mainSystem.Stats.billsPassed >= 1) {
                System.out.println(speaker + "\nLook who it is, Mr. " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + ", Congratulations on your bill.");
                if (mainSystem.Stats.contacts.contains("Speaker Of The House")) {
                    System.out.println("Thanks to you, thanks for getting it on the floor.\n");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(speaker + "\nDon't worry about it, if you keep writting bills like that, you might be speaker some day.");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("1: I'm going bigger than that " + speakerGender + " " + speakerFullName + " 2: Thank you sir.");
                    int A = n.nextInt();
                    if (A == 1) {
                        System.out.println("\n" + speaker + "\nYou got big dreams kid, don't loose that.");
                        mainSystem.Stats.karma -= 5;
                        mainSystem.Stats.wisdom += 5;
                        mainSystem.Stats.SPC += 10;
                    } else {
                        mainSystem.Stats.karma += 5;
                        mainSystem.Stats.SPC += 10;
                    }
                    System.out.println("\n" + speaker + "\nWell I've got to go talk to some other people. See you around " + intro.callFromIntro.firstName);
                    TimeUnit.SECONDS.sleep(2);
                } else {
                    System.out.println("Thanks.");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\n" + speaker + "\nI'm busy tonight but I just wanted to come over and congratulate you.");
                    mainSystem.Stats.SPC += 5;
                }
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println("Unkown\nYou're an unfamiliar face, what's your name?");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("I'm " + intro.callFromIntro.firstName + intro.callFromIntro.lastName + ". How about you?");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Mr. Beatles\nMy name is unimportant, everyone calls me Mr. Beatles. Have you heard of my cause?");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("No, I have not. What is it?");
            TimeUnit.SECONDS.sleep(2);
            if (intro.callFromIntro.party == "Democrat") {
                System.out.println("Mr. Beatles\nI represent an Anti-Gun lobying group, we orginized the March for Our Lives a couple years back.");
            } else {
                System.out.println("Mr. Beatles\nI represent a Pro-Gun lobying group, we orginized the MLK day gun protest in virginia a couple months back.");
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1: That's awesome 2: ok... and");
            int B = n.nextInt();
            System.out.println("Mr. Beatles\n");
            if (B == 1) {
                System.out.print("Well... ");
            }
            System.out.print("I would like to ask you to vote yes on my bill. There is financial compensation in it for you. $5,000.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: I'm in, when do I get the money? 2: Is that legal?");
            int C = n.nextInt();
            if (C == 2) {
                System.out.println("Mr. Beatles\nIt's legal up to the number I quoted.");
                mainSystem.Stats.wisdom += 10;
                TimeUnit.SECONDS.sleep(1);
            } else {
                System.out.println("Mr. Beatles\n");
            }
            System.out.print(" You'll get the money once the votes are done. I trust I will have your vote.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\nHe walks away\n");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Rabbi Moshkiwitz\nShalom and good shabas to you young one.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Good shabas 2: what?");
            int D = n.nextInt();
            if (D == 2) {
                System.out.println("Rabbi Moshkiwitz\nHaHa You're a funny one.");
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Rabbi Moshkiwitz\nDo I have your vote for the Jerusalem Capital Act?");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Of course, I'd always support Israel's wishes 2: I don't believe that's the job of the United States. 3: what's in it for me");
            int E = n.nextInt();
            if (E == 1) {
                System.out.println("Rabbi Moshkiwits\nThank you Mr. " + intro.callFromIntro.lastName);
                promise = 1;
            } else if (E == 2) {
                System.out.println("Rabbi Moshkiwits\nStill, thank you for your time Mr. " + intro.callFromIntro.lastName);
                promise = 0;
            } else {
                System.out.println("Rabbi Moshkiwits\nWill you do it for free? or just because you support our cause? We are low on funds.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("1: Of course, I just thought I'd get some money if you were offering 2: sorry buddy, no.");
                int F = n.nextInt();
                if (F == 1) {
                    System.out.println("Rabbi Moshkiwitz\nThank You Mr. " + intro.callFromIntro.lastName);
                    promise = 1;
                } else {
                    System.out.println("Rabbi Moshkiwits\nStill, thank you for your time Mr. " + intro.callFromIntro.lastName);
                    promise = 0;
                }
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\nhe walks away\n");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Kieren\nYou see that popular man over there?");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Go over and talk to him 2: leave");
            int G = n.nextInt();
            if (G == 2){
                plato = 0;
                break;
            } else {
                System.out.println("Plato\nGood day sir, haven't met you before. Who are you?");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("I am " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + ", I represent Michigan's 12th district.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Plato\nAhh, you're " + intro.callFromIntro.lastName + "'s boy. Aaron, get the boy whatever he wants.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1: I'm good thank you 2: Coffee please");
                n.nextInt();
                System.out.println("Plato\nSo took over your fathers place in the house huh, your father would have been so proud.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("1: You knew my father? 2: Are you a lobyist?");
                int H = n.nextInt();
                if (H == 1) {
                    System.out.println("Plato\nYour father was one of my best friends. God I miss him. He was a good man. Anyway, buisness wise, want to throw me a vote?");
                } else {
                    System.out.println("Plato\nWhy yes I am. Vote no to bill #8675309");
                }
                TimeUnit.SECONDS.sleep(2);
                System.out.println("1: Depends on what this bill is. 2: For my father sure 3: no");
                int I = n.nextInt();
                if (I == 3){
                    System.out.println("Plato\nWhy no.");
                    System.out.println("1: I was just kidding 2: because no");
                    int J = n.nextInt();
                    if (J == 2){
                        System.out.println("Plato\nYou don't know what you just did.");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("Plato ruins your politcial carear");
                        mainSystem.Stats.x += 1;
                    } else {
                        System.out.println("Plato\nSure, get out of here. I'm finished. You're are far dumber than your father.");
                        mainSystem.Stats.wisdom = 0;
                        break;
                    }
                } else if (I == 2){
                    System.out.println("Plato\nVote no to the abolishment of net neutrality. I'll make it worth your while.");
                } else{
                    System.out.println("Plato\nI'm here lobying against the abolishment of net neutrality. Vote how you please,\n but vote no and you could havee a great future.");
                    mainSystem.Stats.wisdom += 10;
                }
                System.out.println("\nYou walk away\n");
                TimeUnit.SECONDS.sleep(2);
            }
            break;
        }
        return promise;
    }
}