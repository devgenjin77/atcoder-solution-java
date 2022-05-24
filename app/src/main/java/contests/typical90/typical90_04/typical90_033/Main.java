/*
 * 競プロ典型90問
 * 033 - Not Too Bright（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ag
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31928485
 *
 * note:
 * - コーナーケースに気を付ける
 *
 */

package contests.typical90.typical90_04.typical90_033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    br.close();
    int ans = 0;
    if (h == 1 || w == 1) {
      ans = h * w;
    } else {
      ans = ((h + 1) / 2) * ((w + 1) / 2);
    }
    System.out.println(ans);
  }
}
