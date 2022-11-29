/*
 * 競プロ典型90問
 * 086 - Snuke's Favorite Arrays（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ch
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/36881693
 *
 * note:
 * - bit全探索
 *
 */

package contests.typical90.typical90_09.typical90_086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int q = Integer.parseInt(st.nextToken());
    final int[] array_x = new int[q];
    final int[] array_y = new int[q];
    final int[] array_z = new int[q];
    final long[] array_w = new long[q];
    for (int i = 0; i < q; i++) {
      StringTokenizer st_q = new StringTokenizer(br.readLine());
      array_x[i] = Integer.parseInt(st_q.nextToken()) - 1;
      array_y[i] = Integer.parseInt(st_q.nextToken()) - 1;
      array_z[i] = Integer.parseInt(st_q.nextToken()) - 1;
      array_w[i] = Long.parseLong(st_q.nextToken());
    }
    br.close();
    final long[] patterns = new long[60];
    for (int i = 0; i < 60; i++) {
      for (int bit = 0; bit < (1 << n); bit++) {
        boolean isOK = true;
        for (int j = 0; j < q; j++) {
          int bit_or =
              ((bit >> array_x[j]) & 1) | ((bit >> array_y[j]) & 1) | ((bit >> array_z[j]) & 1);
          if (bit_or != ((array_w[j] >> i) & 1)) {
            isOK = false;
            break;
          }
        }
        if (isOK) {
          patterns[i]++;
        }
      }
    }
    long ans = 1;
    for (int i = 0; i < 60; i++) {
      ans = (ans * patterns[i]) % MOD;
    }
    System.out.println(ans);
  }
}
