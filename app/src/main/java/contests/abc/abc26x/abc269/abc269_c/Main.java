/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * C - Submask
 * https://atcoder.jp/contests/abc269/tasks/abc269_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/34971922
 *
 */

package contests.abc.abc26x.abc269.abc269_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    List<Integer> list_bit = new ArrayList<>();
    for (int b = 0; b < 60; b++) {
      if (((n >> b) & 1) == 1) {
        list_bit.add(b);
      }
    }
    List<Long> list_ans = new ArrayList<>();
    for (int bit = 0; bit < (1 << list_bit.size()); bit++) {
      long tmp = 0;
      for (int digit = 0; digit < list_bit.size(); digit++) {
        if (((bit >> digit) & 1) == 1) {
          tmp += 1L << list_bit.get(digit);
        }
      }
      list_ans.add(tmp);
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (long ans : list_ans) {
      pw.println(ans);
    }
    pw.close();
  }
}
