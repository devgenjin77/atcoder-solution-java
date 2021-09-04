/*
 * ABC217
 * D - Cutting Woods
 * https://atcoder.jp/contests/abc217/tasks/abc217_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/25614444
 */
package contests.abc.abc217.abc217_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int l = Integer.parseInt(head[0]);
    int q = Integer.parseInt(head[1]);
    TreeSet<Integer> position_set = new TreeSet<>();
    position_set.add(0);
    position_set.add(l);
    PrintWriter pw = new PrintWriter(System.out);
    for(int i = 0; i < q; i++){
      String[] query = br.readLine().split(" ");
      int x = Integer.parseInt(query[1]);
      if("1".equals(query[0])){
        position_set.add(x);
      } else if("2".equals(query[0])) {
        pw.println(position_set.higher(x) - position_set.lower(x));
      }
    }
    br.close();
    pw.close();
  }
}