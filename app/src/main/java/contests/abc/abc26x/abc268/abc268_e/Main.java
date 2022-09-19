/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * E - Chinese Restaurant (Three-Star Version)
 * https://atcoder.jp/contests/abc268/tasks/abc268_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/35001709
 *
 * note:
 * - いもす法の要領で、適切に差分を計算する。
 *
 */

package contests.abc.abc26x.abc268.abc268_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    final int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(st_p.nextToken());
    }
    br.close();

    long ans = 0;
    final int[] diff = new int[n];
    int delta = 0;
    //初期状態の不満度を計算
    for (int i = 0; i < n; i++) {
      //i=p_i時点から何回移動したか
      int cnt = (n + i - array_p[i]) % n;
      ans += Math.min(cnt, n - cnt);
      if (cnt < (n / 2)) {
        delta++;
      }
      if (cnt >= n - (n / 2)) {
        delta--;
      }
      //その操作回数の次から、不満度の差分はマイナス→プラスに転換される
      //プラスからマイナスに転換するタイミングは、n/2回時計回り（または反時計回り）に回った次のタイミング
      int dist_to_0 = (n - cnt) % n;
      diff[dist_to_0 % n] += 2;
      diff[(dist_to_0 + (n / 2)) % n] -= 1;
      diff[(n + dist_to_0 - (n / 2)) % n] -= 1;
    }
    long tmp = ans;
    for (int i = 0; i < n; i++) {
      tmp += delta;
      ans = Math.min(tmp, ans);
      delta += diff[(i + 1) % n];
    }
    System.out.println(ans);
  }
}
