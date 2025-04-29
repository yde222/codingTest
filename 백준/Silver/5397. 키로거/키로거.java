import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {

            String line = br.readLine();
            Stack<Character> pwdstack = new Stack<>();
            Stack<Character> delstack = new Stack<>();


            for(int j =0; j<line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '<') {
                    if (!pwdstack.isEmpty()) {
                        delstack.push(pwdstack.pop());
                    }
                }else if(ch == '>'){
                    if (!delstack.isEmpty()) {
                        pwdstack.push(delstack.pop());
                    }
                }else if(ch == '-'){
                    if(!pwdstack.isEmpty()) {
                        pwdstack.pop();
                    }
                }else {
                    pwdstack.push(line.charAt(j));
                }
            }

            while(!delstack.isEmpty()){
                pwdstack.push(delstack.pop());
            }

            for(int k=0; k<pwdstack.size(); k++) {
                bw.write(pwdstack.get(k));
            }
            bw.write("\n");

        }

            bw.flush();
            bw.close();

    }
}
