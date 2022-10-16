/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 273）
 * E - Notebook
 * https://atcoder.jp/contests/abc273/tasks/abc273_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc273/submissions/35716825
 *
 */

package contests.abc.abc27x.abc273.abc273_e;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int q = sc.nextInt();
    final Map<Integer, Node> note = new HashMap<>();
    final StringBuilder sb = new StringBuilder();
    Node cur = null;
    for (int i = 0; i < q; i++) {
      String query = sc.next();
      if ("ADD".equals(query)) {
        cur = new Node(cur, sc.nextInt());
      } else if ("DELETE".equals(query)) {
        if (cur != null) {
          cur = cur.parent;
        }
      } else if ("SAVE".equals(query)) {
        note.put(sc.nextInt(), cur);
      } else if ("LOAD".equals(query)) {
        cur = note.get(sc.nextInt());
      }
      sb.append(cur == null ? -1 : cur.val);
      sb.append(' ');
    }
    sc.close();
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static class Node {

    Node parent;
    int val;

    public Node(Node parent, int val) {
      this.parent = parent;
      this.val = val;
    }
  }

  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    FastScanner(java.io.InputStream source) {
      this.in = source;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buf);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buf[ptr++];
      } else {
        return -1;
      }
    }

    private boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private boolean isNumeric(int c) {
      return '0' <= c && c <= '9';
    }

    private void skipToNextPrintableChar() {
      while (hasNextByte() && !isPrintableChar(buf[ptr])) {
        ptr++;
      }
    }

    public boolean hasNext() {
      skipToNextPrintableChar();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder ret = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        ret.appendCodePoint(b);
        b = readByte();
      }
      return ret.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long ret = 0;
      int b = readByte();
      boolean negative = false;
      if (b == '-') {
        negative = true;
        if (hasNextByte()) {
          b = readByte();
        }
      }
      if (!isNumeric(b)) {
        throw new NumberFormatException();
      }
      while (true) {
        if (isNumeric(b)) {
          ret = ret * 10 + b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return negative ? -ret : ret;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      return (int) nextLong();
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
