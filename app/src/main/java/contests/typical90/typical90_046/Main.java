/*
 * 競プロ典型90問
 * 046 - I Love 46（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_at
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28340836
 *
 */
package contests.typical90.typical90_046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] arrays_mod46 = new long[3][46];
    for (int i = 0; i < 3; i++) {
      String[] input_array = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int input_mod46 = Integer.parseInt(input_array[j]) % 46;
        arrays_mod46[i][input_mod46] += 1;
      }
    }
    br.close();

    long ans = 0;
    for (int a = 0; a < 46; a++) {
      for (int b = 0; b < 46; b++) {
        int c = ((46 * 2) - a - b) % 46;
        long tmp = arrays_mod46[0][a] * arrays_mod46[1][b] * arrays_mod46[2][c];
        ans += tmp;
      }
    }
    System.out.println(ans);
    return;
  }
}
