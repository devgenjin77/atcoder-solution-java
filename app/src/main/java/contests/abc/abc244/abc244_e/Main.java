/*
 * ABC244
 * E - King Bombee
 * https://atcoder.jp/contests/abc244/tasks/abc244_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31384990
 *
 */

package contests.abc.abc244.abc244_e;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());
    int s = Integer.parseInt(sc.next()) - 1;
    int t = Integer.parseInt(sc.next()) - 1;
    int x = Integer.parseInt(sc.next()) - 1;
    int[] array_u = new int[m];
    int[] array_v = new int[m];
    for (int i = 0; i < m; i++) {
      array_u[i] = Integer.parseInt(sc.next()) - 1;
      array_v[i] = Integer.parseInt(sc.next()) - 1;
    }
    sc.close();
    //dp[i][j][k]:=i個目まで見て、頂点jに到達し、xを通った回数が(k % 2)回目
    long[][] dp = new long[n][2];
    dp[s][0] = 1;
    for (int i = 0; i < k; i++) {
      long[][] dp_next = new long[n][2];
      for (int j = 0; j < m; j++) {
        //u -> v
        if (array_v[j] == x) {
          dp_next[array_v[j]][1] = (dp_next[array_v[j]][1] + dp[array_u[j]][0]) % MOD;
          dp_next[array_v[j]][0] = (dp_next[array_v[j]][0] + dp[array_u[j]][1]) % MOD;
        } else {
          dp_next[array_v[j]][0] = (dp_next[array_v[j]][0] + dp[array_u[j]][0]) % MOD;
          dp_next[array_v[j]][1] = (dp_next[array_v[j]][1] + dp[array_u[j]][1]) % MOD;
        }
        //v -> u
        if (array_u[j] == x) {
          dp_next[array_u[j]][1] = (dp_next[array_u[j]][1] + dp[array_v[j]][0]) % MOD;
          dp_next[array_u[j]][0] = (dp_next[array_u[j]][0] + dp[array_v[j]][1]) % MOD;
        } else {
          dp_next[array_u[j]][0] = (dp_next[array_u[j]][0] + dp[array_v[j]][0]) % MOD;
          dp_next[array_u[j]][1] = (dp_next[array_u[j]][1] + dp[array_v[j]][1]) % MOD;
        }
      }
      dp = dp_next;
    }
    System.out.println(dp[t][0]);
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
