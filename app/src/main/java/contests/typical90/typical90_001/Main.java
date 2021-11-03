/*
 * 競プロ典型90問
 * 001 - Yokan Party（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_a
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27002392
 *
 */
package contests.typical90.typical90_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nl = br.readLine().split(" ");
    int n = Integer.parseInt(nl[0]);
    int l = Integer.parseInt(nl[1]);
    int k = Integer.parseInt(br.readLine());
    int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();

    int left = 0;
    int right = (l / (k + 1)) + 1;
    while (right - left > 1) {
      int mid = (left + right) / 2;
      if (canDivideWith(l, mid, k, array)) {
        left = mid;
      } else {
        right = mid;
      }
    }
    System.out.println(left);
  }

  static boolean canDivideWith(int l, int s, int k, int[] array) {
    int left_len = 0;
    int div_cnt = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] - left_len >= s && l - array[i] >= s) {
        left_len = array[i];
        div_cnt += 1;
        if (div_cnt >= k) {
          return true;
        }
      }
    }
    return false;
  }
}
