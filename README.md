#split words without space #split words cluttered together #split sentence without spaces

Nonspaced sentence Tokenizer! Tokenizes sentences which contains no spaces in between.

Use case :
----------
Sometimes we come across requirements like splitting sentences that has no space in between : Example -> howareyouding? whatisyourname? etc et
This code can extract the token.

Usage Example :
--------------

println(Tokenizer.splitSentenceToTokens("hellohowareyoubro"))

println(Tokenizer.splitSentenceToTokens("howisitgoing?"))

println(Tokenizer.splitSentenceToTokens("whatisyourname?"))

println(Tokenizer.splitSentenceToTokens("enemyatthegates"))

Output
------

List(hello, how, are, you, bro)

List(how, is, it, going, ?)

List(what, is, your, name, ?)

List(enemy, at, the, gates)


Special Thanks to #Generic Human for a good explanation about the implementation using Ziph's law. And a handy dataset from Wiki by him. https://controlc.com/c1666a6b
