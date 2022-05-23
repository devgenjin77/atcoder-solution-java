/*
 * 競プロ典型90問
 * 024 - Select +／- One（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_x
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31922616
 *
 * note:
 * - パリティ（偶奇性）を考える
 *
 */

package contests.typical90.typical90_03.typical90_024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    br.close();
    long total_diff = 0;
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(st_a.nextToken());
      long b = Long.parseLong(st_b.nextToken());
      total_diff += Math.abs(a - b);
    }
    if (k >= total_diff && (k - total_diff) % 2 == 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
