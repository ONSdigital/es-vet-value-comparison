package algorithmia.ValidationValueComparison;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationValueComparisonTest {

    private final ValidationValueComparison underTest;

    public ValidationValueComparisonTest() {
        underTest = new ValidationValueComparison();
    }

    @Test
    public void testValidationValueComparison() throws Exception {
        //assertThat(underTest.apply("Bob"), equalTo("Hello Bob"));
    }
}
