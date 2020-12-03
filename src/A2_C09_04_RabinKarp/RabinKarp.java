package A2_C09_04_RabinKarp;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

    private long patHash;
    private int M;
    private long Q;
    private int R;
    private long RM;

    public RabinKarp(String pat) {
        M = pat.length();
        R = 256;
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q; // precompute (R^(M - 1)) % Q
        }
        patHash = hash(pat, M);
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash) {
            return 0;
        }
        for (int i = M; i <= N - M; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                return i - M + 1;
            }
        }
        return N;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

}
