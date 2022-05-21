/*
 * 競プロ典型90問
 * 002 - Encyclopedia of Parentheses（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_b
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31823382
 *
 * note:
 * bit全探索でカッコ列を列挙し、正しいカッコ列か判定する。
 */

package contests.typical90.typical90_00x.typical90_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    if (n % 2 == 0) {
      PrintWriter pw = new PrintWriter(System.out);
      for (int bit = (1 << (n / 2)) - 1; bit < 1 << n; bit++) {
        if (isCorrect(bit, n)) {
          pw.println(convertParenthesisSequences(bit, n));
        }
      }
      pw.close();
    }
  }

  static boolean isCorrect(int bit, int n) {
    //正しいカッコ列か判断する
    boolean correct = true;
    int cnt_0 = 0, cnt_1 = 0;
    for (int r = n - 1; r >= 0; r--) {
      if (((bit >> r) & 1) == 1) {
        cnt_1++;
      } else {
        cnt_0++;
      }
      if (cnt_0 < cnt_1) {
        correct = false;
        break;
      }
    }
    if (cnt_0 != cnt_1) {
      correct = false;
    }
    return correct;
  }

  static String convertParenthesisSequences(int bit, int n) {
    //カッコ列を構成
    StringBuilder sb = new StringBuilder(n);
    for (int r = n - 1; r >= 0; r--) {
      if (((bit >> r) & 1) == 1) {
        sb.append(')');
      } else {
        sb.append('(');
      }
    }
    return sb.toString();
  }
}
