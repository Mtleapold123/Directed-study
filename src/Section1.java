import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Section1 {

    public static void section1() throws InterruptedException {
        section1Part1();
        int billPoints = section1Part2();
        section1Part3(billPoints);
        mainSystem.Stats.karma += 10;
        mainSystem.Stats.SPC += 10;
        mainSystem.Stats.OPC += 10;
        mainSystem.Stats.wisdom += 10;
        System.out.println("\n\n\nSection 1 Complete");
        TimeUnit.SECONDS.sleep(4);
    }

    public static void section1Part1() throws InterruptedException {
        Scanner n = new Scanner(System.in);
        System.out.println("You sit at your desk and pull out your laptop.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Unknown Voice\nGood Morning Mr. " + intro.callFromIntro.lastName);
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: Good Morning 2: Good Morning? 3: Who are you?");
        int A = n.nextInt();
        if (A == 2) {
            System.out.println("Unknown Voice\nWhy the hesitation");
            System.out.println("1: I don't know who you are 2: Oh, Nothing, what's going on?");
            int B = n.nextInt();
            if (B == 1) {
                A = 3;
            } else {
                mainSystem.Stats.wisdom = mainSystem.Stats.wisdom - 10;
                A = 3;
            }
        } else if (A == 1) {
            mainSystem.Stats.wisdom = mainSystem.Stats.wisdom - 1;
            A = 3;
        }
        while (A == 3) {
            System.out.println("Lou\nWhy, I am sorry I forgot to introduce myself, I am Louis Ventrion Donald the 3rd,\nbut when we aren't in chambers, you can call me Lou.\n");
            TimeUnit.SECONDS.sleep(4);
            break;
        }
        System.out.println("Lou\nI wanted to ask to... well... open communication between us.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: No, I would never open Communications with you 2: Yah sure 3: Depends, what would that mean?");
        int C = n.nextInt();
        if (C == 1) {
            System.out.println("Lou\nYou have it your way then kid, have it your way.\nHe leaves your office furious.");
            mainSystem.Stats.wisdom = mainSystem.Stats.wisdom - 5;
            mainSystem.Stats.karma = mainSystem.Stats.karma + 5;
            mainSystem.Stats.SPC = mainSystem.Stats.SPC - 20; //Don't just blow him off.
        }
        if (C == 3) {
            System.out.println("Lou\nWell, all it would mean is you vote for my bills, and I vote for yours. That Simple");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: I'm fine opening communications 2: Get out of my office");
            int D = n.nextInt();
            if (D == 1) {
                C = 2;
                mainSystem.Stats.wisdom = mainSystem.Stats.wisdom + 15;
                mainSystem.Stats.karma = mainSystem.Stats.karma - 10;
            } else {
                System.out.println("he leaves your office furious.");
                mainSystem.Stats.wisdom = mainSystem.Stats.wisdom - 10;
                mainSystem.Stats.karma = mainSystem.Stats.karma + 5;
                mainSystem.Stats.SPC = mainSystem.Stats.SPC - 10;
            }
        }
        while (C == 2) {
            System.out.println("Lou\n Well Perfect, my secretary will call you as soon as she can.");
            System.out.println("He leaves your office satisfyed.");
            mainSystem.Stats.wisdom = mainSystem.Stats.wisdom + 20;
            mainSystem.Stats.karma = mainSystem.Stats.karma - 5;
            mainSystem.Stats.SPC = mainSystem.Stats.SPC + 10;
            mainSystem.addToContacts("Lou");
            break;
        }
    }

    public static int section1Part2() throws InterruptedException {
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Kieren\nWho was that you were talking to?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: Tell the truth 2:Lie");
        int A = n.nextInt();
        if (A == 1) {
            System.out.println("He was some party member who wanted me to team up with him.");
            mainSystem.Stats.karma = mainSystem.Stats.karma + 5;
            mainSystem.Stats.wisdom = mainSystem.Stats.wisdom + 5;
        } else {
            Random r = new Random();
            int B = r.nextInt(10);
            System.out.println("Just some guy don't worry about it. What've you come to talk to me about.");
            if (B <= mainSystem.Stats.karma) {
                System.out.println("Kieren\nYou're lying.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: tell the truth 2: double down");
                int C = n.nextInt();
                if (C == 2) {
                    System.out.println("I'm going to have to send you to the ethics committee.");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("The ethics committee rules that you will be stripped of your political advisor.\nWith no one to advise you, you serve your term and fail to accomplish anything.\nYou go back to your day job. You loose.");
                    mainSystem.Stats.x = 0;
                } else {
                    System.out.println("Kieren\nNever Lie to me again.");
                }
            }
        }
        System.out.println("Kieren\nParty meetings are starting soon. There will be some of the most important people\nin the party there. you want them to like you.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nKieren\nFollow me, we are heading to the Senators house.");
        party();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Kieren\nWell, There weren't any lobyists like we were hoping for. You still want to risk\nproposing a bill tonight?");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: Let's go for it. 2: I don't want to risk it.");
        int billPoints;
        int D = n.nextInt();
        if (D == 1) {
            System.out.println("Kieren\nRisky, I like it.");
            TimeUnit.SECONDS.sleep(4);
            billPoints = billWriting1();
        } else {
            System.out.println("Kieren\nSafe choice.");
            billPoints = -1;
        }
        return billPoints;
    }

    private static int billWriting1() throws InterruptedException {
        String bill = "";
        int billPoints = 0;
        Scanner n = new Scanner(System.in);
        System.out.println("Kieren\nSo how bill writing works is you pick a topic and than select the correct words to \npass your bill.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: Gun Control 2: Abortion 3: Taxes");
        int A = n.nextInt();
        if (A == 1) {
            System.out.println("1: I 2: We 3: This");
            int B = n.nextInt();
            if (B == 1) {
                bill = bill + "i";
            } else if (B == 2) {
                bill = bill + "we";
            } else {
                bill = bill + "this";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: As 2: Believe 3: Bill");
            int C = n.nextInt();
            if (C == 1) {
                bill = bill + " as";
            } else if (C == 2) {
                bill = bill + " believe";
            } else {
                bill = bill + " bill";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Shall 2: This 3: Congress");
            int D = n.nextInt();
            if (D == 1) {
                bill = bill + " shall";
            } else if (D == 2) {
                bill = bill + " this";
            } else {
                bill = bill + " congress";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Congress 2: Ban 3: Must");
            int E = n.nextInt();
            if (E == 1) {
                bill = bill + " congress";
            } else if (E == 2) {
                bill = bill + " ban";
            } else if (E == 3) {
                bill = bill + " must";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: (must) protect guns 2: (must) ban guns 3: guns");
            int F = n.nextInt();
            if (F == 1) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " protect guns";
            } else if (F == 2) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " ban guns";
            } else {
                bill = bill + " guns";
            }
            switch (bill) {
                case "this bill shall ban guns":
                    billPoints = 1;
                case "we as this congress must ban guns":
                    billPoints = 1;
                case "we as this congress must protect guns":
                    billPoints = 1;
                case "we as congress must ban guns":
                    billPoints = 1;
                case "we as congress must protect guns":
                    billPoints = 1;
                case "we believe this congress must ban guns":
                    billPoints = 1;
                case "we believe this congress must protect guns":
                    billPoints = 1;
                case "we believe congress must ban guns":
                    billPoints = 1;
                case "we believe congress must protect guns":
                    billPoints = 1;
                case "i believe this congress must ban guns":
                    billPoints = 1;
                case "i believe this congress must protect guns":
                    billPoints = 1;
                case "i believe this ban must ban guns":
                    billPoints = 1;
                case "i believe this must protect guns":
                    billPoints = 1;
                case "i believe this must ban guns":
                    billPoints = 1;
                case "i believe congress must ban guns":
                    billPoints = 1;
                case "i believe congress must protect guns":
                    billPoints = 1;
                default:
                    billPoints = 0;
            }
            if (bill.contains("ban") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            } else if (bill.contains("ban") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("protect") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("protect") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            }
            mainSystem.Stats.currentBill = bill;
            return billPoints;
        } else if (A == 2) {
            System.out.println("1: I 2: We 3: This");
            int B = n.nextInt();
            if (B == 1) {
                bill = bill + "i";
            } else if (B == 2) {
                bill = bill + "we";
            } else {
                bill = bill + "this";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: As 2: Believe 3: Bill");
            int C = n.nextInt();
            if (C == 1) {
                bill = bill + " as";
            } else if (C == 2) {
                bill = bill + " believe";
            } else {
                bill = bill + " bill";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Shall 2: This 3: Congress");
            int D = n.nextInt();
            if (D == 1) {
                bill = bill + " shall";
            } else if (D == 2) {
                bill = bill + " this";
            } else {
                bill = bill + " congress";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Congress 2: Ban 3: Must");
            int E = n.nextInt();
            if (E == 1) {
                bill = bill + " congress";
            } else if (E == 2) {
                bill = bill + " ban";
            } else if (E == 3) {
                bill = bill + " must";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: (must) protect a womans right to choose 2: (must) ban the sinful act of abortion 3: abortion");
            int F = n.nextInt();
            if (F == 1) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " protect a womans right to choose";
            } else if (F == 2) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " ban the sinful act of abortion";
            } else {
                bill = bill + " abortion";
            }
            switch (bill) {
                case "this bill shall ban abortion":
                    billPoints = 1;
                case "we as this congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "we as this congress must protect a womans right to choose":
                    billPoints = 1;
                case "we as congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "we as congress must protect a womans right to choose":
                    billPoints = 1;
                case "we believe this congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "we believe this congress must protect a womans right to choose":
                    billPoints = 1;
                case "we believe congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "we believe congress must protect a womans right to choose":
                    billPoints = 1;
                case "i believe this congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "i believe this congress must protect a womans right to choose":
                    billPoints = 1;
                case "i believe this ban must ban the sinful act of abortion":
                    billPoints = 1;
                case "i believe this must protect a womans right to choose":
                    billPoints = 1;
                case "i believe this must ban the sinful act of abortion":
                    billPoints = 1;
                case "i believe congress must ban the sinful act of abortion":
                    billPoints = 1;
                case "i believe congress must protect a womans right to choose":
                    billPoints = 1;
                default:
                    billPoints = 0;
            }
            if (bill.contains("protect") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            } else if (bill.contains("protect") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("ban") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("ban") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            }
            mainSystem.Stats.currentBill = bill;
            return billPoints;
        } else {
            System.out.println("1: I 2: We 3: This");
            int B = n.nextInt();
            if (B == 1) {
                bill = bill + "i";
            } else if (B == 2) {
                bill = bill + "we";
            } else {
                bill = bill + "this";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: As 2: Believe 3: Bill");
            int C = n.nextInt();
            if (C == 1) {
                bill = bill + " as";
            } else if (C == 2) {
                bill = bill + " believe";
            } else {
                bill = bill + " bill";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Shall 2: This 3: Congress");
            int D = n.nextInt();
            if (D == 1) {
                bill = bill + " shall";
            } else if (D == 2) {
                bill = bill + " this";
            } else {
                bill = bill + " congress";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Congress 2: raise 3: Must");
            int E = n.nextInt();
            if (E == 1) {
                bill = bill + " congress";
            } else if (E == 2) {
                bill = bill + " raise";
            } else if (E == 3) {
                bill = bill + " must";
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: (must) lower taxes 2: (must) raise taxes 3: taxes");
            int F = n.nextInt();
            if (F == 1) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " lower taxes";
            } else if (F == 2) {
                if (E != 3) {
                    bill = bill + " must";
                }
                bill = bill + " raise taxes";
            } else {
                bill = bill + " taxes";
            }
            switch (bill) {
                case "this bill shall raise taxes":
                    billPoints = 1;
                case "we as this congress must raise taxes":
                    billPoints = 1;
                case "we as this congress must lower taxes":
                    billPoints = 1;
                case "we as congress must raise taxes":
                    billPoints = 1;
                case "we as congress must lower taxes":
                    billPoints = 1;
                case "we believe this congress must raise taxes":
                    billPoints = 1;
                case "we believe this congress must lower taxes":
                    billPoints = 1;
                case "we believe congress must raise taxes":
                    billPoints = 1;
                case "we believe congress must lower taxes":
                    billPoints = 1;
                case "i believe this congress must raise taxes":
                    billPoints = 1;
                case "i believe this congress must lower taxes":
                    billPoints = 1;
                case "i believe this ban must raise taxes":
                    billPoints = 1;
                case "i believe this must lower taxes":
                    billPoints = 1;
                case "i believe this must raise taxes":
                    billPoints = 1;
                case "i believe congress must raise taxes":
                    billPoints = 1;
                case "i believe congress must lower taxes":
                    billPoints = 1;
                default:
                    billPoints = 0;
            }
            if (bill.contains("raise") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            } else if (bill.contains("raise") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("lower") && intro.callFromIntro.party == "Democrat") {
                mainSystem.Stats.wisdom -= 10;
                mainSystem.Stats.SPC -= 10;
                mainSystem.Stats.OPC += 10;
            } else if (bill.contains("lower") && intro.callFromIntro.party == "Republican") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 10;
            } else if (bill.contains("lower") && intro.callFromIntro.party == "Independent") {
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.OPC += 5;
            } else if (bill.contains("raise") && intro.callFromIntro.party == "Independent") {
                mainSystem.Stats.wisdom += 5;
                mainSystem.Stats.OPC += 10;
            }
            if (A == 2) {
                billPoints += 5;
            } else if (A == 3) {
                billPoints += 10;
            }
            mainSystem.Stats.currentBill = bill;
            return billPoints;
        }
    }

    public static void party() throws InterruptedException {
        String speaker = "";
        String speakerFullName = "";
        if (mainSystem.Stats.party == "Democrat") {
            speaker = "Nancy";
            speakerFullName = "Nancy Pelosi";
        } else {
            speaker = "Paul";
            speakerFullName = "Paul Ryan";
        }
        int peopleMet = 0;
        while (true) {
            Scanner n = new Scanner(System.in);
            boolean popular = false;
            if (mainSystem.Stats.contacts.contains("Lou")) {
                popular = true;
            }

            if (popular == true) {
                System.out.println("Lou\nHello, why how are you doing?");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: fine, and yourself 2: say nothing");
                int A = n.nextInt();
                if (A == 2) {
                    System.out.println("o...k..?");
                    TimeUnit.SECONDS.sleep(4);
                } else {
                    System.out.println("Lou\nI'm as fine as a hair on a frogs behind split 4 ways, now that's mighty fine.");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("Well then, Enjoy the party, meet some people, and have a little fun.");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("He walks away.");
                    TimeUnit.SECONDS.sleep(4);
                    peopleMet += 1;
                }
            } else {
                System.out.println("Lou Stares at you from across the room.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("after two full seconds he breaks eye contact and walks away");
            }
            System.out.println("Unkown voice\nWell you look new to all of this.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: excuse me? 2: Who are you? 3: leave");
            int B = n.nextInt();
            if (B == 3) {
                System.out.println("You leave the party");
                break;
            } else if (B == 2) {
                mainSystem.Stats.SPC = mainSystem.Stats.SPC - 5;
            }
            System.out.println(speaker + "\nI'm " + speakerFullName + ", Speaker of the house.");
            TimeUnit.SECONDS.sleep(4);
            if (mainSystem.Stats.party == "Democrat") {
                System.out.println("1: What an honor Madame Speaker 2: and..?");
            } else {
                System.out.println("1: what an honor Mr. Speaker 2: and..?");
            }
            int C = n.nextInt();
            if (C == 2) {
                System.out.println(speaker + "\nWell I know who won't be getting re-elected");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("Without the support of your party, you're boycotted and won't be re-elected.");
                TimeUnit.SECONDS.sleep(4);
                mainSystem.Stats.x = 0;
            } else {
                System.out.println(speaker + "\nThe honors all mine. I see You've met Lou");
                TimeUnit.SECONDS.sleep(4);
            }
            System.out.println("1: Yah, the guy is a jerk 2: He is a nice man");
            int D = n.nextInt();
            System.out.println(speaker + "\nAgreed on that.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("So what got you into politics");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: I've always loved to argue 2: I want to change the world");
            int E = n.nextInt();
            if (E == 1) {
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.wisdom += 5;
                mainSystem.Stats.karma -= 10;
            } else {
                mainSystem.Stats.SPC += 5;
                mainSystem.Stats.wisdom -= 5;
                mainSystem.Stats.karma += 10;
            }
            System.out.println(speaker + "\nThat's awesome.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Why Don't you stop by my office some time, and we can talk about getting you on the floor.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: I will 2: nah");
            int F = n.nextInt();
            if (F == 2) {
                System.out.println(speaker + "\nWell I know who won't be getting re-elected");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("Without the support of your party, you're boycotted and won't be re-elected.");
                TimeUnit.SECONDS.sleep(4);
                mainSystem.Stats.x = 0;
            } else {
                System.out.println(speaker + "\n see you soon.");
                peopleMet += 1;
                mainSystem.addToContacts("Speaker Of The House");
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.wisdom += 10;
            }
            TimeUnit.SECONDS.sleep(4);
            System.out.println("You see your hero, Senator Alderman in the corner talking to someone.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("1: Go talk to him 2: Leave in embarrassment.");
            int G = n.nextInt();
            if (G == 2) {
                System.out.println("You leave");
                break;
            } else {
                System.out.println("You walk over to him.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("Alderman\nWhy you're a new face. Whats your name.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("I'm " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + ", The new representative of the first district of Michigan");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("Alderman\n" + intro.callFromIntro.lastName + "as in richard " + intro.callFromIntro.lastName + ", the Senate Majority leader?");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: yes, he is my father. 2: no relation.");
                int H = n.nextInt();
                if (H == 1) {
                    System.out.println("Alderman\nWhy how amazing, how I wish I could have met your father. Damn shame.");
                    TimeUnit.SECONDS.sleep(4);
                    peopleMet += 1;
                } else {
                    System.out.println("Alderman\naw, what a shame. Well, nice meeting you Mr. " + intro.callFromIntro.lastName);
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("you too.");
                    break;
                }
                System.out.println("Aldernam\nWhy it is such an honor to meet you. You know what...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("He grabs a piece of paper.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Alderman\nStop by my office, your father would have wanted me to help you.");
                mainSystem.addToContacts("Alderman");
                mainSystem.Stats.wisdom += 5;
                mainSystem.Stats.SPC += 10;
                System.out.println("I will.");
                System.out.println("You leave the party and go home for the night.");
                break;
            }
        }
        mainSystem.Stats.karma = mainSystem.Stats.karma + peopleMet;
    }


    public static void section1Part3(int bill) throws InterruptedException {
        Random random = new Random();
        int billPoints = bill;
        String speakerGender;
        String speaker;
        String speakerFullName;
        Scanner n = new Scanner(System.in);
        if (intro.callFromIntro.party == "Democrat") {
            speakerGender = "Madame ";
            speaker = "Nancy";
            speakerFullName = "Nancy Pelosi";
        } else {
            speakerGender = "Mr. ";
            speaker = "Paul";
            speakerFullName = "Paul Ryan";
        }
        System.out.println(speaker + "\nI, " + speakerFullName + ", as Speaker of the House of representatives do call \nthe Congress of the United States of America into session.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println(speaker + "\nFirst on the Docket, Bill order #00069, Written by Senator Alderman who is in the house to present his bill today, ");
        if (intro.callFromIntro.party == "Democrat") {
            System.out.print("The Comfort Act. I know yield the floor to Senator Alderman.");
        } else {
            System.out.print("The Speech Act");
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Alderman\nThank you " + speakerGender + "Speaker.");
        if (mainSystem.Stats.contacts.contains("Alderman")) {
            if (intro.callFromIntro.party == "Democrat") {
                System.out.println("In summary, the intention of The Comfort Act is to require all colleges to create\n free speech zones for its students. It is necessary for this great governing body to protect the young people of this nation. Suicide rates are at an all time, now is the time to act.");
                TimeUnit.SECONDS.sleep(5);
                System.out.print("I now yield the floor to Congressman " + intro.callFromIntro.lastName);
            } else {
                System.out.println("In summary, the intention of The Speech Act is to grant every American the security of \n speech in college, without fear of expulsion. It is nessesary to protect the first amendment to the United States Constitution.");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("I now yield the floor to Congressman " + intro.callFromIntro.lastName);
            }
            System.out.println("1: Agree 2: Decline The Floor 3: Use The Floor to Disagree");
            int A = n.nextInt();
            if (A == 1) {
                if (intro.callFromIntro.party == "Democrat") {
                    if (mainSystem.Stats.wisdom >= 20 || mainSystem.Stats.OPC + mainSystem.Stats.SPC >= 30) {
                        System.out.println("I stand along side Senator Alderman. I have struggled with suicidal thoughts in\n the past. It is near the necessity of a state of emergency. We as the representative body of the people must make it our first goal to protect the people. The constitution says 'we the people', so we better protect the people.");
                        mainSystem.Stats.wisdom += 5;
                        mainSystem.Stats.SPC += 5;
                        mainSystem.Stats.OPC -= 5;
                    } else {
                        System.out.println("I stand with Alderman. It is important.");
                        mainSystem.Stats.SPC -= 5;
                    }
                } else {
                    if (mainSystem.Stats.wisdom >= 20 || mainSystem.Stats.OPC + mainSystem.Stats.SPC >= 30) {
                        System.out.println("I stand along side Senator Alderman, free speech is under attack. \n'I don't agree with what they say but i will fight to the death for their right to say it.'\n- -Voltaire");
                        mainSystem.Stats.wisdom += 5;
                        mainSystem.Stats.SPC += 5;
                        mainSystem.Stats.OPC -= 5;
                    } else {
                        System.out.println("I agree with Senator Alderman, we stand united.");
                        mainSystem.Stats.SPC -= 5;
                    }
                }
            } else if (A == 2) {
                System.out.println("I respectfully decline the floor and yield back to Senator Alderman.");
            } else if (A == 3) {
                if (intro.callFromIntro.party == "Democrat") {
                    System.out.println("I actually stand against Senator Alderman");
                    if (mainSystem.Stats.wisdom >= 20) {
                        System.out.println("I believe in a truly free democracy free speech belongs in all aspects of life.");
                        mainSystem.Stats.SPC -= 5;
                        mainSystem.Stats.OPC += 10;
                        mainSystem.Stats.contacts.remove("Alderman");
                    } else {
                        System.out.println("I disagree.");
                        mainSystem.Stats.SPC -= 5;
                        mainSystem.Stats.OPC -= 5;
                        mainSystem.Stats.contacts.remove("Alderman");
                    }
                } else {
                    System.out.println("I actually stand against Senator Alderman");
                    if (mainSystem.Stats.wisdom >= 20) {
                        System.out.println("Alderman has failed to take into account the real world consiquences of not \ngiving our youth a safe space.");
                        mainSystem.Stats.SPC -= 5;
                        mainSystem.Stats.OPC += 10;
                        mainSystem.Stats.contacts.remove("Alderman");
                    } else {
                        System.out.println("i don't like free speech.");
                        mainSystem.Stats.SPC -= 5;
                        mainSystem.Stats.OPC -= 5;
                        mainSystem.Stats.contacts.remove("Alderman");
                    }
                }
            }
            TimeUnit.SECONDS.sleep(5);
        } else {
            if (intro.callFromIntro.party == "Democrat") {
                System.out.println("In summary, the intention of The Comfort Act is to require all colleges to create\n free speech zones for its students. It is necessary for this great governing body to protect the young people of this nation. Suicide rates are at an all time, now is the time to act.");
                TimeUnit.SECONDS.sleep(5);
            } else {
                System.out.println("In summary, the intention of The Speech Act is to grant every American the security of \n speech in college, without fear of expulsion. It is nessesary to protect the first amendment to the United States Constitution.");
                TimeUnit.SECONDS.sleep(5);
            }
        }
        if (intro.callFromIntro.party == "Democrat") {
            System.out.println(speaker + "\nWe must now vote on Senator Alderman's bill, The Comfort Act");
        } else {
            System.out.println(speaker + "\nWe must now vote on Senator Alderman's bill, The Speech Act");
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Kieren (whispering)\nthis is a private vote, so don't worry about your apeal.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: YES 2: NO 3: Obstain");
        int B = n.nextInt();
        int C = random.nextInt(20);
        if (B == 1) {
            if (C >= mainSystem.Stats.SPC + mainSystem.Stats.karma) {
                System.out.println(speaker + "\nSenator Alderman's bill is passed and per the Senator's request,\nMr. " + intro.callFromIntro.lastName + " may cosign this bill.");
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC -= 5;
                mainSystem.Stats.wisdom += 5;
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: cosign 2: don't");
                int D = n.nextInt();
                if (D == 1) {
                    System.out.println("I will cosign");
                    mainSystem.Stats.wisdom += 5;
                    mainSystem.Stats.billsPassed += 1;
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(speaker + "\nSenator Alerman's bill, cosigned by Mr. " + intro.callFromIntro.lastName + ", will be sent to the senate for voting.");
                } else {
                    System.out.println("I must respectfully decline the offer.");
                    mainSystem.Stats.wisdom -= 5;
                    int E = random.nextInt(10);
                    if (E >= 5) {
                        mainSystem.Stats.contacts.remove("Alderman");
                    }
                }
            } else {
                System.out.println(speaker + "\nSenator Alderman's bill did not get enough votes to pass and we ask that\nSenator Alderman Yield the floor.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("Alderman\nI yield the floor to " + speakerFullName);
            }
        } else if (B == 2) {
            System.out.println(speaker + "\nSenator Alderman's bill has been denied.");
        } else {
            System.out.println(speaker + "\nSenator Alderman's bill has been passed.");
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(speaker + "Next on the docket, bill #38258, Mr. Louis Ventrion Donald the third's bill,\nThe International Trade Act");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Lou\nThank you " + speakerGender + " Speaker, I have written a new trade act that will change\n our trade policy. It will ignore all disagreements on politics and allow us to trade with anyone.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println(speaker + "\nNo deliberation, straight to voting.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Kieren\nThis vote is public.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: YES 2: NO 3: obstaining");
        int F = n.nextInt();
        if (F == 1) {
            System.out.println(speaker + "\nThe International Trade Act has passed.");
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
            mainSystem.Stats.OPC += 5;
        } else {
            System.out.println(speaker + "\nThe International Trade Act has been denied");
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
            mainSystem.Stats.OPC += 5;
            if (mainSystem.Stats.contacts.contains("Lou")) {
                mainSystem.Stats.contacts.remove("Lou");
            }
        }
        TimeUnit.SECONDS.sleep(4);
        if (billPoints >= 10) { //Tax bill
            System.out.println(speaker + "\nThird on the docket, Mr. " + intro.callFromIntro.lastName + "'s bill for tax\nreform, due to late entry today I will read you the context of the bill.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("\n\n" + mainSystem.Stats.currentBill);
            TimeUnit.SECONDS.sleep(4);
            if (billPoints == 10) {
                System.out.println("Due to how terrible this bill is written, I am going to deny its ability to enter the floor.");
                TimeUnit.SECONDS.sleep(4);
                mainSystem.Stats.x += 1;
            } else {
                System.out.println(speaker + "\nWould you like to speak about your bill?");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: Yes 2: My bill says enough");
                int G = n.nextInt();
                int H = random.nextInt(25);
                if (G == 1) {
                    if (mainSystem.Stats.wisdom >= H || ((mainSystem.Stats.SPC + mainSystem.Stats.OPC + mainSystem.Stats.karma) / 3) >= H) {
                        System.out.println("\nThis Tax Bill is of Upmost importance. It stands through prosperity and\nreflects the nessesary tax reform needed inside of this great country.");
                    } else {
                        System.out.println("\nVote for my bill because Taxes and because i told you to.");
                        mainSystem.Stats.SPC -= 10;
                        mainSystem.Stats.OPC -= 10;
                    }
                    mainSystem.Stats.karma += 10;
                    mainSystem.Stats.SPC += 5;
                    mainSystem.Stats.OPC += 5;
                    TimeUnit.SECONDS.sleep(4);
                }
                System.out.println(speaker + "\nTime to vote.");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: Yes 2: No 3: obstaining");
                int I = n.nextInt();
                if (I == 2) {
                    mainSystem.Stats.wisdom -= 20;
                    mainSystem.Stats.SPC -= 10;
                    System.out.println("Kieren\nReally, You didn't vote for your own bill? get out of here, you loose.");
                    mainSystem.Stats.x += 1;
                } else {
                    int J = random.nextInt(45);
                    if (mainSystem.Stats.karma + mainSystem.Stats.wisdom >= J || mainSystem.Stats.SPC + mainSystem.Stats.OPC >= J) {
                        System.out.println(speaker + "\nVotes are in, this bill has passed. meaning,\n Representative " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + " has passed there first bill.");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("*applause* *applause*");
                        System.out.print("\n");
                        mainSystem.Stats.wisdom += 10;
                        mainSystem.Stats.karma += 10;
                        mainSystem.Stats.SPC += 10;
                        mainSystem.Stats.OPC -= 5;
                    } else {
                        System.out.println(speaker + "\nVotes are in, this bill has been denied.");
                    }
                    mainSystem.Stats.wisdom += 5;
                    mainSystem.Stats.SPC += 5;
                }
            }
        } else if (billPoints >= 5) { //abortion bill
            System.out.println(speaker + "\nThird on the docket, Mr. " + intro.callFromIntro.lastName + "'s bill on abortion.\nDue to late entry I will now read the bill.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("\n\n" + mainSystem.Stats.currentBill);
            TimeUnit.SECONDS.sleep(5);
            if (billPoints == 5) {
                System.out.println("Due to how terrible this bill is written, I am going to deny its ability to enter the floor.");
                TimeUnit.SECONDS.sleep(4);
                mainSystem.Stats.x += 1;
            } else {
                System.out.println(speaker + "\nWould you like to speak about your bill?");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: Yes 2: My bill says enough");
                int G = n.nextInt();
                int H = random.nextInt(25);
                if (G == 1) {
                    if (mainSystem.Stats.wisdom >= H || ((mainSystem.Stats.SPC + mainSystem.Stats.OPC + mainSystem.Stats.karma) / 3) >= H) {
                        System.out.println("This Abortion bill is very important for our nation. ");
                        if (mainSystem.Stats.currentBill.contains("protect")) {
                            System.out.print("This is no longer about abortion, this is about insuring the rights of Women.\nHer body, her choice.");
                        } else {
                            System.out.println("It is crutial that we stop the murdering of children. It's that simple.");
                        }
                    } else {
                        System.out.println("vote for my bill.");
                        mainSystem.Stats.SPC -= 10;
                        mainSystem.Stats.OPC -= 10;
                    }
                    mainSystem.Stats.karma += 10;
                    mainSystem.Stats.SPC += 5;
                    mainSystem.Stats.OPC += 5;
                }
                TimeUnit.SECONDS.sleep(4);
                System.out.println(speaker + "\nTime to vote.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1: YES 2: NO 3: obstaining");
                int I = n.nextInt();
                if (I == 2){
                    mainSystem.Stats.wisdom -= 20;
                    mainSystem.Stats.SPC -= 10;
                    System.out.println("Kieren\nReally, You didn't vote for your own bill? get out of here, you loose.");
                    mainSystem.Stats.x += 1;
                } else{
                    int J = random.nextInt(45);
                    if (mainSystem.Stats.karma + mainSystem.Stats.wisdom >= J || mainSystem.Stats.SPC + mainSystem.Stats.OPC >= J) {
                        System.out.println(speaker + "\nVotes are in, this bill has passed. meaning,\n Representative " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + " has passed there first bill.");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("*applause* *applause*");
                        System.out.print("\n");
                        mainSystem.Stats.wisdom += 10;
                        mainSystem.Stats.karma += 10;
                        mainSystem.Stats.SPC += 10;
                        mainSystem.Stats.OPC -= 5;
                    } else {
                        System.out.println(speaker + "\nVotes are in, this bill has been denied.");
                    }
                    mainSystem.Stats.wisdom += 5;
                    mainSystem.Stats.SPC += 5;
                }
            }
        } else if (billPoints >= 0) { // gun bill
            TimeUnit.SECONDS.sleep(4);
            System.out.println(speaker + "\nThird on the docket, Mr. " + intro.callFromIntro.lastName + "'s bill on Gun Laws.\nDue to late entry I will now read the bill.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("\n\n" + mainSystem.Stats.currentBill);
            TimeUnit.SECONDS.sleep(5);
            if (billPoints == 5) {
                System.out.println("Due to how terrible this bill is written, I am going to deny its ability to enter the floor.");
                TimeUnit.SECONDS.sleep(4);
                mainSystem.Stats.x += 1;
            } else {
                System.out.println(speaker + "\nWould you like to speak about your bill?");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("1: Yes 2: My bill says enough");
                int G = n.nextInt();
                int H = random.nextInt(25);
                if (G == 1) {
                    if (mainSystem.Stats.wisdom >= H || ((mainSystem.Stats.SPC + mainSystem.Stats.OPC + mainSystem.Stats.karma) / 3) >= H) {
                        if (mainSystem.Stats.currentBill.contains("protect")) {
                            System.out.println("It is crutial that we protect the 2nd amendmant to the United States constitution.\nOur founding fathers wrote it into the constitution to prevent us from Tyranny.\nAnd when you are willing to trade liberty for security, what you end up with is tyranny.");
                            TimeUnit.SECONDS.sleep(5);
                        } else {
                            System.out.println("It is crutial that we protect the childrn of america and implement common sense gun control.");
                            TimeUnit.SECONDS.sleep(5);
                        }
                    } else {
                        if (mainSystem.Stats.currentBill.contains("protect")) {
                            System.out.println("I like the NRA so keep guns.");
                            mainSystem.Stats.SPC -= 10;
                            mainSystem.Stats.OPC -= 10;
                        } else {
                            System.out.println("Guns = scary.");
                            mainSystem.Stats.SPC -= 10;
                            mainSystem.Stats.OPC -= 10;
                        }
                        mainSystem.Stats.karma += 10;
                        mainSystem.Stats.SPC += 5;
                        mainSystem.Stats.OPC += 5;
                        TimeUnit.SECONDS.sleep(4);
                    }
                }
                System.out.println(speaker + "\nTime to vote.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1: YES 2: NO 3: obstain");
                int I = n.nextInt();
                if (I == 2) {
                    mainSystem.Stats.wisdom -= 20;
                    mainSystem.Stats.SPC -= 10;
                    System.out.println("Kieren\nReally, You didn't vote for your own bill? get out of here, you loose.");
                    mainSystem.Stats.x += 1;
                } else {
                    int J = random.nextInt(45);
                    if (mainSystem.Stats.karma + mainSystem.Stats.wisdom >= J || mainSystem.Stats.SPC + mainSystem.Stats.OPC >= J) {
                        System.out.println(speaker + "\nVotes are in, this bill has passed. meaning,\n Representative " + intro.callFromIntro.firstName + " " + intro.callFromIntro.lastName + " has passed there first bill.");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("*applause* *applause*");
                        System.out.print("\n");
                        mainSystem.Stats.wisdom += 10;
                        mainSystem.Stats.karma += 10;
                        mainSystem.Stats.SPC += 10;
                        mainSystem.Stats.OPC -= 5;
                    } else {
                        System.out.println(speaker + "\nVotes are in, this bill has been denied.");
                    }
                    mainSystem.Stats.wisdom += 5;
                    mainSystem.Stats.SPC += 5;
                }
            }
        } else {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Kieren\nAren't you glad you didn't introduce a bill.");
            mainSystem.Stats.wisdom += 10;
            mainSystem.Stats.karma += 5;
        }
        System.out.print(" Next on the docket, Senator Dreah's proposal for a bipartisan committee. I now yield\n to the Senator");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Senator Dreah\nThank You " + speakerGender + " speaker. This is simply a committee to\nPromote bipartisanship on bills.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println(speaker + "\nFinal vote of the evening.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("1: YES 2: NO 3: obstain");
        int I = n.nextInt();
        if (I == 1) {
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
            mainSystem.Stats.OPC += 5;
        } else if (I == 2) {
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.SPC += 5;
        }
        System.out.println(speaker + "\nAnd the votes are in, Senator Dreah's bill has passed. This body is dismissed and we will reconvene Tomorrow at 8 AM");
    }
}