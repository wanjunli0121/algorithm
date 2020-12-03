package A2_C11_01_RunLength;

public class RunLength {

    private final static int R = 256;
    private final static int lgR = 8;

    public static void compress() {
        char run = 0;
        boolean old = false;
        while (!BinaryStdIn.isEmpty()) {
            boolean b = BinaryStdIn.readBoolean();
            if (b != old) {
                BinaryStdOut.write(run, lgR);
                run = 1;
                old = !old;
            } else {
                if (run == R - 1) {
                    BinaryStdOut.write(run, lgR);
                    run = 0;
                    BinaryStdOut.write(run, lgR);
                }
                run++;
            }
        }
        BinaryStdOut.write(run, lgR);
        BinaryStdOut.close();
    }

    public static void expand() {
        boolean bit = false;
        while (!BinaryStdIn.isEmpty()) {
            int run = BinaryStdIn.readInt(lgR);
            for (int i = 0; i < run; i++) {
                BinaryStdOut.write(bit);
            }
            bit = !bit;
        }
        BinaryStdOut.close();
    }

}
