package DataStructures

object Fundamentals extends App{
    //list of prime numbers
    val nums = 2 to 100
    def isPrime(i: Int) = {
        if(i < 0)
            false
        if(i == 2)
            true
        else
            !(2 until i). exists(n => i % n == 0)
    }
    // def isP(x: Int) = x match {
    //     case x < 0 => false
    //     case (x == 2) => true
    //     case _ => !(2 until _).exists(i % _ == 0)
    // } 
    val kkk = nums.filter(isPrime)
    println(kkk)


    val primes: Stream[Int] = 2 #:: Stream.from(3).filter{ x =>
            val sqrtOfPrimes = primes.takeWhile{y =>
                y <= math.sqrt(x)
            }
            !sqrtOfPrimes.exists(y => x%y == 0)
    }

    println(primes.take(15).toList)

    def decToBinConv(x: Int): String = {
        val seqOfDivByTwo = Iterator.iterate(x)(a => a/2)
        val binList = seqOfDivByTwo.takeWhile(a => a > 0).map(a => a%2)
        binList.mkString.reverse
    }
    println(decToBinConv(5))

    def findContSubArrayMax(data: Vector[Int]): Int =
        data match {
            case Vector(x) => x
            case _ => {
                val (l, r) = data.splitAt(data.length / 2)
                val leftMax = findContSubArrayMax(l)
                val rightMax = findContSubArrayMax(r)
                val leftRightCrossMaxVal = leftRightCrossMax(l,r)
                List(leftMax, rightMax, leftRightCrossMaxVal).max
            }
        }
    def leftRightCrossMax(leftSub: Vector[Int], rightSub:Vector[Int]): Int = {
        val collLeftSums = for(i <- 1 to leftSub.length) yield leftSub.takeRight(i).sum
        val collRightSums = for(i <- 1 to rightSub.length) yield rightSub.take(i).sum
        collLeftSums.max + collRightSums.max
    }

    val stockPriceDiff = Vector(1, -2, 5, 6, -1, 4, 9, -3, 2, 5)
    println(findContSubArrayMax(stockPriceDiff))

   case class Selection(perimeter: Int, gardenNets: List[Int])

    def selectNets(perimeter: Int, netLengths: Array[Int]):List[Int] = {
        val finalSelection = netLengths.foldLeft(Selection(perimeter, List())) {
            (selection, length) => {
                val numbers = selection.perimeter / length
                val netsToBuy = List.fill(numbers)(length)
                Selection(selection.perimeter - numbers * length,
                          selection.gardenNets ::: netsToBuy)
            }
        }
        finalSelection.gardenNets
    }

//    numbers = 0/1 [0]
//    netsToBuy = List()
//    2-2
//    Selection(5, List(15,15,15))
//    Selection(5, List(15,15,15))
//    Selection(2, List(15,15,15,3))
//    Selection(0, List(15,15,15,3,2))

    val gardenNetLengths = Array(15,10,3,2,1)
    val perimeter = 50
    println(selectNets(perimeter, gardenNetLengths))
}
