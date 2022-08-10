/*
 * AtCoder Beginner Contest 234
 * D - Prefix K-th Max
 * https://atcoder.jp/contests/abc234/tasks/abc234_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc234/submissions/33914997
 *
 * note:
 *
 */

package contests.abc.abc23x.abc234.abc234_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer nk = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(nk.nextToken());
    final int k = Integer.parseInt(nk.nextToken());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    br.close();
    final PriorityQueue<Integer> p_queue = new PriorityQueue<>();
    final PrintWriter pw = new PrintWriter(System.out);
    while (st_p.hasMoreElements()) {
      int p = Integer.parseInt(st_p.nextToken());
      if (p_queue.size() < k) {
        //最初のK個を突っ込む
        p_queue.add(p);
        continue;
      }
      int kth = p_queue.peek();
      pw.println(kth);
      if (kth < p) {
        p_queue.poll();
        p_queue.add(p);
      }
    }
    pw.println(p_queue.peek());
    pw.close();
  }
}
