package drill;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import edu.illinois.cs.cs125.gradlegrader.annotations.Graded;

class OrderedLettersTest {

  @TestFactory
  @DisplayName("already ordered")
  @Graded(points = 10, friendlyName = "this is the already ordered test")
  public List<DynamicTest> already_ordered() {
    return List.of(
        testFor('a', 'a', "a and a"),
        testFor('F', 'X', "F and X"),
        testFor('2', '8', "2 and 8"),
        testFor('$', '(', "$ and ("));
  }

  @TestFactory
  @DisplayName("reverse ordered")
  @Graded(points = 10, friendlyName = "this is the reverse ordered test")
  public List<DynamicTest> reverse_ordered() {
    return List.of(
        testFor('f', 'e', "e and f"),
        testFor(']', '[', "[ and ]"),
        testFor('9', '0', "0 and 9"),
        testFor('M', 'C', "C and M"));
  }

  @TestFactory
  @DisplayName("same letter")
  @Graded(points = 4, friendlyName = "this is the same lettered test")
  public List<DynamicTest> same_letter() {
    return List.of(
        testFor('V', 'V', "V and V"),
        testFor('<', '<', "< and <"),
        testFor('8', '8', "8 and 8"),
        testFor('t', 't', "t and t"));
  }

  @TestFactory
  @DisplayName("case of letters remains untouched")
  @Graded(points = 8, friendlyName = "this is the case doesn't change test")
  public List<DynamicTest> case_doesnt_change() {
    return List.of(
        testFor('b', 'X', "b and X"),
        testFor('X', 'b', "b and X"),
        testFor('r', 'E', "E and r"),
        testFor('E', 'r', "E and r"));
  }

  DynamicTest testFor(char firstChar, char secondChar, String expected) {
    String display =
        String.format(
            "orderedLetters(%s, %s) should return \"%s\"", firstChar, secondChar, expected);
    return DynamicTest.dynamicTest(
        display,
        () -> {
          assertThat(DrillUtils.orderedLetters(firstChar, secondChar)).isEqualTo(expected);
        });
  }
}
