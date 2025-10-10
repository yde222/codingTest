class Solution {
    
    int[] best = {-1};
    int bestDiff = -1;
    
    public int[] solution(int n, int[] info) {
        dfs(0,n, info, new int[11]);
        return best;
    }
    
    void dfs(int idx, int arrows, int[] apeach, int[] ryan){
        if(idx == 11) {
            ryan[10] += arrows;
            int diff = scoreDiff(apeach, ryan);
            
            if(diff <=0) {
                ryan[10] -= arrows;
                return;
            }
            
            if(diff>bestDiff || (diff == bestDiff && better(ryan,best))){
                bestDiff = diff;
                best = ryan.clone();
            }
            ryan[10] -= arrows;
            return;
        }
        
        int need= apeach[idx] +1;
        if(need<= arrows){
            ryan[idx] = need;
            dfs(idx+1,arrows-need,apeach,ryan);
            ryan[idx]=0;
        }
        
        dfs(idx +1, arrows, apeach, ryan);
    }
    
    
     int scoreDiff(int[] apeach, int[] ryan) {
        int apeachScore = 0, ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i]) apeachScore += 10 - i;
            else ryanScore += 10 - i;
        }
        return ryanScore - apeachScore;
    }

 
    boolean better(int[] ryan, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > best[i]) return true;
            if (ryan[i] < best[i]) return false;
        }
        return false;
    }
}