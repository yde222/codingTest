


class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTimeInSec = timeToSec(play_time);
        int advTimeInSec = timeToSec(adv_time);
        
      
        int[] diff = new int[playTimeInSec + 1];
        
  
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = timeToSec(parts[0]);
            int end = timeToSec(parts[1]);
            diff[start]++;    // 시작 시점에 +1
            diff[end]--;      // 종료 시점에 -1
        }
        
  
        for (int i = 1; i <= playTimeInSec; i++) {
            diff[i] += diff[i-1];
        }
        
     
        long[] cumSum = new long[playTimeInSec + 1];
        for (int i = 1; i <= playTimeInSec; i++) {
            cumSum[i] = cumSum[i-1] + diff[i-1];
        }
        
       
        long maxSum = cumSum[advTimeInSec] - cumSum[0]; 
        int bestStart = 0;
        
        for (int start = 1; start + advTimeInSec <= playTimeInSec; start++) {
           
            long currentSum = cumSum[start + advTimeInSec] - cumSum[start];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
            }
        }
        
        return secToTime(bestStart);
    }
    
  
    private int timeToSec(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 + 
               Integer.parseInt(parts[1]) * 60 + 
               Integer.parseInt(parts[2]);
    }
    
  
    private String secToTime(int sec) {
        int h = sec / 3600;
        int m = (sec % 3600) / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}