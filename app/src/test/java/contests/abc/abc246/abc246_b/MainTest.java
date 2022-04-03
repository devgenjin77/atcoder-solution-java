package contests.abc.abc246.abc246_b;

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
  final static String contest = "ABC246";
  final static String problem = "B";

  final static String testDataInDir = new StringJoiner("/", "/", "/")
      .add(category).add(contest).add(problem).add("in").toString();
  final static String testDataOutDir = new StringJoiner("/", "/", "/")
      .add(category).add(contest).add(problem).add("out").toString();

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
      // 誤差は10^-6以下であること
      // delta
      String[] expectedValues = IOUtils.toString(expected, StandardCharsets.UTF_8.name()).split(" ");
      double expectedValue1 = Double.parseDouble(expectedValues[0]);
      double expectedValue2 = Double.parseDouble(expectedValues[1]);
      String[] actualValues = byteArrayOutputStream.toString().split(" ");
      double actualValue1 = Double.parseDouble(actualValues[0]);
      double actualValue2 = Double.parseDouble(actualValues[1]);
      assertEquals(expectedValue1, actualValue1, 0.000001);
      assertEquals(expectedValue2, actualValue2, 0.000001);
    }
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
