/*
 * ABC250
 * C - Adjacent Swaps
 * https://atcoder.jp/contests/abc250/tasks/abc250_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31572786
 *
 */

package contests.abc.abc250.abc250_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] pos_to_val = new int[n];
    int[] val_to_pos = new int[n];
    for (int i = 0; i < n; i++) {
      pos_to_val[i] = i;
      val_to_pos[i] = i;
    }
    for (int i = 0; i < q; i++) {
      int val_f = Integer.parseInt(br.readLine()) - 1;
      int pos_f = val_to_pos[val_f];
      int pos_t = pos_f + 1 == n ? pos_f - 1 : pos_f + 1;
      int val_t = pos_to_val[pos_t];

      pos_to_val[pos_f] = val_t;
      pos_to_val[pos_t] = val_f;
      val_to_pos[val_f] = pos_t;
      val_to_pos[val_t] = pos_f;
    }
    br.close();
    StringBuilder sb = new StringBuilder();
    for (int v : pos_to_val) {
      sb.append(v + 1).append(" ");
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}
