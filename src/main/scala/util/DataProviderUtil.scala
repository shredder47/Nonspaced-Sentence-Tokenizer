package util

import scala.io.{BufferedSource, Source}

object DataProviderUtil{

  //Reading WordFreq
  private val wordFreqSource: BufferedSource = Source.fromFile("target/scala-2.13/test-classes/word_freq.dict")

  private val wordFreqMap: Map[String, Double] = wordFreqSource
    .getLines()
    .filterNot(_.isEmpty)
    .map(x => {
      val strings = x.split(",")
      (strings(0), strings(1).toDouble)
    }).toMap

  wordFreqSource.close()

  def getWordFreqMap(): Map[String, Double] = wordFreqMap

}


