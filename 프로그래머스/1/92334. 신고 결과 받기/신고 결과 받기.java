import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        Map<String,Integer> idx = new HashMap<>();
        for(int i=0; i<n; i++){
            idx.put(id_list[i],i);
        };
        Map<String,Set<String>> accused = new HashMap<>();
        for(String r : report){
            String[] sp = r.split(" ");
            accused.computeIfAbsent(sp[1], t -> new HashSet<>()).add(sp[0]);
        }
        
        int[] mail = new int[n];
        for(var e: accused.entrySet()){
            if(e.getValue().size()>=k) for(String from: e.getValue()) mail[idx.get(from)]++;
        }
        return mail;
        
        
    }
}