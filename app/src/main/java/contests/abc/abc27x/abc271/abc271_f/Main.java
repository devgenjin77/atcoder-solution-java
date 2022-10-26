/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * F - XOR on Grid Path
 * https://atcoder.jp/contests/abc271/tasks/abc271_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35981647
 *
 */

package contests.abc.abc27x.abc271.abc271_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[][] mtx_a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        mtx_a[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    br.close();
    //[0,0]->[x,x]の経路を通ったときのXOR
    List<Map<Integer, Long>> list_xor1 = new ArrayList<>();
    //[n-1,n-1]->[x,x]の経路を通ったときのXOR
    List<Map<Integer, Long>> list_xor2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_xor1.add(new HashMap<>());
      list_xor2.add(new HashMap<>());
    }
    dfs1(0, 0, 0, n, mtx_a, list_xor1);
    dfs2(0, n - 1, n - 1, n, mtx_a, list_xor2);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      Map<Integer, Long> map_xor1 = list_xor1.get(i);
      Map<Integer, Long> map_xor2 = list_xor2.get(i);
      for (int xor1 : map_xor1.keySet()) {
        ans += map_xor1.get(xor1) * map_xor2.getOrDefault(xor1 ^ mtx_a[i][n - 1 - i], 0L);
      }
    }
    System.out.println(ans);
  }

  static void dfs1(int a, int i, int j, int n, int[][] mtx_a, List<Map<Integer, Long>> list_xor1) {
    int xor_a = a ^ mtx_a[i][j];
    if (i + j == n - 1) {
      list_xor1.get(i).put(xor_a, list_xor1.get(i).getOrDefault(xor_a, 0L) + 1L);
    } else {
      dfs1(xor_a, i + 1, j, n, mtx_a, list_xor1);
      dfs1(xor_a, i, j + 1, n, mtx_a, list_xor1);
    }
  }

  static void dfs2(int a, int i, int j, int n, int[][] mtx_a, List<Map<Integer, Long>> list_xor2) {
    int xor_a = a ^ mtx_a[i][j];
    if (i + j == n - 1) {
      list_xor2.get(i).put(xor_a, list_xor2.get(i).getOrDefault(xor_a, 0L) + 1L);
    } else {
      dfs2(xor_a, i - 1, j, n, mtx_a, list_xor2);
      dfs2(xor_a, i, j - 1, n, mtx_a, list_xor2);
    }
  }
}
