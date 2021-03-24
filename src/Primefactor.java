import java.util.Arrays;

//Given a number N, print all its unique prime factors and their powers in N.
public class Primefactor {
    //using sieve of erasthothenes to
    //find smallest prime factor of all numbers
    //for example if N=20
    //s[2]=s[4]=s[6]=s[8]=s[10]=s[12]=s[14]=s[16]=s[18]=s[20]=2
    //s[3]=s[9]=s[15]=3
    //s[5]=5
    //s[7]=7
    //s[11]=11
    //s[13]=12
    //s[17]=17
    //s[19]=19

    static void sieveoferasthotenes(int N,int prime[]) {

        for (int i = 1; i <= N; i++) {
            prime[i] = i;
        }
        prime[1] = 0;
        for (int i = 2; i * i <= N; i++){
            if(prime[i]==i){
                for(int j = i; i*j <= N; j++){
                    if(prime[i*j]==i*j){
                        prime[i*j]= i;
                    }

                }
            }
        }
//        for(int i = 2; i < N; i++){
//            if(prime[i] ==1){
//                prime[i] = i;
//            }
//        }
//        for(int i = 2; i <= N; i++){
//            if(prime[i] ==0){
//                prime[i] = spf[i];
//            }
//        }
        System.out.println(Arrays.toString(prime));


    }

    static void generatePrimeFactors(int N) {
        // s[i] is going to store
        // smallest prime factor of i.
        int[] s = new int[N + 1];

        // Filling values in s[] using sieve
        sieveoferasthotenes(N,s);

        System.out.println("Factor Power");
        int curr = s[N]; // Current prime factor of N
        int cnt = 1; // Power of current prime factor

        // Printing prime factors
        // and their powers
        while (N > 1)
        {
            N /= s[N];

            // N is now N/s[N]. If new N
            // also has smallest prime
            // factor as curr, increment power
            if (curr == s[N])
            {
                cnt++;
                continue;
            }

            System.out.println(curr + "\t" + cnt);

            // Update current prime factor
            // as s[N] and initializing
            // count as 1.
            curr = s[N];
            cnt = 1;
        }





    }

        public static void main(String[] args){
        int N = 50;
            generatePrimeFactors(N);

    }


}
