package algorithmia.ValidationValueComparison;


import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.TypeToken;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationValueComparisonSystemIT {

    private static String API_KEY = null;
    private static String API_ADDRESS = null;
    private static String ALGORITHM_DESCRIPTOR = null;
    private static final TypeToken<OutputData> OUTPUT_DATA_TYPE = new TypeToken<OutputData>() {};

    private AlgorithmiaClient client = null;

    @BeforeClass
    public static void loadConfig() {
        Config config = ConfigFactory.load().getConfig("algorithmia");
        API_KEY = config.getString("simpleApiKey");
        API_ADDRESS = config.getString("apiAddress");
        ALGORITHM_DESCRIPTOR = config.getString("algorithm.descriptor");
    }

    @Before
    public void setUp() {
        client = Algorithmia.client(API_KEY, API_ADDRESS);
    }

    @After
    public void tearDown() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException ignore) {
                // silently ignore
            }
        }
    }

    @Test
    public void validationRuleIsTriggeredWhenInputValuesDiffer() throws Exception {
        String inputWithDifferingValues = "{\"primaryValue\":\"1.234\", \"secondaryValue\":\"5.678\"}";

        OutputData output = client.algo(ALGORITHM_DESCRIPTOR).pipe(inputWithDifferingValues).as(OUTPUT_DATA_TYPE);

        assertThat(output.triggered, is(TRUE));
    }
}
