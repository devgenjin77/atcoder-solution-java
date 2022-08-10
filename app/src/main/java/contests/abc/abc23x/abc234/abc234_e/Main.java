/*
 * AtCoder Beginner Contest 234
 * E - Arithmetic Number
 * https://atcoder.jp/contests/abc234/tasks/abc234_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc234/submissions/33916805
 *
 * note:
 * 等差数の候補を全部生成してソートしてから二分探索
 */

package contests.abc.abc23x.abc234.abc234_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long x = Long.parseLong(br.readLine());
    br.close();
    //等差数を格納するリスト
    List<Long> list_arith = new ArrayList<>();
    //等差数の候補を全て生成する
    for (int d = 1; d <= 9; d++) {
      for (int diff = -9; diff <= 9; diff++) {
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        list_arith.add(Long.parseLong(sb.toString()));
        int now = d;
        while (sb.length() < 18) {
          now += diff;
          if (0 <= now && now <= 9) {
            sb.append(now);
            list_arith.add(Long.parseLong(sb.toString()));
          } else {
            break;
          }
        }
      }
    }
    Collections.sort(list_arith);
    int idx = Collections.binarySearch(list_arith, x);
    if (idx < 0) {
      idx = ~idx;
    }
    System.out.println(list_arith.get(idx));
  }
}
