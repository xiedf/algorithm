import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   // creates n-by-n grid, with all sites initially blocked
   private boolean[][] open;
   private WeightedQuickUnionUF uf;
   private int n;
   private int count;

   public Percolation(int n) {
      if (n <= 1) {
         throw new IllegalArgumentException("n <= 1");
      }
      this.n = n;
      open = new boolean[n][n];
      uf = new WeightedQuickUnionUF(n * (n + 2));
      return;
   }

   // opens the site (row, col) if it is not open already
   public void open(int row, int col) {
      open[row][col] = true;
      count++;
   }

   // is the site (row, col) open?
   public boolean isOpen(int row, int col) {
      return open[row][col];
   }

   // is the site (row, col) full?
   public boolean isFull(int row, int col) {
      return uf.connected(row*n + col), (n + 1) * n);
   }

   // returns the number of open sites
   public int numberOfOpenSites() {
      return count;
   }

   // does the system percolate?
   public boolean percolates() {
      return isFull(0, 0);
   }

   // test client (optional)
   public static void main(String[] args) {
   }

}