package contests.abc.abc21x.abc216.abc216_c;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

  InputStream _input;
  PrintStream _output;

  final static String category = "ABC";
  final static String prefix = "ABC21X";
  final static String contest = "ABC216";
  final static String problem = "C";

  final static String testDataInDir = new StringJoiner("/", "/", "/")
      .add(category).add(prefix).add(contest).add(problem).add("in").toString();
  final static String testDataOutDir = new StringJoiner("/", "/", "/")
      .add(category).add(prefix).add(contest).add(problem).add("out").toString();

  @BeforeEach
  void setUp() {
    _input = System.in;
    _output = System.out;
  }

  @ParameterizedTest
  @MethodSource("getTestCaseFiles")
  void testMain(String fileName) throws Exception {
    try (
        InputStream input = this.getClass().getResourceAsStream(testDataInDir + fileName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteArrayOutputStream);
        InputStream expected = this.getClass().getResourceAsStream(testDataOutDir + fileName)) {
      System.setIn(input);
      System.setOut(output);
      Main.main(null);
      //答えは一意にならないので、出力の文字列で0から計算して入力値になるかを計算する。
      InputStream in2 = this.getClass().getResourceAsStream(testDataInDir + fileName);
      long val = Long.parseLong(IOUtils.toString(in2, StandardCharsets.UTF_8.name()).trim());
      String actual = byteArrayOutputStream.toString().trim();
      assertEquals(val, calcResult(actual));
    }
  }

  // 魔法A：ボールを１つ増やす
  // 魔法B：ボールの数を２倍にする
  private long calcResult(String magic) {
    long ans = 0;
    for (int i = 0; i < magic.length(); i++) {
      if (magic.charAt(i) == 'A') {
        ans += 1;
      } else if (magic.charAt(i) == 'B') {
        ans *= 2;
      } else {
        throw new IllegalArgumentException(
            "magic pattern contains illegal char (" + magic.charAt(i) + ")");
      }
    }
    return ans;
  }

  static List<String> getTestCaseFiles() throws IOException {
    List<String> filenames = new ArrayList<>();
    try (
        InputStream in = MainTest.class.getResourceAsStream(testDataInDir);
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))
    ) {
      String resource;
      while ((resource = br.readLine()) != null) {
        filenames.add(resource);
      }
      return filenames;
    }
  }

  @AfterEach
  void tearDown() {
    System.setIn(_input);
    System.setOut(_output);
  }
}
