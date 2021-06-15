/*
 * ABC205
 * C - POW
 * https://atcoder.jp/contests/abc205/tasks/abc205_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/23498448
 */
package contests.abc.abc205.abc205_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    System.out.println(solve(a, b, c));
  }

  static String solve(int a, int b, int c) {
    if (a == b) {
      return "=";
    }
    int abs_a = Math.abs(a);
    int abs_b = Math.abs(b);
    if(c % 2 == 0){
      if(abs_a == abs_b) {
        return "=";
      } else {
        return abs_a > abs_b ? ">" : "<";
      }
    } else {
      return a > b ? ">" : "<";
    }
  }
}
