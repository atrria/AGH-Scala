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
