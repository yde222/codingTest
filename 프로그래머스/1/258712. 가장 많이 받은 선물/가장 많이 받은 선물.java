import java.util.*;


class Solution {
         public int solution(String[] friends, String[] gifts) {

        int n = friends.length;

        Map<String,Integer> nameIndex = new HashMap<>();
        for(int i= 0; i<n; i++){
            nameIndex.put(friends[i],i);
        }

        int[][] giftRecord = new int[n][n];

        int[] giveCount = new int[n];
        int[] receiveCount = new int[n];


        for(String gift : gifts){

            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            int giverIdx = nameIndex.get(giver);
            int receiverIdx = nameIndex.get(receiver);

            giftRecord[giverIdx][receiverIdx]++;
            giveCount[giverIdx]++;
            receiveCount[receiverIdx]++;

        }


        int[] nextMonthGifts = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int iToJ = giftRecord[i][j];
                int jToI = giftRecord[j][i];

                if(iToJ > jToI){
                    nextMonthGifts[i]++;
                } else if(jToI > iToJ){
                    nextMonthGifts[j]++;
                } else {
                    int iGiftIndex = giveCount[i] - receiveCount[i];
                    int jGiftIndex = giveCount[j] - receiveCount[j];

                    if(iGiftIndex > jGiftIndex){
                        nextMonthGifts[i]++;
                    } else if(jGiftIndex > iGiftIndex){
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        return Arrays.stream(nextMonthGifts).max().orElse(0);
    }
}