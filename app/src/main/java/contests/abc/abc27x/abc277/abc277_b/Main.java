/*
 * 大和証券プログラミングコンテスト2022 Autumn
 * （AtCoder Beginner Contest 277）
 * B - Playing Cards Validation
 * https://atcoder.jp/contests/abc277/tasks/abc277_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc277/submissions/36464829
 *
 */

package contests.abc.abc27x.abc277.abc277_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  private static final String SUIT = "HDCS";

  private static final String NUMBER = "A23456789TJQK";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final HashSet<String> cards = new HashSet<>();
    boolean isOK = true;
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (SUIT.indexOf(s.charAt(0)) < 0 || NUMBER.indexOf(s.charAt(1)) < 0 || !cards.add(s)) {
        isOK = false;
        break;
      }
    }
    br.close();
    System.out.println(isOK ? "Yes" : "No");
  }
}
