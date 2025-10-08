import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] data = new String[files.length][4];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            data[i][0] = file;                    
            data[i][3] = String.valueOf(i);       
            

            int numStart = 0;
            while (numStart < file.length() && !Character.isDigit(file.charAt(numStart))) {
                numStart++;
            }
            
            int numEnd = numStart;
            int digitCount = 0;
            while (numEnd < file.length() && 
                   Character.isDigit(file.charAt(numEnd)) && 
                   digitCount < 5) {
                numEnd++;
                digitCount++;
            }
            
            data[i][1] = file.substring(0, numStart);      
            data[i][2] = file.substring(numStart, numEnd); 
        }
        
   
        Arrays.sort(data, (a, b) -> {
         
            int headCompare = a[1].compareToIgnoreCase(b[1]);
            if (headCompare != 0) {
                return headCompare;
            }
       
            int numberA = Integer.parseInt(a[2]);
            int numberB = Integer.parseInt(b[2]);
            if (numberA != numberB) {
                return numberA - numberB;
            }
            
           
            return Integer.parseInt(a[3]) - Integer.parseInt(b[3]);
        });
        

        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = data[i][0]; 
        }
        
        return result;
    }

}