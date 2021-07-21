package data_application;

import lombok.AllArgsConstructor;
import org.apache.spark.sql.SparkSession;

@AllArgsConstructor
public class Job {
    SparkSession sparkSession;

    void run() {
        System.out.println("Running job");
    }
}
