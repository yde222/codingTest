import java.util.*;

class Solution {
      public int[] solution(int[] answers) {
 //  각 수포자의 찍기 패턴
    int[] pattern1 = {1, 2, 3, 4, 5};
    int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    //  점수 계산
    int score1 = 0, score2 = 0, score3 = 0;
    
    for (int i = 0; i < answers.length; i++) {
        // 패턴 길이로 나눈 나머지로 순환 접근
        if (answers[i] == pattern1[i % pattern1.length]) score1++;
        if (answers[i] == pattern2[i % pattern2.length]) score2++;
        if (answers[i] == pattern3[i % pattern3.length]) score3++;
    }
    

    
        List<Integer> ans = new ArrayList<>();

        //  최고점 찾기
        int maxScore = Math.max(score1,Math.max(score2,score3));
        if(maxScore == score1){ans.add(1);}
        if(maxScore == score2){ans.add(2);}
        if(maxScore == score3){ans.add(3);}


        return ans.stream().mapToInt(i->i).toArray();


    }
}