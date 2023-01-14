package DataStructures

object WorkBook extends App{
  val myNumbers = Array(0,2,4,6,8,10)
  println(myNumbers(5))

  val numMult2 = myNumbers.map(_ * 2)
  numMult2.foreach(println)

  val findEven = myNumbers.find(_ % 2 == 0)
  val extractEven = findEven match{
    case Some(x) => s"number: $x"
    case None => "Nothing Here"
  }

  println(findEven.getOrElse("Nothing Here"))

  println(extractEven)

  val counts = Array("900,google.com",
"60,mail.yahoo.com",
"10,mobile.sports.yahoo.com",
"40,sports.yahoo.com",
"10,stackoverflow.com",
"2,en.wikipedia.org",
"1,es.wikipedia.org",
"1,mobile.sports")
  val splitCounts = counts.map(_.split(",")).map{
                                                   case Array(a,b) => (a,b)
                                                 }
  val addedCounts = splitCounts.map{
                                      case (x,y) if y.endsWith(".com") => x.toInt
                                      case _ => 0
                                    }.reduceLeft(_+_)
  println(addedCounts)

  val splitDomains = counts.map(x => x.split(",")).map{
    case Array(a,b) => (a,b.split("."))
  }


  val coupledDomains = splitDomains.flatMap{
    case (a, b) => b.map{ domain =>
      (domain, a.toInt)
    }
  }

  val groupedDomains = coupledDomains.groupBy(_._1)//.map{
    //case (k,Array(v1,v2)) => k -> (v2).sum
  //}
  groupedDomains.foreach{case(k,v) => println(v)}

  //val cd = coupledDomains.map{case (x,y) => x+" and  "+y}
//  val aggData = coupledDomains.foldLeft(0.0 -> 0){case ((a0,b0),(a1,b1)) => if(b0 == b1) (a0+a1, b0) else (a0,b0)}

//  cd.foreach(println)
}
