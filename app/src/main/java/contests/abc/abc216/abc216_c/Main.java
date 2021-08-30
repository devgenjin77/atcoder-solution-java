/*
 * ABC216
 * C - Many Balls
 * https://atcoder.jp/contests/abc216/tasks/abc216_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/25470396
 */
package contests.abc.abc216.abc216_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(solve(n));
  }

  static String solve(long n){
    long val = n;
    StringBuilder sb = new StringBuilder();
    while(val > 0){
      if(val % 2 == 0){
        sb.append('B');
        val /= 2;
      } else {
        sb.append('A');
        val -= 1;
      }
    }
    return sb.reverse().toString();
  }
}