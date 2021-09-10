/*
 * ABC217
 * C - Inverse of Permutation
 * https://atcoder.jp/contests/abc217/tasks/abc217_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/25727399
 */
package contests.abc.abc217.abc217_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] p_array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
    int[] q_array = new int[n];
    for(int idx = 0; idx < n; idx++){
      int to_idx = p_array[idx] - 1;
      q_array[to_idx] = idx + 1;
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      if(i != 0){
        sb.append(' ');
      }
      sb.append(q_array[i]);
    }
    System.out.println(sb.toString());
  }
}