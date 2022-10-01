package library.math;

//EratosthenesSieveライブラリ
public class EratosthenesSieve {

  private final int div[];

  EratosthenesSieve(int n) {
    div = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      div[i] = i % 2 == 0 ? 2 : i;
    }
    for (int num = 3; num * num <= n; num += 2) {
      if (div[num] == num) {
        int multiple = num * 2;
        while (multiple <= n) {
          div[multiple] = num;
          multiple += num;
        }
      }
    }
  }

  public boolean isPrimeNumber(int n) {
    return div[n] == n;
  }
}
