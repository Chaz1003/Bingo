package Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{
    List<BingoCard> cards;
    static boolean bingo;
    static boolean[] result;
    boolean [] isChosen = new boolean[75];
    int [] sequence = new int[75];

    @Override
    public void run() {
        System.out.print("How many players? ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < count; i++){
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card: cards) {
            System.out.println("Card: " + card.id);
            System.out.println(card);
        }

        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        // 3: CHECKERS
        List<Thread> threads = new ArrayList<>();
        for (BingoCard card : cards) {
            threads.add(new Thread(new BingoRowChecker(card, 3)));
        }
        // 2: RANDOM NUMS
        isChosen[0] = true;
        int ctr = 1;
        while (!bingo) {
                Random rand = new Random();
                int num;
                while (true) {
                    num = rand.nextInt(74) + 1;
                    if (!isChosen[num]) {
                        sequence[ctr] = num;
                        ctr++;
                        break;
                    }
                }
                isChosen[num] = true;
                System.out.println("Number drawn: " + num);
                for (int i = 0; i < ctr; i++) {
                    System.out.print(sequence[i] + " ");
                }

                synchronized (result) {
                    result.notifyAll();
                }
         /*
            - generate a random number num
            - set the result at index num to TRUE
            - outputs the number chosen
            - prints out all numbers chosen numerically in the same line
            - notifies those waiting for result
            - sleeps for 300 milliseconds
         */

        }

    }
}
