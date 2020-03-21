
import org.apache.spark.sql.SaveMode

object HiveProcessor {

  def save(fileName: String) {
    val sourcePath = Utils.getProcessedDir + fileName
    val sparkSession = Utils.getSparkSessionForHive
    val csvDf = sparkSession.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(sourcePath)

    csvDf.write
      .mode(SaveMode.Overwrite)
      .saveAsTable(fileName.replace(".csv", ""))
    sparkSession.close()
  }

}
