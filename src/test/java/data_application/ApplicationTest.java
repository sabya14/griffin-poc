package data_application;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends BaseSparkIT {

    @Test
    void shouldGetSparkSession() {
        Dataset<Row> rowDataset = sparkSession.emptyDataFrame();
        assertEquals(rowDataset.count(), 0);
    }
}