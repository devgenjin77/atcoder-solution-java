/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * F - Union of Two Sets
 * https://atcoder.jp/contests/abc282/tasks/abc282_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37415572
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int n = Integer.parseInt(br.readLine());
    final int log2n = Math.max(ceilPow2(n), 1);
    //Phase1
    pw.println(log2n * n);
    for (int k = 0; k < log2n; k++) {
      int w = 1 << k;
      for (int l = 0; l < n; l++) {
        int r = Math.min(l + w, n);
        pw.println(String.format("%d %d", l + 1, r));
      }
    }
    pw.flush();
    //Phase2
    final int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      StringTokenizer st_lr = new StringTokenizer(br.readLine());
      int _l = Integer.parseInt(st_lr.nextToken()) - 1;
      int _r = Integer.parseInt(st_lr.nextToken());
      int width = _r - _l;
      int log = Integer.toBinaryString(width).length() - 1;
      int a = (n * log) + _l;
      int b = a + width - (1 << log);
      pw.println(String.format("%d %d", a + 1, b + 1));
      pw.flush();
    }
    pw.close();
    br.close();
  }

  private static int ceilPow2(int n) {
    int x = 0;
    while ((1 << x) < n) {
      x++;
    }
    return x;
  }
}
