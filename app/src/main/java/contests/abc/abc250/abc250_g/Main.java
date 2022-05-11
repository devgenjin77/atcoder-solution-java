/*
 * ABC250
 * G - Stonks
 * https://atcoder.jp/contests/abc250/tasks/abc250_g
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31608454
 *
 */

package contests.abc.abc250.abc250_g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer p = new StringTokenizer(br.readLine());
    br.close();
    Queue<Long> pq_stock_price = new PriorityQueue<>();
    pq_stock_price.add(Long.parseLong(p.nextToken()));
    long ans = 0;
    while (p.hasMoreElements()) {
      long price = Long.parseLong(p.nextToken());
      if (price > pq_stock_price.peek()) {
        ans += price - pq_stock_price.poll();
        pq_stock_price.add(price);
      }
      pq_stock_price.add(price);
    }
    System.out.println(ans);
  }
}
