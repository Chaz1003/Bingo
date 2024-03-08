package Bingo;

public class BingoRowChecker extends BingoChecker {
    int row;

    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row - 1;
    }

    @Override
    public void run() {
        for (int col = 0; col < 5; col++) {
            int num = 0;
            System.out.println("Waiting for num " + num);
            num = card.nums[row][col];

            synchronized (BingoGame.result) {
                try {
                    while (!BingoGame.result[num]) {
                        BingoGame.result.wait();
                    }

                } catch (InterruptedException e) {
                    return;
                }
                // get the number at this row and col
                // wait until result[num] is true
            }
            System.out.println("Card " + card.id + " finishes row " + (row + 1));
            System.out.println(card);
        }
    }
}