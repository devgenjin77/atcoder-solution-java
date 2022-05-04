/*
 * ABC215
 * D - Coprime 2
 * https://atcoder.jp/contests/abc215/tasks/abc215_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/31441075
 */

package contests.abc.abc215.abc215_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static final int MAX_A = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(head.nextToken());
    int m = Integer.parseInt(head.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();

    boolean[] isCoprime = new boolean[MAX_A + 1];
    Arrays.fill(isCoprime, true);
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st_a.nextToken());
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
    for (int i = 2; i <= MAX_A / 2; i++) {
      if (!isCoprime[i]) {
        for (int j = i * 2; j <= MAX_A; j += i) {
          isCoprime[j] = false;
        }
      }
    }
    List<Integer> list_ans = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      if (isCoprime[i]) {
        list_ans.add(i);
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(list_ans.size());
    for (int ans : list_ans) {
      pw.println(ans);
    }
    pw.close();
  }
}