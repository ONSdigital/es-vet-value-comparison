package algorithmia.ValidationValueComparison;

import com.algorithmia.algo.AcceptsJson;
import com.algorithmia.algo.ReturnsJson;
import com.google.gson.JsonElement;

public class ValidationValueComparison {
    @AcceptsJson
    @ReturnsJson
    public JsonElement apply(String input) {
        return new Runner(input).parseAndRunValidationRule();
    }
}
