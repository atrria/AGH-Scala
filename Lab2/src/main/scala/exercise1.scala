/*
Exercise 1
The goal is to generate natural numbers that are not squares of some other natural numbers up to a value N.
//////own note: these are simply not perfect squares
For N == 11 the result should be:
2 3 5 6 7 8 10 11 (4 and 9 should not be printed)
The N should be passed from the command line. If nothing is passed then 50 first natural numbers need to be printed.
//////own note: not 50 first natural numbers but numbers generated in range 1 to 50
Reminder: 6 points, time max 30 minutes, no help except scala console
The solution that looks like C/Java program will win only 4 points. Scala specific features need to be used.
 */

object exercise1
{
	def generateNumbers(N: Int): Unit = (for { i <- 1 to N if Math.pow(Math.sqrt(i).toInt, 2) != i} yield i).foreach(println)
	
	def main(args: Array[String]): Unit =
	{
		val N = if (args.length == 0) 50 else args(0).toInt
		generateNumbers(N)
	}
}
