/*
 * ABC221
 * C - Select Mul
 * https://atcoder.jp/contests/abc221/tasks/abc221_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/26373451
 */
package contests.abc.abc221.abc221_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    br.close();
    int[] digits = new int[10];
    for(int i = 0; i < n.length(); i++){
      digits[n.charAt(i) - '0']++;
    }
    long a = 0, b = 0;
    for(int dig = 9; dig >= 0; dig--){
      while(digits[dig] != 0){
        if(a < b){
          a = a * 10 + dig;
        } else {
          b = b * 10 + dig;
        }
        digits[dig]--;
      }
    }
    System.out.println(a * b);
  }
}
