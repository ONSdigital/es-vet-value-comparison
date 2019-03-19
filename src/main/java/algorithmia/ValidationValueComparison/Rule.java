package algorithmia.ValidationValueComparison;

import java.math.BigDecimal;

import static algorithmia.ValidationValueComparison.MathHelperFunctions.safeConvertToBigDecimal;

public class Rule {

    protected BigDecimal primaryValue;
    protected BigDecimal comparisonValue;

    public Rule(InputData sourceInputData) {
        primaryValue = safeConvertToBigDecimal(sourceInputData.primaryValue);
        comparisonValue = safeConvertToBigDecimal(sourceInputData.comparisonValue);
    }

    public String getValueFormula() {
        return primaryValue.toString() + " != " + comparisonValue.toString();
    }

    public boolean run() {
        return primaryValue.compareTo(comparisonValue) != 0;
    }
}
