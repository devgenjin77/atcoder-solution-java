/*
 * ABC241
 * B - Pasta
 * https://atcoder.jp/contests/abc241/tasks/abc241_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29732574
 *
 */
package contests.abc.abc241.abc241_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int m = Integer.parseInt(head[1]);
    Map<Integer, Integer> pasta_stock = new HashMap<>();
    StringTokenizer st_input_a = new StringTokenizer(br.readLine());
    while (st_input_a.hasMoreTokens()) {
      int a = Integer.parseInt(st_input_a.nextToken());
      pasta_stock.put(a, pasta_stock.getOrDefault(a, 0) + 1);
    }
    StringTokenizer st_input_b = new StringTokenizer(br.readLine());
    boolean bOk = true;
    while (st_input_b.hasMoreTokens()) {
      int b = Integer.parseInt(st_input_b.nextToken());
      int stock = pasta_stock.getOrDefault(b, -1);
      if (stock > 0) {
        pasta_stock.put(b, stock - 1);
      } else {
        bOk = false;
        break;
      }
    }
    System.out.println(bOk ? "Yes" : "No");
  }
}
