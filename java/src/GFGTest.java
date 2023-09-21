import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class GFGTest {
    public static void main (String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(sc.readLine());
        while(tests-- > 0){
            String [] s = sc.readLine().trim().split("\\s+");//System.out.println(s[1]);
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] arr = new int[n];
            String[] s1 = sc.readLine().trim().split("\\s+");//System.out.println(s[0]);
            for(int i=0; i<s1.length; i++){
                arr[i] = Integer.parseInt(s1[i]);
            }
            PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<n; i++){
                p.add(arr[i]);
                if(p.size() == k+1){
                    p.remove();
                }
            }
            int sum = 0;
            while(!p.isEmpty()){
                sum+=p.remove();
            }
            System.out.println(sum);
            //System.out.println();
            //sc.readLine();
        }
    }
}
