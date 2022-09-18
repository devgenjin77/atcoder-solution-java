/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * A - Anyway Takahashi
 * https://atcoder.jp/contests/abc269/tasks/abc269_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/34971572
 *
 */

package contests.abc.abc26x.abc269.abc269_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    br.close();
    PrintWriter pw = new PrintWriter(System.out);
    pw.println((a + b) * (c - d));
    pw.println("Takahashi");
    pw.close();
  }
}
