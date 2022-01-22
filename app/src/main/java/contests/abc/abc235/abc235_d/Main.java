/*
 * ABC235
 * D - Multiply and Rotate
 * https://atcoder.jp/contests/abc235/tasks/abc235_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/28677317
 *
 */
package contests.abc.abc235.abc235_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int a = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int dig_n = String.valueOf(n).length();
    Map<Integer, Integer> memo = new HashMap<>();
    Queue<Integer> queue = new ArrayDeque<>();
    memo.put(1, 0);
    queue.add(1);
    while (!queue.isEmpty()) {
      int x = queue.poll();
      if (x == n) {
        continue;
      }
      int cnt = memo.get(x);
      //a倍
      int x1 = a * x;
      if (String.valueOf(x1).length() <= dig_n) {
        if (!(memo.containsKey(x1) && memo.get(x1) <= cnt + 1)) {
          memo.put(x1, memo.get(x) + 1);
          queue.add(x1);
        }
      }

      //後ろの文字を前にもってく
      if (x > 9 && x % 10 != 0) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.insert(0, sb.charAt(sb.length() - 1));
        sb.deleteCharAt(sb.length() - 1);
        int x2 = Integer.parseInt(sb.toString());
        if (!(memo.containsKey(x2) && memo.get(x2) <= cnt + 1)) {
          memo.put(x2, memo.get(x) + 1);
          queue.add(x2);
        }
      }
    }
    System.out.println(memo.getOrDefault(n, -1));
    return;
  }
}
