/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * A - Jogging
 * https://atcoder.jp/contests/abc249/tasks/abc249_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/34093226
 *
 * note:
 *
 *
 */

package contests.abc.abc24x.abc249.abc249_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    final int d = Integer.parseInt(st.nextToken());
    final int e = Integer.parseInt(st.nextToken());
    final int f = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    br.close();
    int dist1 = distance(a, b, c, x);
    int dist2 = distance(d, e, f, x);
    PrintWriter pw = new PrintWriter(System.out);
    if (dist1 > dist2) {
      pw.println("Takahashi");
    } else if (dist1 < dist2) {
      pw.println("Aoki");
    } else {
      pw.println("Draw");
    }
    pw.close();
  }

  static int distance(int a, int b, int c, int x) {
    int dist = (a * b) * (x / (a + c));
    dist += b * Math.min(a, x % (a + c));
    return dist;
  }
}
