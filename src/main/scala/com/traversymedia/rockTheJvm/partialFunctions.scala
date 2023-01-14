package com.traversymedia.rockTheJvm

object partialFunctions extends App {
    val aPartialFunc: PartialFunction[Int,Int] = {
        case 1 => 44
        case 2 => 89
        case 3 => 999
    }

    println(aPartialFunc(3))
    println(aPartialFunc.isDefinedAt(4))
    
    val lifted = aPartialFunc.lift
    println(lifted(2))
    println(lifted(5))

    val pfChained = aPartialFunc.orElse[Int,Int]{
        case 45 => 67
    }

    println(pfChained(45))

    val aTotalFunction: Int => Int = {
        case 1 => 47
        case 2 => 98
        case 3 => 95
    } 

    val aMappedList = List(1,2,3).map{
        case 1 => 45
        case 2 => 57
        case 3 => 78
    }
    println(aMappedList)

    val lousyChatBot: PartialFunction[String,String] = {
        case "Hello" => "Hi There"
        case "Ok" => "Where are you"
        case "Kampala" => "Can i come over"
    }

    scala.io.Source.stdin.getLines().foreach(line => println(lousyChatBot(line)))
    
  
}
