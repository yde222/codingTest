import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> arr = new ArrayList<>();

        for(int[] c: commands){
            int i = c[0],j=c[1], k=c[2];

            int[] temp = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(temp);
            arr.add(temp[k-1]);
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
}