object exercise1b
{
	def main(args: Array[String]): Unit =
	{
		val x = Array.ofDim[Int](4, 5)
		val x2 = Array.ofDim[Int](4, 5)
		for (i <- 0 until 4; j <- 0 until 5) x(i)(j) = i + j
		for (i <- 0 until 4; j <- 0 until 5) x2(i)(j) = i + j + 5
		
		arrPrint(x)
		sumOfRowColumn(x)._1.foreach(println)
		sumOfRowColumn(x)._2.foreach(println)
		
		arrPrint(arrMerge(x, x2))
	}
	def arrPrint(arr: Array[Array[Int]]) : Unit = for(i <- arr) print(i.mkString("|", " ", "|\n"))
	
	def sumOfRowColumn(arr: Array[Array[Int]]) : (Array[Int], Array[Int])  =
	{
		val row = Array.ofDim[Int](arr.length)
		val column = Array.ofDim[Int](arr.head.length)
		
		for (i <- 0 until arr.length)
		{
			for (j <- 0 until arr.head.length)
			{
				column(j) = column(j) + arr(i)(j)
			}
		}
		
		for (i <- 0 until arr.head.length)
		{
			for (j <- 0 until arr.length)
			{
				row(j) = column(j) + arr(j)(i)
			}
		}
		
		(row, column)
	}
	
	def arrTransposed(arr: Array[Array[Int]]): Unit = arr.transpose
	
	def arrMerge(x: Array[Array[Int]], y: Array[Array[Int]]): Array[Array[Int]] =
	{
		val arr = Array.ofDim[Int](x.length, x.head.length)
		for ( i<- 0 until x.length)
		{
			for (j<- 0 until x.head.length)
			{
				arr(i)(j) = Math.max(x(i)(j),y(i)(j))
			}
		}
		arr
	}
}
