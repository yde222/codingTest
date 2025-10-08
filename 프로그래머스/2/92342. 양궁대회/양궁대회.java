import java.util.*;

class Solution {
public int[] solution(int n, int[] info) {

        int ryanfail = -1;
        int[] maxInfo = new int[11];

        for (int mask = 0; mask<( 1<< 11); mask++){
            int[] ryan = new int[11];
            int usedArrows = 0;

            for (int i = 0; i < 11; i++) {
                if((mask&(1<<i)) !=0){
                    ryan[i] = info[i]+1;
                    usedArrows += ryan[i];
                }
            }

            if(usedArrows > n ) continue;

            ryan[10] += (n - usedArrows);

            int scoreDiff = calculateScoDiff(ryan, info);

            if(scoreDiff > 0){
                if(scoreDiff >ryanfail){
                    ryanfail = scoreDiff;
                    maxInfo = ryan.clone();
                } else if(scoreDiff == ryanfail){
                    if(isLowwerScorePreferred(ryan,maxInfo)){
                        maxInfo = ryan.clone();
                    }
                }
            }
        }


        return ryanfail <= 0 ? new int[]{-1} : maxInfo;

    }

    private  int calculateScoDiff(int[] ryan, int[] info){
        int ryanScore = 0, apeachScore = 0;

        for(int i = 0; i<11; i++){
            int score = 10-i;
            if(ryan[i] > info[i]){
                ryanScore += score;
            }else if(info[i] >0){
                apeachScore += score;
            }

        }
        return  ryanScore - apeachScore;
    }

    private boolean isLowwerScorePreferred(int[] ryan, int[] best){

        for(int i=10; i >=0; i--){
            if(ryan[i] > best[i]){
                return true;
            }
            if(ryan[i] < best[i]){
                return false;
            }
        }
        return false;
    }

    
}