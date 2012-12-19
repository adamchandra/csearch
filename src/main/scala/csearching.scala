package acs.csearch

// Register a directory for indexing
// "touch" a directory for re-indexing
// run csearch, format results like: 


// o HCursor extends HCursors
// st History t Historys 
// o History extends Historys
// st Op



object csearching extends App {


  override def main(args: Array[String]) = {
    val sampleCsearchOutput = """
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/HCursor.scala:75:object HCursor extends HCursors {
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/History.scala:4:sealed trait History {
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/History.scala:23:trait Historys {
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/History.scala:46:object History extends Historys
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/Op.scala:7:sealed trait Op {
    |/home/saunders/projects/the-livingroom/dvcs-mirrors/github.com/scalaz@github.com/scalaz-7/xml/src/main/scala/scalaz/xml/cursor/Op.scala:197:private case clas
    """.trim.stripMargin.split("\n").toList.map(_.trim)


    // println(sampleCsearchOutput)


    val asdf = for {
      lines <- sampleCsearchOutput.map(_.split(":", 3)).toList
      csvs <- lines
    } yield csvs // .map("\"" + _.replaceAll("\"", "\"\"") + "\"")


    println(asdf)
    
  }

}




