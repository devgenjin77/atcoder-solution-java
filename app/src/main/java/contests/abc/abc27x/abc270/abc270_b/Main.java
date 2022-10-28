/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * B - Hammer
 * https://atcoder.jp/contests/abc270/tasks/abc270_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/36020710
 *
 */

package contests.abc.abc27x.abc270.abc270_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int x = Integer.parseInt(st.nextToken());
    final int y = Integer.parseInt(st.nextToken());
    final int z = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(solve(x, y, z));
  }

  static int solve(int x, int y, int z) {
    if (x < 0) {
      x = -x;
      y = -y;
      z = -z;
    }
    if (y > x || y < 0) {
      //ゴールまでに壁がない
      return x;
    } else {
      //ゴールまでに壁がある
      if (z > y) {
        return -1;
      } else {
        return z > 0 ? x : (Math.abs(z) * 2) + x;
      }
    }
  }
}
