/*
 * ABC154
 * E - Almost Everywhere Zero
 * https://atcoder.jp/contests/abc154/tasks/abc154_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28639626
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
    int[] pow9 = new int[k + 1];
    pow9[0] = 1;
    for (int a = 1; a <= k; a++) {
      pow9[a] = pow9[a - 1] * 9;
    }
    // 最大値Nに含まれる0以外の桁の数
    int cntNot0 = 0;
    int len = n.length();
    int ans = 0;
    for (int i = 0; i < len; i++) {
      int d = n.charAt(i) - '0';
      if (d == 0) {
        continue;
      }
      //i桁目を0設定した場合の数
      ans += nCr(len - i - 1, k - cntNot0) * pow9[k - cntNot0];
      //i桁目を1以上d未満で設定した場合の数
      ans += (d - 1) * nCr(len - i - 1, k - cntNot0 - 1) * pow9[k - cntNot0 - 1];
      cntNot0 += 1;
      if (cntNot0 == k) {
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
