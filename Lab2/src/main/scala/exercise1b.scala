/*
Exercise 1b
The goal of the first exercise is to calculate values of trigonometric functions of an angle given as command-line argument.
The angle can be given in degrees or radians. In an example, the argument can be 30 deg or 0.2 rad.
In the program then values of cosine and sine, tangens and angles:
x - 10 deg.
x - 9 deg.
x - 8 deg
...
x + 1deg
...
x + 10 deg
(assuming that the x is the angle given in command line).
 */

object exercise1b
{
	def main(args: Array[String]): Unit =
	{
		val N = if (args(1) == "deg") Math.PI / 180 * args(0).toDouble else args(0).toDouble
		
		def printTrig(trigFun: Double => Double): Unit =
		{
			for (i <- -10 to 10 by 1)
			{
				println(s"${args(0)} ${args(1)} ${if (i >= 0) "+" else ""}$i deg = ${trigFun(N + Math.PI / 180 * i)}")
			}
			println
		}
		
		println("Cosine:")
		printTrig(Math.cos)
		
		println("Sine:")
		printTrig(Math.sin)
		
		println("Tangent:")
		printTrig(Math.tan)
	}
}
