/*
 * LINE Verda プログラミングコンテスト
 * （AtCoder Beginner Contest 263）
 * A - Full House
 * https://atcoder.jp/contests/abc263/tasks/abc263_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc263/submissions/35940247
 *
 */

package contests.abc.abc26x.abc263.abc263_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int[] cards = new int[5];
    for (int i = 0; i < 5; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    Arrays.sort(cards);
    if (cards[0] == cards[1] && cards[3] == cards[4]
        && (cards[1] == cards[2] || cards[2] == cards[3])) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
