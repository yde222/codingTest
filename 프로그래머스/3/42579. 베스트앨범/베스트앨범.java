import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String,PriorityQueue<int[]>> genreMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre,0)+play);
            
            genreMap.computeIfAbsent(genre,k -> new PriorityQueue<>((a,b)-> {
                if(a[1]==b[1]) return a[0]- b[0];
                return b[1]-a[1];
            })
            ).offer(new int[]{i,play});
        }
        
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a,b)-> genreTotal.get(b)-genreTotal.get(a));
        
        List<Integer> result = new ArrayList<>();
        for(String genre : sortedGenres){
            PriorityQueue<int[]> pq = genreMap.get(genre);
            for(int j=0; j<2 &&  !pq.isEmpty(); j++){
                result.add(pq.poll()[0]);
            }
        }
        return result.stream().mapToInt(i-> i).toArray();
        
        }
}