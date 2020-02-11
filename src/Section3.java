import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Section3 {

    public static void section3() throws InterruptedException{
        if (mainSystem.Stats.billsPassed <= 0){
            System.out.println("You weren't interesting enough to get re-elected due to your lack of bill proposal.");
            TimeUnit.SECONDS.sleep(3);
            mainSystem.Stats.x += 1;
        }
        section3Part1();
        if (mainSystem.Stats.SPC >= 40){
            section3Part2();
        } else {
            System.out.println("Senator Alderman never actually said that. After disapointment from your supporters, you loose.");
        }
    }

    public static void section3Part1() throws InterruptedException{
        int speechPoints = 0;
        Scanner n = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Kieren\nYou have a speech to the press tomorrow morning, you have to talk about your bill \nbecause it goes to the Senate tomorrow afternoon.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("1: write speech now 2: wing it");
        int A = n.nextInt();
        if (A == 1){
            speechPoints = speechWriting();
        } else{
            mainSystem.Stats.wisdom -= 10;
        }
        speechGiving(speechPoints);
        int grade = pressQuestions(speechPoints);
        if (grade <= 75){
            System.out.println("Your speech failed so bad you don't get re-elected.");
            mainSystem.Stats.x += 1;
        }
        for (; grade > 0; grade = grade - 5){
            mainSystem.Stats.SPC += 1;
        }
    }

    public static int pressQuestions(int speechPoints) throws InterruptedException{
        Scanner n = new Scanner(System.in);
        String lastName = intro.callFromIntro.lastName;
        speechPoints += 100;
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i >= 3; i++){
            System.out.println("\n");
        }
        System.out.println("A Reporter\nMr. " + lastName + ", Why do you believe your bill is in the interest of the people.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: It helps the American people be safe from oppression. 2: It helps the American people and you'd know if you'd only read the damn bill. 3: It doesn't. It helps them indirectly through the process of legislature.");
        int A = n.nextInt();
        if (A == 1){
            mainSystem.Stats.wisdom += 10;
        } else if (A == 2){
            mainSystem.Stats.wisdom += 5;
            mainSystem.Stats.karma -= 5;
            speechPoints -= 2;
        } else{
            speechPoints -= 10;
        }
        TimeUnit.SECONDS.sleep(2);
        if (mainSystem.Stats.SPC <= 15 || mainSystem.Stats.OPC <= 15){
            if (mainSystem.Stats.OPC <= 15){
                System.out.println("A Reporter\nMr. " + lastName + ", members of the opposite party criticized you for your\nlack of experience. How do you respond.");
            } else if (mainSystem.Stats.SPC <= 15){
                System.out.println("A Reporter\nMr. " + lastName + ", members of your party have criticized you for your\nlack of experience. How do you respond.");
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Tell a Joke 2: Deny it 3: play dumb. 4: make a statement");
            int B = n.nextInt();
            if (B == 1){
                System.out.println("I don't need to comment because those men are so old they won't remember asking.");
                mainSystem.Stats.karma += 10;
                mainSystem.Stats.SPC += 5;
                mainSystem.Stats.OPC += 5;
                mainSystem.Stats.wisdom += 5;
            } else if (B == 2){
                System.out.println("I don't believe any of my colleagues would say that.");
                speechPoints -= 8;
            } else if (B == 3){
                System.out.println("I haven't heard those statements.");
                speechPoints -= 5;
            } else {
                System.out.println("The fact that I am young should cary more weight because I speak for the generation of which these bills will affect.");
                mainSystem.Stats.karma += 5;
                mainSystem.Stats.SPC += 10;
                mainSystem.Stats.OPC += 10;
                mainSystem.Stats.wisdom += 10;
            }
        } else {
            System.out.println("A Reporter\nHow do you respond to rumors about your father's honesty.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Protect your father 2: speak poorly of your father 3: re-direct.");
            int C = n.nextInt();
            if (C == 3){
                System.out.println("With all due respect sir, I am not my father and would like to focus on my bill.");
                mainSystem.Stats.wisdom += 10;
                mainSystem.Stats.karma += 5;
            } else if (C == 2){
                System.out.println("My father was a bad person. Enough said.");
                mainSystem.Stats.karma -= 10;
                mainSystem.Stats.wisdom -= 5;
                speechPoints -= 10;
            } else {
                System.out.println("My father was a great man and I will not have his name shit on in this press conference.");
                speechPoints -= 5;
            }
        }
        System.out.println("A Reporter\nYour father and Plato were good friends, do you plan to maintain that partnership\nor were your fathers morals wrong on that issue.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: yes (friends) 2: No (fathers morals were wrong 3: niether");
        int D = n.nextInt();
        if (D == 1){
            System.out.println("Plato is a great man and I do plan to work with him in the future.");
            if (mainSystem.Stats.contacts.contains("Plato")){
            } else {
                System.out.println("Plato said otherwise sir, he said 'I do not see partnership as hereditary.' Do you have a response.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\nNo I don't have a response.");
            }
        } else if (D == 2){
            System.out.println("Lobying is wrong, my father was a great man but not perfect and this was one of his faults.");
            speechPoints -= 5;
        } else {
            System.out.println("Again sir make this about the bill not my father.");
            speechPoints -= 10;
        }
        if (mainSystem.Stats.contacts.contains("Alderman")){
            System.out.println("A Reporter\nFinal Question, How would you respond to a committee nomination from Senator Alderman?");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Yes 2: no");
            int E = n.nextInt();
            if (E == 2){
                System.out.println("Insulted by your rejection, Alderman ends you career by funding the other side.");
                mainSystem.Stats.x += 1;
            } else {
                System.out.println("Of course I would answer yes.");
            }
        } else{
            speechPoints -= 15;
        }
        return speechPoints;
    }

    public static void section3Part2() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        System.out.println("Alderman\nMr. " + intro.callFromIntro.lastName + ", I wanted to know if I could speak to you in my office?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: sure 2: no thanks.");
        int A = n.nextInt();
        if (A == 2){
            System.out.println("\nKieren\nReally?...Really? I'm dropping you as an advisee.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\nWithout Kieren's support, you promptly loose your next election.");
            TimeUnit.SECONDS.sleep(2);
            mainSystem.Stats.x += 1;
        } else {
            System.out.println("Alderman\nNow, take a seat, I wanted to give you an opportunity. It's the least I could do for your father.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("How would you feel about taking a seat on a committee?");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1: Of course! 2: No thanks.");
            int B = n.nextInt();
            if (B == 2){
                System.out.println("\nKieren\nReally?...Really? I'm dropping you as an advisee.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\nWithout Kieren's support, you promptly loose your next election.");
                TimeUnit.SECONDS.sleep(2);
                mainSystem.Stats.x += 1;
            } else {
                System.out.println("Alderman\nWhy That's awesome. Which committee would you like to choose?");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("1: Ethics 2: Judiciary 3: Budget");
                int C = n.nextInt();
                if (C == 1){
                    mainSystem.Stats.committee = "Ethics";
                } else if (C == 2){
                    mainSystem.Stats.committee = "Judiciary";
                } else {
                    mainSystem.Stats.committee = "Budget";
                }
                System.out.println("Alderman\nAlrighty then, I'll get you on the " + mainSystem.Stats.committee + " committee. I know enough people. Thank me later.");
            }
        }
    }

    public static int speechWriting() throws InterruptedException{
        Scanner n = new Scanner(System.in);
        String speech = "";
        int speechPoints;
        for (int i = 0; i >= 50; i++){
            System.out.println("\n");
        }
        System.out.println("Write the first sentence of your speech about your new bill");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: I 2: We 3: The Senate");
        int A = n.nextInt();
        if (A == 1){
            speech += "I";
        } else if (A == 2){
            speech += "We";
        } else{
            speech += "The Senate";
        }
        System.out.println("Speech so far: " + speech);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: must 2: believe 3: should");
        int B = n.nextInt();
        if (B == 1){
            speech += " must";
        } else if (A == 2){
            speech += " believe";
        } else {
            speech += " should";
        }
        System.out.println("Speech so far: " + speech);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: pass 2: get 3: in");
        int C = n.nextInt();
        if (C == 1){
            speech  += " pass";
        } else if (C == 2){
            speech += " get";
        } else {
            speech += " in";
        }
        System.out.println("Speech so far: " + speech);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: this 2: my 3: it");
        int D = n.nextInt();
        if (D == 1){
            speech += " this";
        } else if (D == 2){
            speech += " my";
        } else {
            speech += " it";
        }
        System.out.println("Speech so far: " + speech);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1: bill 2: done 3: now");
        int E = n.nextInt();
        if (E == 1){
            speech += " bill.";
        } else if (E == 2){
            speech += " done.";
        } else {
            speech += " now.";
        }
        System.out.println("\n\nEvaluating speech.");
        TimeUnit.SECONDS.sleep(5);
        switch(speech){
            case "I must pass this bill.":
                speechPoints = 10;
            case "I must pass this now.":
                speechPoints = 7;
            case "I must pass my bill.":
                speechPoints = 8;
            case "I must pass it now.":
                speechPoints = 9;
            case "I must get this bill.":
                speechPoints = 4;
            case "I must get this done.":
                speechPoints = 9;
            case "I must get this now.":
                speechPoints = 6;
            case "I must get my bill.":
                speechPoints = 4;
            case "I must get it done.":
                speechPoints = 8;
            case "I must get it now.":
                speechPoints = 3;
            case "I believe in this bill.":
                speechPoints = 10;
            case "I believe in my bill.":
                speechPoints = 10;
            case "I believe in this now.":
                speechPoints = 5;
            case "I believe in it now.":
                speechPoints = 4;
            case "I should pass this bill.":
                speechPoints = 9;
            case "I should pass my bill.":
                speechPoints = 7;
            case "I should pass this now.":
                speechPoints = 8;
            case "I should pass it now.":
                speechPoints = 8;
            case "I should get this done.":
                speechPoints = 9;
            case "I should get it done.":
                speechPoints = 9;
            case "I should get it now.":
                speechPoints = 2;
            case "We must pass this bill.":
                speechPoints = 10;
            case "We must pass this now.":
                speechPoints = 10;
            case "We must pass my bill.":
                speechPoints = 9;
            case "We must pass it now.":
                speechPoints = 9;
            case "We must get this done.":
                speechPoints = 9;
            case "We must get it done.":
                speechPoints = 9;
            case "We must get it now.":
                speechPoints = 2;
            case "We believe in this bill.":
                speechPoints = 10;
            case "We believe in this now.":
                speechPoints = 6;
            case "We believe in my bill.":
                speechPoints = 9;
            case "We believe in it now.":
                speechPoints = 7;
            case "We should pass this bill.":
                speechPoints = 8;
            case "We should pass this now.":
                speechPoints = 9;
            case "We should pass my bill.":
                speechPoints = 9;
            case "We should pass it now.":
                speechPoints = 8;
            case "We should get this done.":
                speechPoints = 8;
            case "We should get this now.":
                speechPoints = 6;
            case "We should get it now.":
                speechPoints = 4;
            case "We should get it done.":
                speechPoints = 7;
            case "The Senate must pass this bill.":
                speechPoints = 10;
            case "The Senate must pass my bill.":
                speechPoints = 9;
            case "The Senate must pass this now.":
                speechPoints = 8;
            case "The Senate must pass it now.":
                speechPoints = 8;
            case "The Senate must get it done.":
                speechPoints = 10;
            case "The Senate must get it now.":
                speechPoints = 3;
            case "The Senate should pass this bill.":
                speechPoints = 8;
            case "The Senate should pass this now.":
                speechPoints = 8;
            case "The Senate should pass my bill.":
                speechPoints = 7;
            case "The Senate should pass it now.":
                speechPoints = 7;
            case "The Senate should get this bill.":
                speechPoints = 2;
            case "The Senate should get this done.":
                speechPoints = 8;
            case "The Senate should get it done.":
                speechPoints = 9;
            default:
                speechPoints = 1;
        }
        return speechPoints;
    }

    public static void speechGiving(int speechPoints) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i >= 10; i++){
            System.out.println("\n");
        }
        if (mainSystem.Stats.SPC + mainSystem.Stats.OPC >= 30 || mainSystem.Stats.karma >= 20 || speechPoints >= 9){
            System.out.println("Kieren\nYour Speech went amazing. Now time for the press.");
        } else{
            System.out.println("Kieren\nWell the people hate you now, you loose.");
            mainSystem.Stats.x += 1;
        }
    }
}