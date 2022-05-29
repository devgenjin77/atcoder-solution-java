/*
 * 競プロ典型90問
 * 030 - K Factors（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ad
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32075326
 *
 * note:
 * -素因数列挙をする
 *
 */

package contests.typical90.typical90_03.typical90_030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    br.close();
    int ans = 0;
    int[] cnt_primes = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      if (cnt_primes[i] == 0) {
        for (int j = i; j <= n; j += i) {
          cnt_primes[j] += 1;
        }
      }
      if (cnt_primes[i] >= k) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
