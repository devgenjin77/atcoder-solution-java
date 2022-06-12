/*
 * AtCoder Beginner Contest 215
 * D - Coprime 2
 * https://atcoder.jp/contests/abc215/tasks/abc215_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32432509
 *
 */

package contests.abc.abc21x.abc215.abc215_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  final static int MAX = 100_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();

    final boolean[] isCoprime = new boolean[MAX + 1];
    Arrays.fill(isCoprime, true);
    for (int i = 0; i < n; i++) {
      int a = array_a[i];
      if (a == 1) {
        continue;
      }
      isCoprime[a] = false;
      for (int div = 2; div * div <= a; div++) {
        if (a % div == 0) {
          isCoprime[div] = false;
          isCoprime[a / div] = false;
        }
      }
    }
    for (int i = 2; i <= m / 2; i++) {
      if (!isCoprime[i]) {
        for (int multiple = i * 2; multiple <= m; multiple += i) {
          isCoprime[multiple] = false;
        }
      }
    }
    final List<Integer> list_ans = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      if (isCoprime[i]) {
        list_ans.add(i);
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    pw.println(list_ans.size());
    for (int ans : list_ans) {
      pw.println(ans);
    }
    pw.close();
  }
}
