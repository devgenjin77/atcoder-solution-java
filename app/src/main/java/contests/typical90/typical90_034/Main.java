/*
 * 競プロ典型90問
 * 034 - There are few types of elements（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ah
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28339097
 *
 */
package contests.typical90.typical90_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int k = Integer.parseInt(head[1]);
    int[] array_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
    HashMap<Integer, Integer> num_map = new HashMap<>();
    num_map.put(array_a[0], 1);
    int ans = 1;
    int left_idx = 0, right_idx = 1;
    while (true) {
      if (num_map.size() > k) {
        int cnt = num_map.get(array_a[left_idx]);
        if (cnt > 1) {
          num_map.put(array_a[left_idx], cnt - 1);
        } else {
          num_map.remove(array_a[left_idx]);
        }
        left_idx++;
      } else {
        ans = Math.max(right_idx - left_idx, ans);
        if (right_idx >= n) {
          break;
        }
        num_map.put(array_a[right_idx], num_map.getOrDefault(array_a[right_idx], 0) + 1);
        right_idx++;
      }
    }
    System.out.println(ans);
    return;
  }
}
