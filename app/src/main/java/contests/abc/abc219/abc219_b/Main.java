/*
 * サイシードプログラミングコンテスト2021（AtCoder Beginner Contest 219）
 * B - Maritozzo
 * https://atcoder.jp/contests/abc219/tasks/abc219_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/25928425
 */
package contests.abc.abc219.abc219_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = new String[3];
    for(int i = 0; i < 3; i++) {
      inputs[i] = br.readLine();
    }
    String t = br.readLine();
    br.close();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < t.length(); i++){
      int idx = t.charAt(i) - '1';
      sb.append(inputs[idx]);
    }
    System.out.println(sb);
  }
}
