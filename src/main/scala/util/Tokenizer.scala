package util

object Tokenizer {


  private val wordFreqMap: Map[String, Double] = DataProviderUtil.getWordFreqMap()
  private val maxLengthWord: Int = wordFreqMap.keys.maxBy(_.length).length


  def splitSentenceToTokens(originalString: String): List[String] = {

    var matchCostList: Seq[Double] = List(0)

    for (i <- 1 to (originalString.length)) {
      val tuple: (Double, Int) = matchCalculator(i, matchCostList, originalString)
      matchCostList = matchCostList :+ tuple._1
    }

    var outputArray: List[String] = List()
    var i = originalString.length
    while (i > 0) {

      val tuple: (Double, Int) = matchCalculator(i, matchCostList, originalString)
      val matchLength = tuple._2
      outputArray = outputArray :+ originalString.slice((i - matchLength), i)
      i = i - matchLength;
    }
    return outputArray.reverse
  }

  //Helpers//
  private def matchCalculator(i: Int, costList: Seq[Double], originalString: String): (Double, Int) = {
    val startIndex = i - maxLengthWord
    val finalStartIndex: Int = List(0, startIndex).max

    val candidates: Seq[Double] = costList.slice(finalStartIndex, i).reverse

    val tuples: Seq[(Double, Int)] = candidates.zipWithIndex.map(currentCandidate => {
      val index: Int = currentCandidate._2
      val matchCost: Double = currentCandidate._1
      val startIndex = i - index - 1
      val wordCost: Double = wordFreqMap.getOrElse(originalString.slice(startIndex, i), 9e99) //9e99 represents infinity

      ((matchCost + wordCost), index + 1)
    })
    //(matchCost, matchLength).
    val minimum: (Double, Int) = tuples.min
    return minimum
  }


}
