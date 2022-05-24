/*
 * 競プロ典型90問
 * 055 - Select 5（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bc
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31934318
 *
 * note:
 * -定数倍を見積もる
 * -全探索で間に合う
 *
 */

package contests.typical90.typical90_06.typical90_055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long p = Long.parseLong(st.nextToken());
    long q = Long.parseLong(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();

    int ans = 0;
    for (int i1 = 0; i1 < n - 4; i1++) {
      long ans_sub1 = array_a[i1];
      for (int i2 = i1 + 1; i2 < n - 3; i2++) {
        long ans_sub2 = ans_sub1 * array_a[i2] % p;
        for (int i3 = i2 + 1; i3 < n - 2; i3++) {
          long ans_sub3 = ans_sub2 * array_a[i3] % p;
          for (int i4 = i3 + 1; i4 < n - 1; i4++) {
            long ans_sub4 = ans_sub3 * array_a[i4] % p;
            for (int i5 = i4 + 1; i5 < n; i5++) {
              if (ans_sub4 * array_a[i5] % p == q) {
                ans++;
              }
            }
          }
        }
      }
    }
    System.out.println(ans);
  }
}
