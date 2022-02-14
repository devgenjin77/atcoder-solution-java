package contests.arc.arc135.arc135_b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

  InputStream _input;
  PrintStream _output;

  final static String category = "ARC";
  final static String contest = "ARC135";
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
        InputStream input2 = this.getClass().getResourceAsStream(testDataInDir + fileName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteArrayOutputStream);
        InputStream expected = this.getClass().getResourceAsStream(testDataOutDir + fileName)) {
      System.setIn(input);
      System.setOut(output);
      Main.main(null);
      String[] inputValues = IOUtils.toString(input2, StandardCharsets.UTF_8.name()).trim().split("\r\n|\r|\n");
      String[] expectedValues = IOUtils.toString(expected, StandardCharsets.UTF_8.name()).trim().split("\r\n|\r|\n");
      String[] actualValues = byteArrayOutputStream.toString().trim().split("\r\n|\r|\n");
      if("Yes".equals(expectedValues[0])){
        assertEquals("Yes", actualValues[0]);
        long[] array_input = Stream.of(inputValues[1].split(" ")).mapToLong(Long::parseLong).toArray();
        long[] array_actual = Stream.of(actualValues[1].split(" ")).mapToLong(Long::parseLong).toArray();
        for(int i = 0; i < array_actual.length; i++){
          assertTrue(array_actual[i] >= 0);
        }
        for(int i = 0; i < array_actual.length - 2; i++){
          assertEquals(array_input[i], array_actual[i] + array_actual[i + 1] + array_actual[i + 2]);
        }
      } else if ("No".equals(expectedValues[0])){
        assertEquals("No", actualValues[0]);
      } else {
        Assertions.fail();
      }
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
