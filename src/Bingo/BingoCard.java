package Bingo;

import java.util.Random;

public class BingoCard {
    int[][] nums;
    int id;
    boolean isWritten;
    public BingoCard(int id) {
        this.id = id;
        //TODO randomize the nums, no duplicates
        //B:01-15,
        //I:16-30,
        //N:31-45(middle is 0),
        //G:46-60,
        //O:61-75
        nums = new int[5][5];
        Random rand = new Random();
        int num;
        //B = column 1;

        for(int i = 0; i <5;i++){
            do {
                num = rand.nextInt(14) + 1;
                isWritten = false;
                for(int row = 0; row < 5; row++){
                    for(int col = 0; col < 5; col++){
                        if(nums[row][col]==num){
                            isWritten = true;
                            break;
                        }
                    }
                }
            }while(isWritten);
            nums[i][0]=num;
        }
        //I = column 2;
        for(int i = 0; i <5;i++){
            do {
                num = rand.nextInt(15,30)+1;
                isWritten = false;
                for(int row = 0; row < 5; row++){
                    for(int col = 0; col < 5; col++){
                        if(nums[row][col]==num){
                            isWritten = true;
                            break;
                        }
                    }
                }
            }while(isWritten);
            nums[i][1]=num;
        }
        //N = column 3;
        for(int i = 0; i <5;i++){
            do{
                num = rand.nextInt(30,44)+1;
                isWritten = false;
                for(int row = 0; row < 5; row++){
                    for(int col = 0; col < 5; col++){
                        if(nums[row][col]==num){
                            isWritten = true;
                            break;
                        }
                    }
                }
            }while(isWritten);
            nums[i][2]=num;
        }
        nums[2][2]=0;
        //G = column 4;
        for(int i = 0; i <5;i++){
            do{
                num = rand.nextInt(45,59)+1;
                isWritten = false;
                for(int row = 0; row < 5; row++){
                    for(int col = 0; col < 5; col++){
                        if(nums[row][col]==num){
                            isWritten = true;
                            break;
                        }
                    }
                }
            }while(isWritten);
            nums[i][3]=num;
        }
        //0 = column 5;
        for(int i = 0; i <5;i++){
            do{
                num = rand.nextInt(60,74)+1;
                isWritten = false;
                for(int row = 0; row < 5; row++){
                    for(int col = 0; col < 5; col++){
                        if(nums[row][col]==num){
                            isWritten = true;
                            break;
                        }
                    }
                }
            }while(isWritten);
            nums[i][4]=num;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("B\tI\tN\tG\tO\n");
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
