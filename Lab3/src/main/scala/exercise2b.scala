/*
The goal is to write such function that the example code below compiles and gives
expected results (on the right). Reminder, no external materials are allowed.
	println( pi )
	println( pi(pi) ) //multiplication
	println( pi(pi(pi)) )
	println(repN(5, (x: Int) => 2*x , 1 )) // repeat function application N times i.e. f(f(f(f(f(1))))), 1 the argument of the first invocation
Expected results:
	3.1415
	9.86902225 // multiplication
	31.003533398375
	32
 */

import scala.annotation.tailrec

object exercise2b
{
	def pi = 3.1415
	
	def pi(arg: Double): Double = arg * pi
	
	@tailrec
	def repN(N: Int, f: Int => Int, firstInv: Int): Int = if (N == 0) firstInv else repN(N - 1, f, f(firstInv))
	
	def main(args: Array[String]): Unit =
	{
		println(pi)
		println(pi(pi))
		println(pi(pi(pi)))
		println(repN(5, (x: Int) => 2 * x, 1))
	}
}
