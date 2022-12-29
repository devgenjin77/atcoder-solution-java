/*
 * 日鉄ソリューションズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 257）
 * E - Addition and Multiplication 2
 * https://atcoder.jp/contests/abc257/tasks/abc257_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc257/submissions/37617931
 *
 * note:
 * 最初に最大の桁数を求めておく。
 * あとは、その桁数が達成できるように1-9を決めていく
 */

package contests.abc.abc25x.abc257.abc257_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final int[] cost = new int[9];
    int min_c = n;
    for (int i = 0; i < 9; i++) {
      cost[i] = Integer.parseInt(st_c.nextToken());
      min_c = Math.min(cost[i], min_c);
    }
    br.close();
    int digit_max = n / min_c;
    int remain = n;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digit_max; i++) {
      for (int j = 9; j > 0; j--) {
        if (remain >= cost[j - 1] && (remain - cost[j - 1]) / min_c >= (digit_max - i - 1)) {
          sb.append(j);
          remain -= cost[j - 1];
          break;
        }
      }
    }
    System.out.println(sb);
  }
}
