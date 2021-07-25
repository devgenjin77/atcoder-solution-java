/*
 * ABC211
 * B - Cycle Hit
 * https://atcoder.jp/contests/abc211/tasks/abc211_b
 *
 * - https://atcoder.jp/contests/abc211/submissions/24528055
 */
package contests.abc.abc211.abc211_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> set = new HashSet<>();
    for(int i = 0; i < 4; i++){
      set.add(br.readLine());
    }
    br.close();
    if(set.size() == 4){
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
