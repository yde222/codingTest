import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int sum = 0;

        for(int i=0; i< n; i++){
            sum += number.charAt(i) -'0';
        }
        System.out.println(sum);
    }
}