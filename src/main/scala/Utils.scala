import java.util.Properties

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

object Utils {

  def getSparkSessionForHive: SparkSession = {
    val conf = new SparkConf()
      .setAppName("HiveConnector")
      .setMaster("local[2]")

    val sparkContext = new SparkContext(conf)
    val sparkSession = SparkSession.builder()
      .appName("HiveConnector")
      .enableHiveSupport()
      .getOrCreate()
    sparkSession
  }


  def getProcessedDir: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("hdfs.processed.dir")
  }

  def getFinalOriginalFileName: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("final.original.file.name")
  }

  def getTop100FileName: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("top100.file.name")
  }

  def getTop100PerCountry: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("top100.per.country")
  }

  def getCategoryView: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("category.view")
  }

  def getDislikeOverLike: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("dislike.over.like")
  }

  def getMultipleRecords: String = {
    val properties: _root_.java.util.Properties = getProperties
    properties.getProperty("multiple.records")
  }

  private def getProperties = {
    val url = getClass.getResource("application.properties")
    val properties: Properties = new Properties()
    if (url != null) {
      val source = Source.fromURL(url)
      properties.load(source.bufferedReader())
    }
    properties
  }

}
