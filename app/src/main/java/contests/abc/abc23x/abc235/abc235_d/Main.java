/*
 * HHKB プログラミングコンテスト 2022
 * （AtCoder Beginner Contest 235）
 * D - Multiply and Rotate
 * https://atcoder.jp/contests/abc235/tasks/abc235_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/33920566
 *
 * note:
 * 逆操作をシミュレーションする
 *
 */

package contests.abc.abc23x.abc235.abc235_d;

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
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int n = Integer.parseInt(st.nextToken());
    br.close();
    final Map<Integer, Integer> memo = new HashMap<>();
    final Queue<Integer> queue = new ArrayDeque<>();
    memo.put(n, 0);
    queue.add(n);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      int cnt = memo.get(cur);
      //Multiplyの逆操作
      if (cur % a == 0) {
        int diva = cur / a;
        if (memo.getOrDefault(diva, Integer.MAX_VALUE) > cnt + 1) {
          memo.put(diva, cnt + 1);
          queue.add(diva);
        }
      }
      //Rotateの逆操作
      StringBuilder sb_cur = new StringBuilder(String.valueOf(cur));
      if (sb_cur.length() > 1 && sb_cur.charAt(1) != '0') {
        sb_cur.append(sb_cur.charAt(0));
        sb_cur.deleteCharAt(0);
        cur = Integer.parseInt(sb_cur.toString());
        if (memo.getOrDefault(cur, Integer.MAX_VALUE) > cnt + 1) {
          memo.put(cur, cnt + 1);
          queue.add(cur);
        }
      }
    }
    System.out.println(memo.getOrDefault(1, -1));
  }
}
