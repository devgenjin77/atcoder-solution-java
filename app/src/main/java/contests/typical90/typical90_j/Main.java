/*
 * 競プロ典型90問
 * 010 - Score Sum Queries（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_j
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/25633178
 *
 */
package contests.typical90.typical90_j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] score_sum_1 = new long[n + 1];
    long[] score_sum_2 = new long[n + 1];
    for(int i = 1; i <= n; i++){
      String[] data = br.readLine().split(" ");
      long score = Long.parseLong(data[1]);
      if("1".equals(data[0])){
        score_sum_1[i] = score;
      } else if("2".equals(data[0])){
        score_sum_2[i] = score;
      }
      // 累積和を計算
      score_sum_1[i] += score_sum_1[i - 1];
      score_sum_2[i] += score_sum_2[i - 1];
    }

    PrintWriter pw = new PrintWriter(System.out);
    int q = Integer.parseInt(br.readLine());
    for(int i = 0; i < q; i++){
      String[] data = br.readLine().split(" ");
      int l = Integer.parseInt(data[0]);
      int r = Integer.parseInt(data[1]);
      long sum1 = score_sum_1[r] - score_sum_1[l - 1];
      long sum2 = score_sum_2[r] - score_sum_2[l - 1];
      pw.println(String.format("%d %d", sum1, sum2));
    }
    br.close();
    pw.close();
  }
}
