/*
 * 競プロ典型90問
 * 067 - Base 8 to 9（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bo
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31938467
 *
 * note:
 * -N進法展開を行う
 *
 */

package contests.typical90.typical90_07.typical90_067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long n = Long.parseLong(st.nextToken(), 8);
    int k = Integer.parseInt(st.nextToken());
    br.close();
    long ans = n;
    for (int i = 0; i < k; i++) {
      ans = calc(ans);
    }
    System.out.println(Long.toString(ans, 8));
  }

  static long calc(long num) {
    //整数を 9 進法に直し、8を5に書き直す
    StringBuilder sb = new StringBuilder(Long.toString(num, 9));
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '8') {
        sb.setCharAt(i, '5');
      }
    }
    return Long.parseLong(sb.toString(), 8);
  }
}
