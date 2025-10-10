import java.util.*;


class Solution {
    
    int toMin(String t){ 
        String[] s=t.split(":"); 
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]); 
    }
    int fee(int total,int[] f){
        if(total<=f[0]) return f[1];
        int extra = total - f[0];
        return f[1] + (int)Math.ceil(extra/(double)f[2])*f[3];
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> acc = new TreeMap<>();
        for(String r : records){
            String[] s = r.split(" ");
            int t = toMin(s[0]); 
            String car = s[1];
            String type = s[2];
            if(type.equals("IN")) in.put(car,t);
            else acc.put(car, acc.getOrDefault(car,0)+(t-in.remove(car)));
            
        }
     
        int end = 23*60 + 59;
        for (var e : in.entrySet()) {
            String car = e.getKey();
            int tIn = e.getValue();
            acc.put(car, acc.getOrDefault(car, 0) + (end - tIn));
        }

        int[] ans = new int[acc.size()];
        int i = 0;
        for (int total : acc.values()) {
            ans[i++] = fee(total, fees);
        }
        return ans;
    }
}