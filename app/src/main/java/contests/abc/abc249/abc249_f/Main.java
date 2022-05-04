/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * F - Ignore Operations
 * https://atcoder.jp/contests/abc249/tasks/abc249_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/31440206
 *
 */

package contests.abc.abc249.abc249_f;

import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());
    int[] array_t = new int[n + 1];
    long[] array_y = new long[n + 1];
    array_t[0] = 1;
    array_y[0] = 0;
    for (int i = 1; i <= n; i++) {
      array_t[i] = Integer.parseInt(sc.next());
      array_y[i] = Long.parseLong(sc.next());
    }
    sc.close();

    long ans = Long.MIN_VALUE;
    long total_score = 0;
    long ignore_score = 0;
    int ignore_cnt = 0;
    TreeMap<Long, Integer> map_val_cnt = new TreeMap<>();
    int cnt_t1 = 0;
    for (int i = n; i >= 0; i--) {
      int val_t = array_t[i];
      long val_y = array_y[i];
      if (val_t == 1) {
        long tmp_score = val_y + total_score + ignore_score;
        ans = Math.max(tmp_score, ans);
        cnt_t1++;
        if (k < cnt_t1) {
          break;
        }
      } else if (val_t == 2) {
        total_score += val_y;
        if (val_y < 0) {
          map_val_cnt.put(val_y, map_val_cnt.getOrDefault(val_y, 0) + 1);
          ignore_score += Math.abs(val_y);
          ignore_cnt++;
        }
      }

      if (ignore_cnt > k - cnt_t1) {
        long highest = map_val_cnt.lastKey();
        int stock = map_val_cnt.get(highest);
        if (stock == 1) {
          map_val_cnt.remove(highest);
        } else {
          map_val_cnt.put(highest, stock - 1);
        }
        ignore_score -= Math.abs(highest);
        ignore_cnt--;
      }
    }
    System.out.println(ans);
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
