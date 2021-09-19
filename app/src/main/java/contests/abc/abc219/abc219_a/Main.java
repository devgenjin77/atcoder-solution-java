/*
 * サイシードプログラミングコンテスト2021（AtCoder Beginner Contest 219）
 * A - AtCoder Quiz 2
 * https://atcoder.jp/contests/abc219/tasks/abc219_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/25922040
 */
package contests.abc.abc219.abc219_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    br.close();
    if(x >= 90){
      System.out.println("expert");
    } else if(x >= 70){
      System.out.println(90 - x);
    } else if(x >= 40) {
      System.out.println(70 - x);
    } else {
      System.out.println(40 - x);
    }
  }
}
