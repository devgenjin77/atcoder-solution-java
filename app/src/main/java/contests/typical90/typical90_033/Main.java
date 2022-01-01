/*
 * 競プロ典型90問
 * 033 - Not Too Bright（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ag
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28282715
 *
 */
package contests.typical90.typical90_033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hw = br.readLine().split(" ");
    br.close();
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    int ans = (h == 1 || w == 1) ? h * w : ((h + 1) / 2) * ((w + 1) / 2);
    System.out.println(ans);
    return;
  }
}
