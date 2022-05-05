/*
 * ABC213
 * C - Reorder Cards
 * https://atcoder.jp/contests/abc213/tasks/abc213_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31456689
 *
 */
package contests.abc.abc213.abc213_c;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int n = Integer.parseInt(sc.next());
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    int[] sorted_a = Arrays.stream(array_a).sorted().distinct().toArray();
    int[] sorted_b = Arrays.stream(array_b).sorted().distinct().toArray();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      int idx_a = Arrays.binarySearch(sorted_a, array_a[i]);
      int idx_b = Arrays.binarySearch(sorted_b, array_b[i]);
      pw.println(String.format("%d %d", idx_a + 1, idx_b + 1));
    }
    pw.close();
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
