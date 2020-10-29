import scala.annotation.tailrec

/*
Exercise 1
The goal is to write tail-recursive functions. One that filters the list 'filterList' and another that inverts it 'reverseList'.
As a result of the first function a list with elements that satisfy predicate should be returned.
e.g. filterList(List("Hello", "there", "people"), _.contains('p')) would return list with one element contains word "people".
 */

object exercise1
{
	def filterList(list: List[String], f: String => Boolean): List[String] =
	{
		@tailrec
		def recursion(l: List[String], a: List[String]): List[String] =
		{
			l match {
				case Nil => a
				case h :: t if f(h) => recursion(t, a :+ h)
				case _ :: t => recursion(t, a)
			}
		}
		
		recursion(list, List())
	}
	
	def reverseList(list: List[String]): List[String] =
	{
		@tailrec
		def iterate(l: List[String], a: List[String]): List[String] =
		l match {
			case Nil => a
			case h :: t => iterate(t, h::a)
		}
		
		iterate(list, List())
	}
	
	def main(args: Array[String]): Unit =
	{
		println(filterList(List("Hello", "power", "there", "people"), _.contains("p")))
		println(reverseList(List("Hello", "power", "there", "people")))
	}
}
