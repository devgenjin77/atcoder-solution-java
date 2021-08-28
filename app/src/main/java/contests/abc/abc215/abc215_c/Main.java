/*
 * ABC215
 * C - One More aab aba baa
 * https://atcoder.jp/contests/abc215/tasks/abc215_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/25382867
 */
package contests.abc.abc215.abc215_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

  static TreeSet<String> pattern_set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();

    String s = input[0];
    int k = Integer.parseInt(input[1]);
    boolean[] isUsed = new boolean[s.length()];
    Arrays.fill(isUsed, false);
    pattern_set = new TreeSet<>();
    buildPermutation(s, new StringBuffer(), isUsed);

    Iterator<String> pattern = pattern_set.iterator();
    String ans = "";
    for(int i = 1; i <= k; i++){
      ans = pattern.next();
    }
    System.out.println(ans);
  }

  // 全ての並び替えパターンを作成する
  static void buildPermutation(String s, StringBuffer sb, boolean[] isUsed){
    if(sb.length() == s.length()){
      pattern_set.add(sb.toString());
      return;
    }
    for(int i = 0; i < isUsed.length; i++){
      if(isUsed[i]){
        continue;
      } else {
        sb.append(s.charAt(i));
        isUsed[i] = true;
        buildPermutation(s, sb, isUsed);
        isUsed[i] = false;
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}