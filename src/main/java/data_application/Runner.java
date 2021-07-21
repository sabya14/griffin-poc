package data_application;

import data_application.spark_utils.SparkUtils;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.logging.Logger;

public class Runner {
    static Logger logger = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        String appName = "data_application";
        try {
            SparkUtils sparkUtils = new SparkUtils(appName);
            SparkSession sparkSession = sparkUtils.getSparkSession();
            logger.info("Starting spark application");
            Job job = new Job(sparkSession);
            job.run();

        } catch (IOException e) {
            logger.info("Failed to start log application");
            e.printStackTrace();
        }
    }
}
