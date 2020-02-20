import javax.swing.*;
import java.util.ArrayList;

public class mainSystem extends JFrame {

    public static class Stats {
        public static int x = 1;
        public static int n = 0;
        public static ArrayList<String> contacts = new ArrayList<>(n);
        public static volatile int karma = 0;
        public static volatile int getKarma = 0;
        public static volatile int SPC = 0;
        public static volatile int getSPC = 0;
        public static volatile int OPC = 0;
        public static volatile int getOPC = 0;
        public static volatile int wisdom = 0;
        public static volatile int getWisdom = 0;
        public static volatile int billsProposed = 0;
        public static volatile int getBillsProposed = 0;
        public static volatile int billsPassed = 0;
        public static volatile int getBillsPassed = 0;
        public static long cash = 174000;
        public static String party;
        public static String currentBill;
        public static String committee;
    }

    public static JFrame f;

    public mainSystem() {
        JTable statsWindow;
        f = new JFrame();
        String[] columns = new String[]{"Stat", "Value"};
        Object[][] data = new Object[][]{{"Karma", Stats.karma}, {"SPC", Stats.SPC}, {"OPC", Stats.OPC}, {"Wisdom", Stats.wisdom}, {"Bills Proposed", Stats.billsProposed}, {"Bills Passed", Stats.billsPassed}, {"Party", Stats.party}};
        statsWindow = new JTable(data, columns);
        f.add(new JScrollPane(statsWindow));
        f.setTitle("Stat Window");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void addToContacts(String name){
        Stats.n = Stats.n + 1;
        Stats.contacts.add(name);
    }

    public static void removeFromContacts(String name){
        if (Stats.contacts.contains(name)) {
            Stats.contacts.remove(name);
            Stats.n -= 1;
        }

    }

    public static void table() {
        SwingUtilities.invokeLater(mainSystem::new);
    }


    public static void main(String[] args) throws InterruptedException {
        Thread runSections = new Thread(() -> {
            while (Stats.x == 1){
                try {
                    intro.Introduction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Section1.section1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Section2.section2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Section3.section3();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (Stats.committee == "Ethics"){
                    try{
                        Ethics.ethics();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                } else if (Stats.committee == "Judiciary"){
                    try{
                        Judiciary.judiciary();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                } else {
                    try{
                        Budget.budget();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                try {
                    Section4.section4();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                try {
                    Section5.section5();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }
            if (Stats.x != 1){
                try {
                    End.loose();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            } else{
                try {
                    End.win();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread tableUpdater = new Thread(() -> {
            while (true) {
                synchronized (runSections) {
                    if (Stats.getKarma != Stats.karma) {
                        Stats.getKarma = Stats.karma;
                        if (f != null) {
                            f.dispose();
                        }
                        table();
                    } else if (Stats.getSPC != Stats.SPC){
                        if (f != null){
                            f.dispose();
                        }
                        Stats.getSPC = Stats.SPC;
                        table();
                    } else if (Stats.getOPC != Stats.OPC){
                        if (f != null){
                            f.dispose();
                        }
                        Stats.getOPC = Stats.OPC;
                        table();
                    } else if (Stats.getWisdom != Stats.wisdom){
                        if (f != null){
                            f.dispose();
                        }
                        Stats.getWisdom = Stats.wisdom;
                        table();
                    } else if (Stats.getBillsProposed != Stats.billsProposed){
                        if (f != null){
                            f.dispose();
                        }
                        Stats.getBillsProposed = Stats.billsProposed;
                        table();
                    } else if (Stats.getBillsPassed != Stats.billsPassed){
                        if (f != null){
                            f.dispose();
                        }
                        Stats.getBillsPassed = Stats.billsPassed;
                        table();
                    }
                }
            }
        });

        tableUpdater.start();
        runSections.start();
    }
}