import java.util.*;

class Solution{
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] p = t.split(" ");
            termMap.put(p[0], Integer.parseInt(p[1]));
        }
        int todayDays = toDays(today);
        List<Integer> res = new ArrayList<>();

        for(int i =0; i< privacies.length; i++ ){
            String[] p = privacies[i].split(" ");
            String date = p[0];
            String termType = p[1];

            int collectedDays = toDays(date);
            int termMonths = termMap.get(termType);

            int expireDays = collectedDays + termMonths *28 -1;

            if(todayDays > expireDays){
                res.add(i+1);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private int toDays(String date){
        String[] s = date.split("\\.");
        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        return y *12 *28 + m*28 +d;
    }

}