/*
Exercise 1
We have a 2D array:
val x = Array.ofDim[Int](4,5);
for ( i <- 0 until 4; j <- 0 until 5) x(i)(j) = i+j
Goal is to write functions:
1) to print this array in the following form:
| 0 1 2 3 4 |
| 1 2 3 4 5 |
| 2 3 4 5 6 |
| 3 4 5 6 7 |
2) obtain two 1D arrays, one containing sum of elements in each row,
and second containing sum of elements in each column
3) to create an array that is transposed
4) merge two arrays x and y of identical sizes (here 4x5) so that each
element in the resulting array is larger of the corresponding element in
x and y
 */

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
		
		for (i <- arr.indices)
		{
			for (j <- arr.head.indices)
			{
				column(j) = column(j) + arr(i)(j)
			}
		}
		
		for (i <- arr.head.indices)
		{
			for (j <- arr.indices)
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
		for ( i<- x.indices)
		{
			for (j<- x.head.indices)
			{
				arr(i)(j) = Math.max(x(i)(j),y(i)(j))
			}
		}
		arr
	}
}
