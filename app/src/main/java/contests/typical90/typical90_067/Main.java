/*
 * 競プロ典型90問
 * 067 - Base 8 to 9（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bo
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28377563
 *
 */
package contests.typical90.typical90_067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer input = new StringTokenizer(br.readLine());
    br.close();
    String n = input.nextToken();
    int k = Integer.parseInt(input.nextToken());
    String ans = n;
    while (k-- > 0) {
      StringBuilder sb = new StringBuilder(Long.toString(Long.parseUnsignedLong(ans, 8), 9));
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '8') {
          sb.setCharAt(i, '5');
        }
      }
      ans = sb.toString();
    }
    System.out.println(ans);
    return;
  }
}
