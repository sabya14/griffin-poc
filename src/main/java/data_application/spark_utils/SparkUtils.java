package data_application.spark_utils;

import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.Properties;

public class SparkUtils {
    String appName;
    Properties properties;

    public SparkUtils(String appName) throws IOException {
        this.appName = appName;
        properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResource("application.properties").openStream());

    }

    public SparkSession getSparkSession() {
        SparkSession spark = SparkSession
                .builder()
                .appName(appName)
                .master(System.getenv().getOrDefault("SPARK_MASTER_URL", "spark://localhost:7077"))
                .config("spark.sql.shuffle.partitions", properties.getOrDefault("spark.sql.shuffle.partitions", "8").toString())
                .config("spark.default.parallelism", properties.getOrDefault("spark.default.parallelism", "8").toString())
                .getOrCreate();
        return spark;
    }
}
