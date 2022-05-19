/*
 * ABC213
 * B - Booby Prize
 * https://atcoder.jp/contests/abc213/tasks/abc213_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31798987
 */

package contests.abc.abc21x.abc213.abc213_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int score_worst = 0, score_booby = 0;
    int player_worst = 0, player_booby = 0;
    for (int idx = 1; idx <= n; idx++) {
      int a = Integer.parseInt(st.nextToken());
      if (a > score_worst) {
        score_booby = score_worst;
        player_booby = player_worst;
        score_worst = a;
        player_worst = idx;
      } else if (a > score_booby) {
        score_booby = a;
        player_booby = idx;
      }
    }
    System.out.println(player_booby);
  }
}
