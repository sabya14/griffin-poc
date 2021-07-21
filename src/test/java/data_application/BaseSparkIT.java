package data_application;

import com.holdenkarau.spark.testing.SharedJavaSparkContext;
import lombok.Getter;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseSparkIT extends SharedJavaSparkContext {

    // We create spark session from spark context as spark fast test does not provide us with spark session.
    @Getter
    protected SparkSession sparkSession;


    @BeforeEach
    protected void setUp() throws Exception {
        super.runBefore();
        sparkSession = SparkSession.builder().sparkContext(sc()).getOrCreate();
        sparkSession.sparkContext().setLogLevel("ERROR");
    }

    @Override
    public SparkConf conf() {
        return super.conf()
                .set("spark.ui.port", "4040")
                .set("spark.ui.enabled", "true");

    }

    @AfterAll
    static void afterAll() {
        SharedJavaSparkContext.runAfterClass();
    }

}
