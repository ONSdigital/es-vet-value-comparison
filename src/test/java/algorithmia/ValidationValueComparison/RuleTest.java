package algorithmia.ValidationValueComparison;


import org.junit.Assert;
import org.junit.Test;

public class RuleTest {

    @Test
    public void value1_NotEqualTo_value2_Triggers()  {
        InputData inputData = new InputData("2","1");
        Rule rule = new Rule(inputData);
        Assert.assertEquals(true,rule.run());
    }

    @Test
    public void value1_EqualTo_value2_NotTriggered() {
        InputData inputData = new InputData("1.000001","1.000001");
        Rule rule = new Rule(inputData);
        Assert.assertEquals(false,rule.run());
    }

    @Test
    public void value1_DecimalPlaces_EqualTo_value2_NotTriggered() {
        InputData inputData = new InputData("1.000000","1.00");
        Rule rule = new Rule(inputData);
        Assert.assertEquals(false,rule.run());
    }

    @Test
    public void value1_Blanks_NotEqualTo_value2_NotTriggered() {
        InputData inputData = new InputData(""," ");
        Rule rule = new Rule(inputData);
        Assert.assertEquals(false,rule.run());
    }

    @Test
    public void value1_Negative_NotEqualTo_value2_Triggers()  {
        InputData inputData = new InputData("-2","-1");
        Rule rule = new Rule(inputData);
        Assert.assertEquals(true,rule.run());
    }

}