/*
 * ABC215
 * B - log2(N)
 * https://atcoder.jp/contests/abc215/tasks/abc215_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/25374993
 */
package contests.abc.abc215.abc215_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(solve2(n));
  }
  // 全探索での解法
  static int solve(long n){
    long value = 1;
    int k = 0;
    while(value <= n){
      value *= 2;
      k++;
    }
    return k - 1;
  }

  // 整数のbit表現を使った解法
  static int solve2(long n){
    return Long.toBinaryString(n).length() - 1;
  }
}