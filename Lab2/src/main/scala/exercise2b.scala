/*
Exercise 2b:
We have a 2D array:
val x = Array.ofDim[Int](4, 4);
for (i <- 0 until 4; j <- 0 until 4) x(i)(j) = i + j
We want to have a function: nicePrint taking that array as an argument and making nice printout like this:
|0 1 2 3|
|1 2 3 4|
|2 3 4 5|
|3 4 5 6|
Each row has to be printed by an additional, inner function called niceRowPrint.
 */

object exercise2b
{
	def main(args: Array[String]): Unit =
	{
		val x = Array.ofDim[Int](4, 4)
		for (i <- 0 until 4; j <- 0 until 4) x(i)(j) = i + j
		
		def niceRowPrint(row: Array[Int]): Unit = print(row.mkString("|", " ", "|\n"))
		
		def nicePrint(arr: Array[Array[Int]]): Unit =
		{
			for (i <- arr) niceRowPrint(i)
			
			//for (i<- arr.indices) niceRowPrint(arr(i))
			//for (i<- 0 until arr.length) niceRowPrint(arr(i))
		}
		
		nicePrint(x)
		
		// niceRowPrint without .mkString
		/*def niceRowPrint(row: Array[Int]): Unit =
		{
			/*print(s"|${row(0)}")
			for (i <- 1 until row.length) print(s" ${row(i)}")
			println("|")*/
		}*/
	}
}
