package contests.abc.abc242.abc242_a;

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
  final static String contest = "ABC242";
  final static String problem = "A";

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
      double expectedValue = Double.parseDouble(IOUtils.toString(expected, StandardCharsets.UTF_8.name()).trim());
      assertEquals(expectedValue, Double.parseDouble(byteArrayOutputStream.toString().trim()), 0.000001);
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
