/*
 * ABC239
 * D - Prime Sum Game
 * https://atcoder.jp/contests/abc239/tasks/abc239_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/29853460
 *
 */
package contests.abc.abc239.abc239_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);
    int d = Integer.parseInt(input[3]);

    EratosthenesSieve es = new EratosthenesSieve(200);
    boolean bTakaWon = false;
    for (int x1 = a; x1 <= b; x1++) {
      boolean bAokiWon = false;
      for (int x2 = c; x2 <= d; x2++) {
        if (es.isPrimeNumber(x1 + x2)) {
          bAokiWon = true;
          break;
        }
      }
      if (!bAokiWon) {
        bTakaWon = true;
        break;
      }
    }
    System.out.println(bTakaWon ? "Takahashi" : "Aoki");
  }

  static class EratosthenesSieve {

    int div[];

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

    boolean isPrimeNumber(int n) {
      return div[n] == n;
    }
  }
}
