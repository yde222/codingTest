class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if (eq.equals("="))
            if(ineq.equals(">"))
                if(n>=m)
                    answer = 1;
            if(ineq.equals("<"))
                if(n<=m)
                    answer = 1;
        if (eq.equals("!"))
            if(ineq.equals(">"))
                if(n>m)
                    answer = 1;
            if(ineq.equals("<"))
                if(n<m)
                    answer = 1;
        
    return answer;
    }
}