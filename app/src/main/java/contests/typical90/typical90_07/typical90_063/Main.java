/*
 * 競プロ典型90問
 * 063 - Monochromatic Subgrid（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bk
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31941814
 *
 * note:
 * -小さい制約に着目する
 *
 */

package contests.typical90.typical90_07.typical90_063;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int[][] color_grid = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        color_grid[i][j] = Integer.parseInt(sc.next());
      }
    }
    sc.close();
    int ans = 0;
    for (int bit = 1; bit < (1 << h); bit++) {
      Map<Integer, Integer> color_cnt = new HashMap<>();
      int max_cnt = 0;
      for (int col = 0; col < w; col++) {
        boolean isSame = true;
        int color = -1;
        for (int row = 0; row < h; row++) {
          if ((bit >> row & 1) == 0) {
            continue;
          }
          if (color == -1) {
            color = color_grid[row][col];
          } else {
            if (color_grid[row][col] != color) {
              isSame = false;
              break;
            }
          }
        }
        if (isSame) {
          int now_cnt = color_cnt.getOrDefault(color, 0) + 1;
          color_cnt.put(color, now_cnt);
          max_cnt = Math.max(now_cnt, max_cnt);
        }
      }
      int cnt_h = Integer.bitCount(bit);
      ans = Math.max(max_cnt * cnt_h, ans);
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
