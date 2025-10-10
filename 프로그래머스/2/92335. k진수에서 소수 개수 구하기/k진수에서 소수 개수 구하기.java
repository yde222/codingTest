import java.math.BigInteger;

class Solution {
    public int solution(int n, int k) {
        String s = Long.toString(n, k);
        int ans = 0, i = 0, L = s.length();

        while (i < L) {
            if (s.charAt(i) == '0') { i++; continue; }
            int j = i;
            while (j < L && s.charAt(j) != '0') j++;
            String token = s.substring(i, j);  
            if (isPrime(token)) ans++;
            i = j; 
        }
        return ans;
    }

    boolean isPrime(String numStr) {
        if (numStr.equals("1")) return false;
        return new BigInteger(numStr).isProbablePrime(10);
    }
}