object exercise1b
{
	def pnFun(x: Double)(n: Double) = Math.pow(x, n)
	
	def p1Fun(x: Double) = x
	
	def p2Fun(x: Double) = 2*x
	
	def eval2(listW: List[Double])(fun: (Double, Double) => Double) : Double =
	{
		val (start, rest) = listW.splitAt(1)
		val f = fun
		
		def evalOne(list: List[Double], arg: Double = 0): Double =
		{
			if (list.isEmpty) arg
			else {
				val (p, nList) = list.splitAt(1)
				evalOne(nList, fun(arg, p.head))
			}
		}
		
		evalOne(rest, start.head)
	}
	
	def eval(listW: List[Double])(fun: (Double, Double) => Double) : Double =
	{
		val (start, rest) = listW.splitAt(1)
		val f = fun
		
		def evalOne(list: List[Double], arg: Double = 0): Double =
		{
			if (list.isEmpty) arg
			else {
				val (p, nList) = list.splitAt(1)
				evalOne(nList, fun(arg, p.head))
			}
		}
		
		evalOne(rest, start.head)
	}
	
	def main(args: Array[String]): Unit =
	{
		val pn = pnFun(2)_
		val p1 = p1Fun(2)
		val p2 = p2Fun(2)
		val l1 = List(p1, p2, pn(5))
		//println(eval(l1)( 2))
	}
}
