package us.mattgreen;

import java.util.Scanner;

public class Main {

    private final static FileInput cardAccts = new FileInput("movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("movie_purchases.csv");
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String line;
        String[] fields;
        int[] nums = new int[2];
        System.out.format("%8s  %-18s %6s %6s\n","Account","Name", "Movies", "Points");
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(fields[0], nums);
            System.out.format("00%6s  %-18s  %2d   %4d\n",fields[0],fields[1], nums[0], nums[1]);
        }

        cardPurchases.fileClose();
        FileInput cardPurchaces2 = new FileInput("movie_purchases.csv");
        int[] nums2 = new int[2];
        System.out.println("Rating Number" + " " +  "Count");

        String oldAcct="NA"; int total = 0; int count = 0;
        while ((line = cardPurchaces2.fileReadLine()) != null) { fields = line.split(",");
        if (!oldAcct.equals(fields[0])) {
            if (!oldAcct.equals("NA")) {
                System.out.println(oldAcct + "\t " + " " + total);
            }
            oldAcct=fields[0];
            count = 0;
            total = 0;
        }
        total += Integer.parseInt(fields[2]);
        count++;
        }
        System.out.print(oldAcct + " " + total);




    }




    public static void findPurchases(String acct, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;
        String line;
        String[] fields;
        boolean done = false;
        boolean eof = false;
        while (((line = cardPurchases.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
            }
        }

    }
}