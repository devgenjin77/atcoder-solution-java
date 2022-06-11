/*
 * AtCoder Beginner Contest 241
 * F - Skate
 * https://atcoder.jp/contests/abc241/tasks/abc241_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32423560
 *
 */

package contests.abc.abc24x.abc241.abc241_f;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int n = Integer.parseInt(sc.next());
    int sx = Integer.parseInt(sc.next());
    int sy = Integer.parseInt(sc.next());
    int gx = Integer.parseInt(sc.next());
    int gy = Integer.parseInt(sc.next());
    Map<Integer, TreeSet<Integer>> obj_at_h = new HashMap<>();
    Map<Integer, TreeSet<Integer>> obj_at_w = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(sc.next());
      int y = Integer.parseInt(sc.next());
      if (!obj_at_h.containsKey(x)) {
        obj_at_h.put(x, new TreeSet<>());
      }
      obj_at_h.get(x).add(y);
      if (!obj_at_w.containsKey(y)) {
        obj_at_w.put(y, new TreeSet<>());
      }
      obj_at_w.get(y).add(x);
    }
    sc.close();

    Deque<IntPair> queue = new ArrayDeque<>();
    Map<IntPair, Integer> cost_map = new HashMap<>();
    IntPair s = new IntPair(sx, sy);
    IntPair g = new IntPair(gx, gy);
    queue.add(s);
    cost_map.put(s, 0);
    int ans = -1;
    while (!queue.isEmpty() && ans == -1) {
      IntPair p = queue.pollFirst();
      int now_cost = cost_map.get(p);
      TreeSet<Integer> set_w = obj_at_h.get(p.first);
      TreeSet<Integer> set_h = obj_at_w.get(p.second);
      for (int d = 0; d < "UDLR".length(); d++) {
        char c = "UDLR".charAt(d);
        int next_x, next_y;
        if (c == 'U' && set_h != null) {
          Integer up = set_h.lower(p.first);
          if (up == null || up + 1 == p.first) {
            continue;
          }
          next_x = up + 1;
          next_y = p.second;
        } else if (c == 'D' && set_h != null) {
          Integer down = set_h.higher(p.first);
          if (down == null || down - 1 == p.first) {
            continue;
          }
          next_x = down - 1;
          next_y = p.second;
        } else if (c == 'L' && set_w != null) {
          Integer left = set_w.lower(p.second);
          if (left == null || left + 1 == p.second) {
            continue;
          }
          next_x = p.first;
          next_y = left + 1;
        } else if (c == 'R' && set_w != null) {
          Integer right = set_w.higher(p.second);
          if (right == null || right - 1 == p.second) {
            continue;
          }
          next_x = p.first;
          next_y = right - 1;
        } else {
          continue;
        }
        IntPair next = new IntPair(next_x, next_y);
        if (next.equals(g)) {
          ans = now_cost + 1;
          break;
        }
        if (!cost_map.containsKey(next)) {
          queue.addLast(next);
          cost_map.put(next, now_cost + 1);
        }
      }
    }
    System.out.println(ans);
  }

  static class IntPair {

    int first, second;

    IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IntPair pair = (IntPair) o;
      return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

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
}
