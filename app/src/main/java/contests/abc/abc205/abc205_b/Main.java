/*
 * ABC205
 * B - Permutation Check
 * https://atcoder.jp/contests/abc205/tasks/abc205_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/23411505
 */
package contests.abc.abc205.abc205_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int[] array = new int[n];
    Arrays.fill(array, 0);
    for(int i = 0; i < n; i++){
      int idx = Integer.parseInt(st.nextToken()) - 1;
      if(array[idx] == 0){
        array[idx] = 1;
      } else {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}

