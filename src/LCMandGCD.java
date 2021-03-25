import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCMandGCD {
    public static void main(String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0){
            String []S = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);
            Long[] ptr = lcmAndGCD(A,B);
            System.out.print(ptr[0]+" "+ptr[1]+"\n");

        }

    }

    private static Long[] lcmAndGCD(Long a, Long b) {
        Long[] v = new Long[2];
        v[1] = gcd(a,b);
        v[0] = (a*b)/v[1];
        return v;
    }

    static Long gcd(Long A, Long B){
        Long minm = Math.min(A,B);
        Long maxm = Math.max(A,B);
        if(minm ==0) return maxm;
        else
        {
            while (maxm%minm!=0){
                Long tmp = maxm;
                maxm = minm;
                minm = tmp%maxm;
            }
        }
        return minm;
    }
}
