/*
 * ABC212
 * B - Weak Password
 * https://atcoder.jp/contests/abc212/tasks/abc212_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/24699026
 */
package contests.abc.abc212.abc212_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String x = br.readLine();
    br.close();
    System.out.println(isWeakPassword(x) ? "Weak" : "Strong");
  }
  static boolean isWeakPassword(String pwd){
    // 全ての数字が同じかを判断
    if(pwd.substring(0, 2).equals(pwd.substring(2))){
      return true;
    }
    // 次の桁の数字が前の桁の数字のプラス１であるか判断
    char[] c_pwd = pwd.toCharArray();
    for(int i = 0; i <=2; i++){
      if((c_pwd[i] - '0' + 1) % 10 != c_pwd[i + 1] - '0'){
        return false;
      }
    }
    return true;
  }
}
