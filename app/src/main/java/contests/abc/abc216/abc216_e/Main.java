/*
 * ABC216
 * E - Amusement Park
 * https://atcoder.jp/contests/abc216/tasks/abc216_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/25545710
 */
package contests.abc.abc216.abc216_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    long k = Long.parseLong(head[1]);
    long[] array = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    Arrays.sort(array);

    //mの値を二分探索
    long left = 1;
    long right = 2_000_000_001L;
    while(right - left > 1){
      long mid = (left + right) / 2;
      if(canRideOverKCount(mid, k, array)){
        left = mid;
      } else {
        right = mid;
      }
    }

    long ans = 0;
    long m = right;
    long remain = k;
    int idx = array.length - 1;
    while(idx >= 0 && array[idx] >= m){
      long cnt = array[idx] - m + 1;
      if(remain >= cnt){
        ans += calcSumOfFun(m, array[idx]);
        remain = remain - cnt;
      } else {
        break;
      }
      idx--;
    }
    ans += Math.min(remain, array.length) * left;
    System.out.println(ans);
  }

  static long calcSumOfFun(long a, long b){
    long cnt = b - a + 1;
    return ((a + b) * cnt) / 2;
  }

  // m以上の楽しさでk回アトラクションに乗れるか判定
  static boolean canRideOverKCount(long m, long k, long[] array){
    int idx = array.length - 1;
    long cnt = 0;
    while(idx >= 0 && cnt < k){
      if(array[idx] < m){
        break;
      } else {
        cnt += (array[idx] - m + 1);
        idx--;
      }
    }
    return cnt >= k ? true : false;
  }
}