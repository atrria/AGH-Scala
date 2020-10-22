/*
Exercise 2
The exercise is about using tail-recursive function to sum fractions 1/(2^n): 1, 1/2, 1/4, 1/8, 1/16 etc...
The summation should stop when the value of the fraction to be added in the next recursion is less that a precision parameter passed as an argument.
example invocation:

	val sum1 = sumfrac( 1e-3 )
	val sum2 = sumfrac( 1e-9 )
Technique using default parameters or inner function can be used.
 */

object exercise2
{
	// version 1 with default params
	@scala.annotation.tailrec
	def sumfrac2(e: Double, frac: Double = 1, fracSum: Double = 0): Double =
	{
		if (frac < e) fracSum else sumfrac2(e, frac / 2, fracSum + frac)
	}
	
	// version 2 with inner function
	def sumfrac(e: Double): Double =
	{
		@scala.annotation.tailrec
		def sum(e: Double, currentSum: Double, frac: Double): Double = if (frac < e) currentSum else sum(e, currentSum + frac, frac / 2.0)
		
		sum(e, 0, 1)
	}
	
	def main(args: Array[String]): Unit =
	{
		val sum1 = sumfrac(1e-3)
		val sum2 = sumfrac(1e-9)
		println(sum1)
		println(sum2)
	}
}
