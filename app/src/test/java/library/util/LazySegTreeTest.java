package library.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LazySegTreeTest {

  static final int MINUS_INF = -1_000_000_000;

  @Test
  void zero() {
    LazySegTree<Integer, Integer> lazySegTree =
        new LazySegTree<>(
            0, Integer::max, MINUS_INF,
            (f, s) -> f + s, (f1, f2) -> f1 + f2, 0);
    assertEquals(MINUS_INF, lazySegTree.allProd());
  }

  @Test
  void one() {
    LazySegTree<Integer, Integer> lazySegTree =
        new LazySegTree<>(
            1, Integer::max, MINUS_INF,
            (f, s) -> f + s, (f1, f2) -> f1 + f2,  0);
    assertEquals(MINUS_INF, lazySegTree.allProd());
    assertEquals(MINUS_INF, lazySegTree.get(0));
    assertEquals(MINUS_INF, lazySegTree.prod(0, 1));

    lazySegTree.set(0, 1);
    assertEquals(1, lazySegTree.get(0));
    assertEquals(MINUS_INF, lazySegTree.prod(0, 0));
    assertEquals(1, lazySegTree.prod(0, 1));
    assertEquals(MINUS_INF, lazySegTree.prod(1, 1));
  }

  @Test
  void usageAddMax() {
    //区間加算・区間最小値取得
    Integer[] data = new Integer[10];
    java.util.Arrays.fill(data, 0);
    LazySegTree<Integer, Integer> lazySegTree =
        new LazySegTree<>(
            data, Integer::max, MINUS_INF,
            (f, s) -> f + s, (f1, f2) -> f1 + f2, 0);
    assertEquals(0, lazySegTree.allProd());
    lazySegTree.apply(0, 3, 5);
    assertEquals(5, lazySegTree.allProd());
    lazySegTree.apply(2, -10);
    assertEquals(-5, lazySegTree.prod(2, 3));
    assertEquals(0, lazySegTree.prod(2, 4));
  }

  @Test
  void usageAddSum() {
    //区間加算・区間和取得
    Pair<Integer, Integer>[] data = new Pair[10];
    java.util.Arrays.fill(data, new Pair(0, 1));
    LazySegTree<Pair<Integer, Integer>, Integer> lazySegTree = new LazySegTree<>(
        data,
        (s1, s2) -> new Pair<>(s1.value + s2.value, s1.size + s2.size),
        new Pair<>(0, 0),
        (f, s) -> new Pair<>(s.value + (f * s.size), s.size),
        (f1, f2) -> f1 + f2,  0);
    assertEquals(0, lazySegTree.allProd().value);
    lazySegTree.apply(0, 5, 5);
    assertEquals(25, lazySegTree.allProd().value);
    assertEquals(15, lazySegTree.prod(1, 4).value);
    lazySegTree.apply(2, -8);
    assertEquals(17, lazySegTree.allProd().value);
    assertEquals(7, lazySegTree.prod(1, 4).value);
    assertEquals(2, lazySegTree.prod(2, 4).value);
  }

  @Test
  void compareNaive() {
    for (int n = 0; n <= 50; n++) {
      LazySegTree<Integer, Integer> segTree =
          new LazySegTree<>(
              n, Integer::max, MINUS_INF,
              (f, s) -> f + s, (f1, f2) -> f1 + f2, 0);
      LazySegTreeNaive<Integer, Integer> naive =
          new LazySegTreeNaive<>(n, Integer::max, () -> MINUS_INF, (f, s) -> f + s);
      for (int i = 0; i < n; i++) {
        int val = (i * i + 100) % 31;
        segTree.set(i, val);
        naive.set(i, val);
      }

      for (int l = 0; l <= n; l++) {
        for (int r = l; r <= n; r++) {
          assertEquals(naive.prod(l, r), segTree.prod(l, r));
        }
      }

      for (int l = 0; l <= n; l++) {
        for (int r = l; r <= n; r++) {
          int y = segTree.prod(l, r);
          assertEquals(naive.maxRight(l, e -> e <= y), segTree.maxRight(l, e -> e <= y));
        }
      }

      for (int r = 0; r <= n; r++) {
        for (int l = 0; l <= r; l++) {
          int y = segTree.prod(l, r);
          assertEquals(naive.minLeft(r, e -> e <= y), segTree.minLeft(r, e -> e <= y));
        }
      }

    }
  }

  @Test
  void testThrowsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new LazySegTree<>(-1, Integer::max, MINUS_INF,
            (f, s) -> f + s, (f1, f2) -> f1 + f2, 0));
    LazySegTree<Integer, Integer> lazySegTree =
        new LazySegTree<>(
            10, Integer::max, MINUS_INF,
            (f, s) -> f + s, (f1, f2) -> f1 + f2, 0);
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.get(10));

    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.prod(-1, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.prod(3, 2));
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.prod(0, 11));
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.prod(-1, 11));

    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.maxRight(11, e -> e == e));
    assertThrows(IndexOutOfBoundsException.class, () -> lazySegTree.minLeft(-1, e -> e == e));

    assertThrows(IllegalArgumentException.class, () -> lazySegTree.maxRight(0, e -> e != e));
    assertThrows(IllegalArgumentException.class, () -> lazySegTree.minLeft(10, e -> e != e));
  }

  class Pair<S, T> {

    S value;
    T size;

    Pair(S value, T size) {
      this.value = value;
      this.size = size;
    }
  }

  class LazySegTreeNaive<S, F> {

    int _n;
    S[] data;

    java.util.function.BinaryOperator<S> op;
    java.util.function.Supplier<S> e; //単位元
    java.util.function.BiFunction<F, S, S> mapping;

    LazySegTreeNaive(int n, java.util.function.BinaryOperator<S> op,
        java.util.function.Supplier<S> e,
        java.util.function.BiFunction<F, S, S> mapping) {
      this._n = n;
      this.op = op;
      this.e = e;
      this.mapping = mapping;

      this.data = (S[]) new Object[n];
      java.util.Arrays.fill(data, e.get());
    }

    LazySegTreeNaive(S[] data, java.util.function.BinaryOperator<S> op,
        java.util.function.Supplier<S> e,
        java.util.function.BiFunction<F, S, S> mapping) {
      this(data.length, op, e, mapping);
      System.arraycopy(data, 0, this.data, 0, data.length);
    }


    void set(int p, S x) {
      this.data[p] = x;
    }

    S get(int p) {
      return this.data[p];
    }

    S prod(int l, int r) {
      S sum = e.get();
      for (int i = l; i < r; i++) {
        sum = op.apply(sum, data[i]);
      }
      return sum;
    }

    S allProd() {
      return prod(0, this._n);
    }

    void apply(int p, F f) {
      this.data[p] = mapping.apply(f, data[p]);
    }

    void apply(int l, int r, F f) {
      for (int i = l; i < r; i++) {
        apply(i, f);
      }
    }

    int maxRight(int l, java.util.function.Predicate<S> f) {
      S sum = e.get();
      if (!f.test(e.get())) {
        throw new IllegalArgumentException("Identity element must satisfy the condition.");
      }
      for (int i = l; i < this._n; i++) {
        sum = op.apply(data[i], sum);
        if (!f.test(sum)) {
          return i;
        }
      }
      return this._n;
    }

    int minLeft(int r, java.util.function.Predicate<S> f) {
      S sum = e.get();
      if (!f.test(e.get())) {
        throw new IllegalArgumentException("Identity element must satisfy the condition.");
      }
      for (int i = r - 1; i >= 0; i--) {
        sum = op.apply(data[i], sum);
        if (!f.test(sum)) {
          return i + 1;
        }
      }
      return 0;
    }
  }
}