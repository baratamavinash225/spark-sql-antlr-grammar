package com.spark.sql.parser


import com.tesco.katana.mustache.config.Constants
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}

case class SqlParserResult(tree: ParseTree, treeStr: String)

object AntlrSqlQueryParser extends App{

  def parse(sqlFilePath: String): String ={
    var status = ""

    val inputStream: CharStream = CharStreams.fromFileName(sqlFilePath);
    val lexer: SparksqlLexer = new SparksqlLexer(inputStream)
    val tokens: CommonTokenStream = new CommonTokenStream(lexer)
    val parser: SparksqlParser = new SparksqlParser(tokens)

    parser.addErrorListener(new CustomErrorListener())
    try {
      val tree = parser.singleStatement()
      val treeStr = tree.toStringTree(parser)
      SqlParserResult(tree, treeStr)
      print(treeStr)
      status = Constants.successStts
    }
    catch {
      case ex: SqlInvalidException => status = "ANTLR PARSE ERROR" + ex.getMessage()
      case ex: Throwable => status = "ERROR" + ex.getMessage()
      }
    status
    }
}
