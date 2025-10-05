import java.util.*;

class Solution {
    
   
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관별 유효기간을 저장할 Map
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            String termType = parts[0];
            int period = Integer.parseInt(parts[1]);
            termMap.put(termType, period);
        }
        
        // 오늘 날짜를 일수로 변환
        int todayDays = dateToDay(today);
        
        // 파기해야 할 개인정보 번호를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        
        // 각 개인정보 검사
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String collectDate = parts[0];
            String termType = parts[1];
            
            // 수집 날짜를 일수로 변환
            int collectDays = dateToDay(collectDate);
            
            // 유효기간을 일수로 변환하여 만료일 계산
            int validPeriodDays = termMap.get(termType) * 28;
            int expireDays = collectDays + validPeriodDays;
            
            // 오늘 날짜가 만료일보다 크거나 같으면 파기 대상
            if (todayDays >= expireDays) {
                result.add(i + 1); // 1번부터 시작
            }
        }
        
        // List를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}