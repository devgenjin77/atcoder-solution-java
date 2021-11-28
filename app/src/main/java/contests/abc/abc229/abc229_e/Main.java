/*
 * ABC229
 * E - Graph Destruction
 * https://atcoder.jp/contests/abc229/tasks/abc229_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/27562188
 */
package contests.abc.abc229.abc229_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    List<List<Integer>> edge_list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      edge_list.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int from = Integer.parseInt(ab[0]) - 1;
      int to = Integer.parseInt(ab[1]) - 1;
      edge_list.get(from).add(to);
    }
    br.close();
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    Stack<Integer> ans_stack = new Stack<>();
    ans_stack.add(0);
    int ans = 0;
    for (int node = n - 1; node >= 1; node--) {
      ans += 1;
      for (int to : edge_list.get(node)) {
        if(!dsu.isSame(node, to)){
          dsu.merge(node, to);
          ans -= 1;
        }
      }
      ans_stack.add(ans);
    }
    PrintWriter pw = new PrintWriter(System.out);
    while (!ans_stack.isEmpty()) {
      pw.println(ans_stack.pop());
    }
    pw.close();
  }
}

class DisjointSetUnion {

  private final int n;
  private int[] parent_or_size;

  DisjointSetUnion(int n) {
    this.n = n;
    parent_or_size = new int[n];
    Arrays.fill(parent_or_size, -1);
  }

  int merge(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return -1;
    }
    int x = leader(a);
    int y = leader(b);
    if (x == y) {
      return x;
    }
    if (-parent_or_size[x] < -parent_or_size[y]) {
      int temp = x;
      x = y;
      y = temp;
    }
    parent_or_size[x] += parent_or_size[y];
    parent_or_size[y] = x;
    return x;
  }

  boolean isSame(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return false;
    }
    return leader(a) == leader(b);
  }

  int leader(int a) {
    if (parent_or_size[a] < 0) {
      return a;
    } else {
      parent_or_size[a] = leader(parent_or_size[a]);
      return parent_or_size[a];
    }
  }

  int size(int a) {
    if (!(0 <= a && a < n)) {
      return -1;
    }
    return -parent_or_size[leader(a)];
  }

  List<List<Integer>> groups() {
    int[] leader_buf = new int[n];
    int[] group_size = new int[n];
    for (int i = 0; i < n; i++) {
      leader_buf[i] = leader(i);
      group_size[leader_buf[i]]++;
    }
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> list_map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == leader_buf[i]) {
        list_map.put(i, new ArrayList<>());
      }
    }
    for (int i = 0; i < n; i++) {
      list_map.get(leader_buf[i]).add(i);
    }
    for (Integer key : list_map.keySet()) {
      result.add(list_map.get(key));
    }
    return result;
  }
}
