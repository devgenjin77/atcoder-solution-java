/*
 * サイシードプログラミングコンテスト2021
 * （AtCoder Beginner Contest 219）
 * C - Neo-lexicographic Ordering
 * https://atcoder.jp/contests/abc219/tasks/abc219_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/33399361
 *
 * note:
 * ソートをラムダ式で実装しようとしたが、Comparatorの方が早いようだ
 */

package contests.abc.abc21x.abc219.abc219_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String x = br.readLine();
    final int n = Integer.parseInt(br.readLine());
    final String[] array_s = new String[n];
    for (int i = 0; i < n; i++) {
      array_s[i] = br.readLine();
    }
    br.close();
    Arrays.sort(array_s, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
          if (o1.charAt(i) != o2.charAt(i)) {
            return Integer.compare(x.indexOf(o1.charAt(i)), x.indexOf(o2.charAt(i)));
          }
        }
        return Integer.compare(o1.length(), o2.length());
      }
    });
    PrintWriter pw = new PrintWriter(System.out);
    for (String s : array_s) {
      pw.println(s);
    }
    pw.close();
  }
}
