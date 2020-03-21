object Main extends App {
  HiveProcessor.save(Utils.getTop100FileName)
  HiveProcessor.save(Utils.getTop100PerCountry)
  HiveProcessor.save(Utils.getCategoryView)
  HiveProcessor.save(Utils.getDislikeOverLike)
  HiveProcessor.save(Utils.getMultipleRecords)
}
