/*
 * AtCoder Beginner Contest 221
 * C - Select Mul
 * https://atcoder.jp/contests/abc221/tasks/abc221_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/33239889
 *
 * note:
 * 9から始めて、小さい方の数字に追記する
 */

package contests.abc.abc22x.abc221.abc221_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String n = br.readLine();
    br.close();
    int[] n_digit = new int[10];
    // どの数字が何個あるかを集計
    for (int i = 0; i < n.length(); i++) {
      n_digit[(n.charAt(i) - '0')]++;
    }
    long n1 = 0, n2 = 0;
    for (int i = 9; i >= 0; i--) {
      // 9から始めて、小さい数字の方の末尾に追加する
      while (n_digit[i] > 0) {
        n_digit[i]--;
        if (n2 > n1) {
          n1 = (n1 * 10) + i;
        } else {
          n2 = (n2 * 10) + i;
        }
      }
    }
    System.out.println(n1 * n2);
  }
}
