/*
 * ABC216
 * B - Same Name
 * https://atcoder.jp/contests/abc215/tasks/abc216_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/25469615
 */
package contests.abc.abc216.abc216_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringJoiner;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ans = "No";
    int n = Integer.parseInt(br.readLine());
    HashSet<String> nameSet = new HashSet<>();
    for(int i = 0; i < n; i++){
      String[] data = br.readLine().split(" ");
      String fullName = new StringJoiner(",").add(data[0]).add(data[1]).toString();
      if(nameSet.contains(fullName)){
        ans = "Yes";
        break;
      } else {
        nameSet.add(fullName);
      }
    }
    br.close();
    System.out.println(ans);
  }
}
