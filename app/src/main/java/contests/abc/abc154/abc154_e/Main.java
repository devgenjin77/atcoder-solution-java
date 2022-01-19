/*
 * ABC154
 * E - Almost Everywhere Zero
 * https://atcoder.jp/contests/abc154/tasks/abc154_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28639058
 *
 */
package contests.abc.abc154.abc154_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    int k = Integer.parseInt(br.readLine());
    br.close();
    long[] pow9 = new long[k + 1];
    pow9[0] = 1;
    for (int a = 1; a <= k; a++) {
      pow9[a] = pow9[a - 1] * 9;
    }
    // 最大値Nに含まれる0以外の桁の数
    int ne0 = 0;
    int nlen = n.length();
    long ans = 0;
    for (int i = 0; i < nlen; i++) {
      int d = n.charAt(i) - '0';
      if (d == 0) {
        continue;
      }
      //i桁目を0設定した場合の数
      ans += nCr(nlen - i - 1, k - ne0) * pow9[k - ne0];
      //i桁目を0以外を設定した場合の数
      ans += (d - 1) * nCr(nlen - i - 1, k - ne0 - 1) * pow9[k - ne0 - 1];
      ne0 += 1;
      if (ne0 == k) {
        ans += d;
        break;
      }
    }
    System.out.println(ans);
    return;
  }

  static int nCr(int n, int r) {
    if (r < 1) {
      return 0;
    }
    int ans = 1;
    for (int i = 0; i < r; i++) {
      ans *= (n - i);
    }
    for (int f = r; f > 1; f--) {
      ans /= f;
    }
    return ans;
  }
}
