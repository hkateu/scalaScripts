package Valdis
import scala.io.StdIn.readLine
import java.time.Year
import scala.io.Source

object Intro  extends App{
/*    val name = readLine("What is your name friend?")
    println(s"Glad to meet you $name")

    val age = readLine("How are you?")
    println("You are a senior")

    val year = Year.now().getValue()
    def agein100 (a: Int, y: Int) = {
        val to100: Int = 100 - a
        val year100: Int = y + to100
        s"You will be 100 in $year100"
    }
    println(agein100(age.toInt, year))
*/
    val myArgs = readLine("Enter file name")
    if(myArgs.length > 0){
        for(line <- Source.fromFile(myArgs).getLines()){
            //line.length().toString(" "+ line)
        }
    }else{
        Console.err.println("Please enter file name")
    }

}