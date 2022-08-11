/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 239）
 * D - Prime Sum Game
 * https://atcoder.jp/contests/abc239/tasks/abc239_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/33946868
 *
 * note:
 * エラトステネスの篩で素数判断
 *
 */

package contests.abc.abc23x.abc239.abc239_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    final int d = Integer.parseInt(st.nextToken());
    br.close();

    final EratosthenesSieve sieve = new EratosthenesSieve(200);
    boolean isTakaWin = false;
    for (int i = a; i <= b; i++) {
      isTakaWin = true;
      for (int j = c; j <= d; j++) {
        if (sieve.isPrimeNumber(i + j)) {
          isTakaWin = false;
          break;
        }
      }
      if (isTakaWin) {
        break;
      }
    }
    System.out.println(isTakaWin ? "Takahashi" : "Aoki");
  }

  //EratosthenesSieveライブラリ
  static class EratosthenesSieve {

    private final int div[];

    EratosthenesSieve(int n) {
      div = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        div[i] = i % 2 == 0 ? 2 : i;
      }
      for (int num = 3; num * num <= n; num += 2) {
        if (div[num] == num) {
          int multiple = num * 2;
          while (multiple <= n) {
            div[multiple] = num;
            multiple += num;
          }
        }
      }
    }

    public boolean isPrimeNumber(int n) {
      return div[n] == n;
    }
  }
}
