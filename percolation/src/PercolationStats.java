import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
      private Percolation p;
      private double[] est;
      private double mean;
      private double stddev;
      private double confidenceLo;
      private double confidenceHi;

      // perform independent trials on an n-by-n grid
      public PercolationStats(int n, int trials) {
            if (n <= 0 || trials <= 0) {
                  throw new IllegalArgumentException("n or trails <= 0");
            }

            est = new double[trials];
            for (int i = 0; i < trials; i++) {
                  p = new Percolation(n);
                  int count = 0;
                  while (!p.percolates()) {
                        int row = StdRandom.uniform(1, n + 1);
                        int col = StdRandom.uniform(1, n + 1);
                        if (p.isOpen(row, col)) {
                              continue;
                        }
                        p.open(row, col);
                        count++;
                  }
                  est[i] = count / n ^ 2;
            }
            mean = StdStats.mean(est) / n;
            stddev = StdStats.stddev(est);
            confidenceLo = mean - (1.96 * stddev) / Math.sqrt(trials) / n;
            confidenceHi = mean + (1.96 * stddev) / Math.sqrt(trials) / n;
      }

      // sample mean of percolation threshold
      public double mean() {
            return mean;
      }

      // sample standard deviation of percolation threshold
      public double stddev() {
            return stddev;
      }

      // low endpoint of 95% confidence interval
      public double confidenceLo() {
            return confidenceLo;
      }

      // high endpoint of 95% confidence interval
      public double confidenceHi() {
            return confidenceHi;
      }

      // test client (see below)
      public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            int t = Integer.parseInt(args[1]);
            PercolationStats stats = new PercolationStats(n, t);
            StdOut.println("mean                    = " + stats.mean);
            StdOut.println("stddev                  = " + stats.stddev);
            StdOut.println("95% confidence interval = [" + stats.confidenceLo + ", " + stats.confidenceHi + "]");
      }
}
