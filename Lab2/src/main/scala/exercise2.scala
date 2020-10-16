/*
Exercise 2
The program to write is supposed to calculate the value of the number  PI.
It can be estimated as follows:
- generate pairs of random numbers in the range 0 to 1,
for each generated point check if the distance to 0,0 is smaller than 1
repeat above two steps N times and count how many times the  point is in the circle (insideN)
the estimate of PI value is then 4.0*( insideN / N)
The program should be written in a maximally functional way (in practice no var).
Again solution a la C/Java is not good == no points
 */

import scala.util.Random

object exercise2
{
	def main(args: Array[String]): Unit =
	{
		// version 1:
		def calculatePI(): Double =
		{
			val generator = new Random
			val N = 10000000
			
			def calculateDistance(x: Double, y: Double): Double = x * x + y * y
			
			// for-comprehension
			4.0 * (for {_ <- 1 to N if calculateDistance(generator.nextDouble(), generator.nextDouble()) < 1} yield 1).sum / N
		}
		
		// version 2:
		def calculatePI2(): Double =
		{
			val generator = new Random
			val N = 10000000
			
			// generator
			val pointsSeq = for {_ <- 1 to N} yield (generator.nextDouble(), generator.nextDouble())
			
			def isInCircle(point: (Double, Double)): Boolean = point._1 * point._1 + point._2 * point._2 < 1
			
			4.0 * pointsSeq.count(isInCircle) / N
		}
		
		// version 1:
		def calculatePI3(): Double =
		{
			val generator = new Random
			val N = 10000000
			
			// generator
			val pointsSeq = for {_ <- 1 to N} yield (generator.nextDouble(), generator.nextDouble())
			4.0 * pointsSeq.count(i => i._1 * i._1 + i._2 * i._2 < 1) / N
		}
		
		println(calculatePI())
		println(calculatePI2())
		println(calculatePI3())
	}
}
