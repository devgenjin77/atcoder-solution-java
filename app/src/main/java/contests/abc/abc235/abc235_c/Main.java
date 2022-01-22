/*
 * ABC235
 * C - The Kth Time Query
 * https://atcoder.jp/contests/abc235/tasks/abc235_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/28677053
 *
 */
package contests.abc.abc235.abc235_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(head.nextToken());
    int q = Integer.parseInt(head.nextToken());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<Integer, List<Integer>> num_map = new HashMap<>();
    for (int idx = 1; idx <= n; idx++) {
      int a = Integer.parseInt(st.nextToken());
      if (num_map.containsKey(a)) {
        num_map.get(a).add(idx);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(idx);
        num_map.put(a, list);
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      StringTokenizer query = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(query.nextToken());
      int k = Integer.parseInt(query.nextToken());
      if (num_map.containsKey(x) && num_map.get(x).size() >= k) {
        pw.println(num_map.get(x).get(k - 1));
      } else {
        pw.println(-1);
      }
    }
    br.close();
    pw.close();
  }
}
