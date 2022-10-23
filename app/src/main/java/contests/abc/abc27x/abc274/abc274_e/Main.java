/*
 * キーエンスプログラミングコンテスト2022
 * （AtCoder Beginner Contest 274）
 * E - Booster
 * https://atcoder.jp/contests/abc274/tasks/abc274_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc274/submissions/35920662
 *
 */

package contests.abc.abc27x.abc274.abc274_e;

public class Main {

  private static final double INF = 1e20;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final long[] array_x = new long[n + m];
    final long[] array_y = new long[n + m];
    for (int i = 0; i < n + m; i++) {
      array_x[i] = Long.parseLong(sc.next());
      array_y[i] = Long.parseLong(sc.next());
    }
    sc.close();
    final double[] dist_frm_0 = new double[n + m];
    for (int i = 0; i < n + m; i++) {
      dist_frm_0[i] = Math.sqrt((array_x[i] * array_x[i]) + (array_y[i] * array_y[i]));
    }
    final double[][] mtx_dist = new double[n + m][n + m];
    for (int i = 0; i < n + m - 1; i++) {
      for (int j = i + 1; j < n + m; j++) {
        long d_x = array_x[i] - array_x[j];
        long d_y = array_y[i] - array_y[j];
        double dist = Math.sqrt((d_x * d_x) + (d_y * d_y));
        mtx_dist[i][j] = dist;
        mtx_dist[j][i] = dist;
      }
    }
    //dp[s][p]:=訪問ずみの街か宝の集合Sにたいして、最終位置がp
    final double[][] dp = new double[1 << (n + m)][n + m];
    double ans = INF;
    int mask = (1 << n) - 1;
    for (int bit_s = 1; bit_s < 1 << (n + m); bit_s++) {
      int speed_n = 1 << (Integer.bitCount(bit_s >> n));
      for (int last_pos = 0; last_pos < n + m; last_pos++) {
        if ((bit_s >> last_pos & 1) == 0) {
          continue;
        }
        if (Integer.bitCount(bit_s) == 1) {
          dp[bit_s][last_pos] = dist_frm_0[last_pos];
        } else {
          dp[bit_s][last_pos] = INF;
          int prev_s = bit_s - (1 << last_pos);
          int speed = 1 << (Integer.bitCount(prev_s >> n));
          for (int prev_pos = 0; prev_pos < n + m; prev_pos++) {
            if ((prev_s >> prev_pos & 1) == 0) {
              continue;
            }
            dp[bit_s][last_pos] = Math.min(
                dp[prev_s][prev_pos] + mtx_dist[prev_pos][last_pos] / speed, dp[bit_s][last_pos]);
          }
        }
        if ((bit_s & mask) == mask) {
          ans = Math.min(dp[bit_s][last_pos] + (dist_frm_0[last_pos] / speed_n), ans);
        }
      }
    }
    System.out.println(ans);
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
