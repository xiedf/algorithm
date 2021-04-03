
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        double count = 0;
        String champion = null;
        String in = null;
        boolean b;

        while (!StdIn.isEmpty()) {
            count++;
            b = StdRandom.bernoulli(1 / count);
            // StdOut.println(b);
            // StdOut.println(count);
            in = StdIn.readString();
            // StdOut.println("in=" + in);
            if (b) {
                champion = in;
            }
            // StdOut.println("cham=" + champion);
        }
        StdOut.println(champion);

    }
}
