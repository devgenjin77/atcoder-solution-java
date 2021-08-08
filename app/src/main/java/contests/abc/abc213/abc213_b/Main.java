/*
 * ABC213
 * B - Booby Prize
 * https://atcoder.jp/contests/abc213/tasks/abc213_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/24899433
 */
package contests.abc.abc213.abc213_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] array_a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();

    int score_worst = Integer.max(array_a[0], array_a[1]);
    int score_booby = Integer.min(array_a[0], array_a[1]);
    int player_booby = array_a[0] < array_a[1] ? 0 : 1;
    int player_worst = 1 - player_booby;
    for(int i = 2; i < n; i++){
      if(array_a[i] > score_worst){
        score_worst = array_a[i];
        player_booby = player_worst;
        player_worst = i;
      } else if(array_a[i] > score_booby){
        score_booby = array_a[i];
        player_booby = i;
      }
    }
    System.out.println(player_booby + 1);
  }
}
