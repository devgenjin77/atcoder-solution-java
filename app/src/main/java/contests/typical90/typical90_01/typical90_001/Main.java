/*
 * 競プロ典型90問
 * 001 - Yokan Party（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_a
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31822061
 *
 * note:
 * 解を二分探索で求める
 */

package contests.typical90.typical90_01.typical90_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());
    int[] array_a = new int[n];
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();

    int ok = 1, ng = l;
    while (ng - ok > 1) {
      int mid = (ng + ok) / 2;
      boolean result = false;
      //スコアをmid以上にできるか判定する
      int cnt = 0, left = 0, score = l;
      for (int i = 0; i < n; i++) {
        if (array_a[i] - left >= mid) {
          score = Math.min(array_a[i], score);
          left = array_a[i];
          cnt++;
          if (cnt == k) {
            score = Math.min(l - array_a[i], score);
            break;
          }
        }
      }
      if (cnt == k && score >= mid) {
        //切った回数がk且つスコアがmid以上なので達成できた
        ok = mid;
      } else {
        //できなかった
        ng = mid;
      }
    }
    System.out.println(ok);
  }
}
