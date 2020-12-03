package A2_C09_03_BoyerMoore;

public class BoyerMoore {

    private int R;
    private int[] right;
    private String pat;
    private int M;

    public BoyerMoore(String pat) {
        R = 256;
        this.pat = pat;
        M = pat.length();
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return N;
    }

}
