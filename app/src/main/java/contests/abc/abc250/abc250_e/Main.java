/*
 * ABC250
 * E - Prefix Equality
 * https://atcoder.jp/contests/abc250/tasks/abc250_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31607229
 *
 * note:
 * setA,setBをequals比較すると、件数が多い時に重いようなので、
 * AにもBにも存在する要素を管理する集合setABを管理する
 *
 */

package contests.abc.abc250.abc250_e;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] cnt_set_a = new int[n];
    int[] cnt_set_b = new int[n];
    boolean[] is_same_at_cnt = new boolean[n + 1];
    is_same_at_cnt[0] = true;
    Set<Integer> set_a = new HashSet<>();
    Set<Integer> set_b = new HashSet<>();
    Set<Integer> set_ab = new HashSet<>();
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = Integer.parseInt(sc.next());
    }
    int idx_a = 0, idx_b = 0;
    int tgt_cnt = 1;
    while (idx_a < n && idx_b < n) {
      while (idx_a < n && set_a.size() < tgt_cnt) {
        int a = array_a[idx_a];
        set_a.add(a);
        cnt_set_a[idx_a++] = set_a.size();
        if (set_b.contains(a)) {
          set_ab.add(a);
        }
      }
      while (idx_b < n && set_b.size() < tgt_cnt) {
        int b = array_b[idx_b];
        set_b.add(b);
        cnt_set_b[idx_b++] = set_b.size();
        if (set_a.contains(b)) {
          set_ab.add(b);
        }
      }
      if (set_a.size() == tgt_cnt && set_b.size() == tgt_cnt) {
        is_same_at_cnt[tgt_cnt] = set_ab.size() == tgt_cnt;
      }
      tgt_cnt++;
    }
    while (idx_a < n) {
      set_a.add(array_a[idx_a]);
      cnt_set_a[idx_a++] = set_a.size();
    }
    while (idx_b < n) {
      set_b.add(array_b[idx_b]);
      cnt_set_b[idx_b++] = set_b.size();
    }

    PrintWriter pw = new PrintWriter(System.out);
    int q = Integer.parseInt(sc.next());
    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(sc.next()) - 1;
      int y = Integer.parseInt(sc.next()) - 1;
      if (cnt_set_a[x] == cnt_set_b[y] && is_same_at_cnt[cnt_set_a[x]]) {
        pw.println("Yes");
      } else {
        pw.println("No");
      }
    }
    pw.close();
    sc.close();
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1 << 16;

  private static final char[] c_buf = new char[BUF_SIZE];

  public NextScanner(java.io.InputStream input) {
    this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
  }

  private java.util.StringTokenizer readInput() {
    java.util.StringTokenizer st;
    try {
      int b = br.read(c_buf);
      if (b == BUF_SIZE) {
        StringBuilder sb = new StringBuilder();
        sb.append(c_buf);
        sb.append(br.readLine());
        st = new java.util.StringTokenizer(sb.toString());
      } else if (b < 0) {
        throw new java.util.NoSuchElementException();
      } else {
        st = new java.util.StringTokenizer(new String(c_buf, 0, b));
      }
    } catch (java.io.IOException e) {
      throw new java.util.InputMismatchException(e.getMessage());
    }
    return st;
  }

  public String next() throws java.io.IOException {
    if (st == null || !st.hasMoreElements()) {
      st = readInput();
    }
    return st.nextToken();
  }

  @Override
  public void close() throws Exception {
    br.close();
  }
}
