/*
 * AtCoder Beginner Contest 254
 * D - Together Square
 * https://atcoder.jp/contests/abc254/tasks/abc254_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc254/submissions/38360017
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc254.abc254_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    //N以下の平方数リストを作成
    final List<Integer> sq_list = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      sq_list.add(i * i);
    }
    long ans = 0;
    for (int i = 1; i <= n; i++) {
      int f_i = i;
      //f(i)=平方数で割れるだけ割った数
      for (int x = 2; x * x <= n; x++) {
        int sq = x * x;
        if (f_i < sq) {
          break;
        } else {
          while (f_i % sq == 0) {
            f_i /= sq;
          }
        }
      }
      //N / f(i)以下の平方数の数を求める
      int b = Collections.binarySearch(sq_list, n / f_i);
      if (b < 0) {
        b = ~b;
        ans += b;
      } else {
        ans += b + 1;
      }
    }
    System.out.println(ans);
  }
}
