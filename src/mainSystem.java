import javax.swing.*;
import java.util.ArrayList;

public class mainSystem extends JFrame {

    public static class Stats {
        public static int a = 0;
        public static int x = 1;
        public static int n = 0;
        public static ArrayList<String> contacts = new ArrayList<>(n);
        public static int karma = 0;
        public static int getKarma = 0;
        public static int SPC = 0;
        public static int getSPC = 0;
        public static int OPC = 0;
        public static int getOPC = 0;
        public static int wisdom = 0;
        public static int getWisdom = 0;
        public static int billsProposed = 0;
        public static int getBillsProposed = 0;
        public static int billsPassed = 0;
        public static int getBillsPassed = 0;
        public static String party;
        public static String currentBill;
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

    public static void table() {
        if (Stats.a != 0){
            f.dispose();
        }
        Stats.a += 1;
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
                break;
            }
            if (Stats.x != 1){
                End.loose();
            } else{
                End.win();
            }
        });

        Thread tableUpdater = new Thread(() -> {
            while (true) {
                if (Stats.getKarma != Stats.karma) {
                    Stats.getKarma = Stats.karma;
                    table();
                } else if (Stats.getSPC != Stats.SPC){
                    Stats.getSPC = Stats.SPC;
                    table();
                } else if (Stats.getOPC != Stats.OPC){
                    Stats.getOPC = Stats.OPC;
                    table();
                } else if (Stats.getWisdom != Stats.wisdom){
                    Stats.getWisdom = Stats.wisdom;
                    table();
                } else if (Stats.getBillsProposed != Stats.billsProposed){
                    Stats.getBillsProposed = Stats.billsProposed;
                    table();
                } else if (Stats.getBillsPassed != Stats.billsPassed){
                    Stats.getBillsPassed = Stats.billsPassed;
                    table();
                }
            }
        });

        tableUpdater.start();
        runSections.start();
    }
}