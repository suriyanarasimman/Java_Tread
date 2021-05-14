import java.util.Scanner;

import java.util.*;

public class MainClass {
    int flag = 0;
    int clos = 0;
    int time;
    int choice;
    Scanner sc = new Scanner(System.in);
    ArrayList<Details> l = new ArrayList<Details>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    MainClass(int n) {
        int id;
        String s = new String();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the id:");
            id = sc.nextInt();
            list.add(id);
            sc.nextLine();
            System.out.print("Enter the string:");
            s = sc.nextLine();
            Details obj = new Details(id, s);
            l.add(obj);
        }
    }

    public void threadsleep(int ch) {
        if (!list.contains(ch)) {
            System.out.println("Wrong Choice");
            return;
        } else {
            for (Details i : l) {
                if (i.id == ch && i.isalive) {
                    flag = 1;
                    System.out.println("Enter time:");
                    time = sc.nextInt();
                    Storage q = new Storage(i, time);
                    q.start();
                    System.out.println("Thead is sucessfully put to sleep");
                    return;
                } else if (i.id == ch && !i.isalive) {
                    flag = 1;
                    System.out.println("Thread is already in sleep");
                    return;
                }
            }
            if (flag == 0) {
                System.out.println("No thread in the name");
                return;
            }
        }

    }

    public void printthread() {
        int len = l.size();
        if (len >= 1) {
            for (Details i : l) {
                if (i.isalive) {
                    System.out.println("Thread " + i.id + " is alive");
                } else {
                    System.out.println("Thread " + i.id + " is notalive");
                }
            }
        }

    }

    public void getChoice() {

        System.out.print("Enter 1 for making a thread busy and 2 for checking and 0 to exit:");
        choice = sc.nextInt();

        switch (choice) {
            case 0:
                clos = 1;
                break;
            case 1:
                int ch;
                System.out.println("Enter the Thread to Block from this" + list + ":");
                ch = sc.nextInt();
                threadsleep(ch);
                break;
            case 2:
                printthread();
                break;
        }
        if (clos == 0) {
            getChoice();
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the No of threads:");
        n = sc.nextInt();
        MainClass ma = new MainClass(n);
        ma.getChoice();
        sc.close();
    }
}
