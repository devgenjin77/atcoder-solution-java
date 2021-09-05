/*
 * 競プロ典型90問
 * 024 - Select +／- One（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_x
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/25635861
 *
 */
package contests.typical90.typical90_x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    long k = Long.parseLong(head[1]);
    long[] array_a = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    long[] array_b = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    long diff = 0;
    for(int i = 0; i < n; i++){
      diff += Math.abs(array_a[i] - array_b[i]);
    }
    if(k >= diff && (k - diff) % 2 == 0){
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
