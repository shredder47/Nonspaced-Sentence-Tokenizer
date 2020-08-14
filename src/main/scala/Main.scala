import util.Tokenizer

object Main extends App {

  println(Tokenizer.splitSentenceToTokens("hellohowareyoubro"))
  println(Tokenizer.splitSentenceToTokens("howisitgoing?"))
  println(Tokenizer.splitSentenceToTokens("whatisyourname?"))
  println(Tokenizer.splitSentenceToTokens("isislandagoodplacetolive??"))
  println(Tokenizer.splitSentenceToTokens("enemyatthegates"))

}
