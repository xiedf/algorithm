import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {

    public static void main(String[] args) {
        StdOut.printf("Hello %s and %s", args[0], args[1]);
        StdOut.println();
        StdOut.printf("Goodbye %s and %s", args[1], args[0]);
        StdOut.println();
    }
}