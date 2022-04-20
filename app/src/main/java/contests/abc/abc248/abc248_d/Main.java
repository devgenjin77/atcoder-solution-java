/*
 * ユニークビジョンプログラミングコンテスト2022
 * （AtCoder Beginner Contest 248）
 * D - Range Count Query
 * https://atcoder.jp/contests/abc248/tasks/abc248_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc248/submissions/31111262
 *
 * note:
 * 二分探索
 *
 */

package contests.abc.abc248.abc248_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner();
    int n = Integer.parseInt(sc.next());
    List<Integer>[] arr_idx = new List[n];
    for (int i = 0; i < n; i++) {
      arr_idx[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      arr_idx[a].add(i);
    }
    int q = Integer.parseInt(sc.next());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int l = Integer.parseInt(sc.next()) - 1;
      int r = Integer.parseInt(sc.next());
      int x = Integer.parseInt(sc.next()) - 1;
      if (arr_idx[x].size() == 0) {
        pw.println(0);
      } else {
        int left = Collections.binarySearch(arr_idx[x], l);
        if (left < 0) {
          left = ~left;
        }
        int right = Collections.binarySearch(arr_idx[x], r);
        if (right < 0) {
          right = ~right;
        }
        pw.println(right - left);
      }
    }
    pw.close();
    sc.close();

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
