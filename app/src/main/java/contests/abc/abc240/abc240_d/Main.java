/*
 * ABC240
 * D - Strange Balls
 * https://atcoder.jp/contests/abc240/tasks/abc240_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29643580
 *
 */
package contests.abc.abc240.abc240_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    Stack<Pair> cylinder = new Stack<>();
    int n_count = 0;
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      n_count += 1;
      if (cylinder.isEmpty() || cylinder.peek().num != array_a[i]) {
        cylinder.push(new Pair(array_a[i], 1));
      } else {
        if (cylinder.peek().count + 1 == array_a[i]) {
          cylinder.pop();
          n_count = n_count - array_a[i];
        } else {
          cylinder.peek().count += 1;
        }
      }
      pw.println(n_count);
    }
    pw.close();
  }

  static class Pair {

    int num, count;

    Pair(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }
}
