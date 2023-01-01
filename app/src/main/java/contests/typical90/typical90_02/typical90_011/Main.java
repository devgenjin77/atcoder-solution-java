/*
 * 競プロ典型90問
 * 011 - Gravy Jobs（★6）
 * https://atcoder.jp/contests/typical90/tasks/typical90_k
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/37680529
 *
 * note:
 * 区間スケジューリング問題の応用
 * 締め切りが早いタスクを優先して見ていく
 *
 */

package contests.typical90.typical90_02.typical90_011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final List<Job> job_list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      int c = sc.nextInt();
      long s = sc.nextLong();
      job_list.add(new Job(d, c, s));
    }
    sc.close();
    Collections.sort(job_list);
    //dp[i][j]:=i個のタスクを見た時に、仕事に使った合計日数がjの時の報酬の最大値
    final int day_max = job_list.get(n - 1).d;
    final long[][] dp = new long[n + 1][day_max + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      Job job = job_list.get(i);
      for (int j = 0; j < day_max; j++) {
        if (dp[i][j] == -1) {
          continue;
        }
        //選ばない
        dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j]);
        if (j + job.c <= job.d) {
          //選ぶ
          dp[i + 1][j + job.c] = Math.max(dp[i][j] + job.s, dp[i + 1][j + job.c]);
        }
      }
    }
    long ans = 0;
    for (int j = 0; j <= day_max; j++) {
      ans = Math.max(dp[n][j], ans);
    }
    System.out.println(ans);
  }

  static class Job implements Comparable<Job> {

    int c, d;
    long s;

    public Job(int d, int c, long s) {
      this.d = d;
      this.c = c;
      this.s = s;
    }

    @Override
    public int compareTo(Job o) {
      if (this.d != o.d) {
        return Integer.compare(this.d, o.d);
      } else if (this.c != o.c) {
        return Integer.compare(this.c, o.c);
      } else {
        return Long.compare(this.s, o.s);
      }
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
