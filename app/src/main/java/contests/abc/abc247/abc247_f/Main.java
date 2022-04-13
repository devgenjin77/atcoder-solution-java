/*
 * ABC247
 * F - Cards
 * https://atcoder.jp/contests/abc247/tasks/abc247_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30948204
 *
 */

package contests.abc.abc247.abc247_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    int n = Integer.parseInt(nc.next());
    int[] array_p = new int[n];
    int[] array_q = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(nc.next()) - 1;
    }
    for (int i = 0; i < n; i++) {
      array_q[i] = Integer.parseInt(nc.next()) - 1;
    }
    nc.close();
    //リュカ数の計算
    long[] dp_l = new long[n + 1];
    dp_l[0] = 2;
    dp_l[1] = 1;
    for(int i = 2; i <= n; i++) {
      dp_l[i] = dp_l[i - 1] + dp_l[i - 2];
      dp_l[i] %= MOD;
    }
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    for (int i = 0; i < n; i++) {
      dsu.merge(array_p[i], array_q[i]);
    }
    List<List<Integer>> groups = dsu.groups();
    long ans = 1;
    for (int i = 0; i < groups.size(); i++) {
      int s = groups.get(i).size();
      if (s > 1) {
        ans = (ans * dp_l[s]) % MOD;
      }
    }
    System.out.println(ans);
  }

  //DisjointSetUnionライブラリ
  static class DisjointSetUnion {

    private final int n;
    private int[] parent_or_size;

    public DisjointSetUnion(int n) {
      this.n = n;
      parent_or_size = new int[n];
      java.util.Arrays.fill(parent_or_size, -1);
    }

    public int merge(int a, int b) {
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

    public boolean isSame(int a, int b) {
      if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
        return false;
      }
      return leader(a) == leader(b);
    }

    public int leader(int a) {
      if (parent_or_size[a] < 0) {
        return a;
      } else {
        parent_or_size[a] = leader(parent_or_size[a]);
        return parent_or_size[a];
      }
    }

    public int size(int a) {
      if (!(0 <= a && a < n)) {
        return -1;
      }
      return -parent_or_size[leader(a)];
    }

    public java.util.List<java.util.List<Integer>> groups() {
      int[] leader_buf = new int[n];
      int[] group_size = new int[n];
      for (int i = 0; i < n; i++) {
        leader_buf[i] = leader(i);
        group_size[leader_buf[i]]++;
      }
      java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
      java.util.HashMap<Integer, java.util.ArrayList<Integer>> list_map = new java.util.HashMap<>();
      for (int i = 0; i < n; i++) {
        if (i == leader_buf[i]) {
          list_map.put(i, new java.util.ArrayList<>());
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


  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    public String next() throws IOException {
      if (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(in.readLine());
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
