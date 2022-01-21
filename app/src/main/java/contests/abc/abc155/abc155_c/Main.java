/*
 * ABC155
 * C - Poll
 * https://atcoder.jp/contests/abc155/tasks/abc155_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc155/submissions/28665114
 *
 */
package contests.abc.abc155.abc155_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max_cnt = 0;
    TreeMap<String, Integer> vote_map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      int n_cnt = vote_map.getOrDefault(s, 0) + 1;
      vote_map.put(s, n_cnt);
      max_cnt = Math.max(n_cnt, max_cnt);
    }
    br.close();
    PrintWriter pw = new PrintWriter(System.out);
    for (String name : vote_map.keySet()) {
      if (vote_map.get(name) == max_cnt) {
        pw.println(name);
      }
    }
    pw.close();
    return;
  }
}
