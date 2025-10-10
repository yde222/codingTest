class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int deliveryLoad = 0;  
        int pickupLoad = 0;    
        
        for (int i = n - 1; i >= 0; i--) {
            deliveryLoad += deliveries[i];
            pickupLoad += pickups[i];
         
            while (deliveryLoad > 0 || pickupLoad > 0) {
             
                totalDistance += (long)(i + 1) * 2;
            
                deliveryLoad -= cap;
                pickupLoad -= cap;
            }
        }
        
        return totalDistance;
    }
}