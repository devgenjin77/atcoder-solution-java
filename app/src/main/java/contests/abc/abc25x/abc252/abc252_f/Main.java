/*
 * AtCoder Beginner Contest 252
 * F - Bread
 * https://atcoder.jp/contests/abc252/tasks/abc252_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38138103
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long l = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    final PriorityQueue<Long> queue_asc = new PriorityQueue<>();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += array_a[i];
      queue_asc.add(array_a[i]);
    }
    if (l > sum) {
      queue_asc.add(l - sum);
    }
    long ans = 0;
    while (true) {
      long a = queue_asc.poll();
      long b = queue_asc.poll();
      ans += a + b;
      if (queue_asc.isEmpty()) {
        break;
      } else {
        queue_asc.add(a + b);
      }
    }
    System.out.println(ans);
  }
}
