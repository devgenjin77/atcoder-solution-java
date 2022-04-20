/*
 * ユニークビジョンプログラミングコンテスト2022
 * （AtCoder Beginner Contest 248）
 * E - K-colinear Line
 * https://atcoder.jp/contests/abc248/tasks/abc248_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc248/submissions/31122088
 *
 */

package contests.abc.abc248.abc248_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner();
    int n = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());
    long[] pos_x = new long[n];
    long[] pos_y = new long[n];
    for (int i = 0; i < n; i++) {
      pos_x[i] = Long.parseLong(sc.next());
      pos_y[i] = Long.parseLong(sc.next());
    }
    sc.close();

    //corner case
    if (k == 1) {
      System.out.println("Infinity");
      return;
    }
    int ans = 0;
    boolean[][] used = new boolean[n][n];
    for (int pt_a = 0; pt_a < n - 1; pt_a++) {
      for (int pt_b = pt_a + 1; pt_b < n; pt_b++) {
        if (used[pt_a][pt_b]) {
          continue;
        } else {
          List<Integer> list_pt = new ArrayList<>();
          list_pt.add(pt_a);
          list_pt.add(pt_b);
          for (int pt_c = pt_b + 1; pt_c < n; pt_c++) {
            long val_a = (pos_x[pt_b] - pos_x[pt_c]) * (pos_y[pt_a] - pos_y[pt_c]);
            long val_b = (pos_y[pt_b] - pos_y[pt_c]) * (pos_x[pt_a] - pos_x[pt_c]);
            if (val_a == val_b) {
              list_pt.add(pt_c);
            }
          }
          if (list_pt.size() >= k) {
            ans++;
            for (int i = 0; i < list_pt.size() - 1; i++) {
              for (int j = i + 1; j < list_pt.size(); j++) {
                used[list_pt.get(i)][list_pt.get(j)] = true;
              }
            }
          }
        }
      }
    }
    System.out.println(ans);
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    public String next() throws IOException {
      if (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(in.readLine());
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
