/*
Exercise 1
The goal is to write functions that allow   code below to compile and work as expected
    println( pi ) // 3.1415
    println( pi(pi) ) // 9.86902225
    println( pi(pi(pi)) ) // 31.003533398375
    println(repN(5,  (x: Int) => 2*x , 1 )) //32
    // repeat function application N times i.e. f(f(f(f(f(1))))), 1 is the argument of the first invocation,

    printarg(arg=“hello") // hello
    printarg() // -
 */

object exercise1
{
	def pi = 3.1415
	
	def pi(arg: Double): Double = arg*pi
	
	@scala.annotation.tailrec
	def repN(N: Int, f: Int=>Int, firstInv: Int): Int =
	{
		if(N==0) firstInv else repN(N-1, f, f(firstInv))
	}
	
	def printarg(arg: => String = "-"): Unit = println(arg)
	
	def main(args: Array[String]): Unit =
	{
		println( pi ) // 3.1415
		println( pi(pi) ) // 9.86902225
		println( pi(pi(pi)) ) // 31.003533398375
		
		println(repN(5,  (x: Int) => 2*x , 1 )) //32
		// repeat function application N times i.e. f(f(f(f(f(1))))), 1 is the argument of the first invocation,
		
		printarg(arg="hello") // hello
		printarg() // -
	}
}
