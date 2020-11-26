/*
Exercise 2
  The goal is to write a covariant (therefore the name) container for a Pair of objects of the same type. Functionality as in example code.
  class A { override def toString: String = "A" }
  class B( val x: Int) extends A { override def toString: String = "B:"+x.toString }
  class C( x: Int) extends B(x) { override def toString: String = "C:"+x.toString }
  val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
  println(a(0))
  println(a(1))
  println(a)
  val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new C(77)) // covariantnes
  println(b)
  // val c: TwistedMonoTuple[A] = new TwistedMonoTuple[B](new B(9), new A) // should not compile, covariantness
  val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair
  println(d1)
  val tA : TwistedMonoPair[A] = d1
  //val tB : TwistedMonoPair[B] = d1// can not compile
  val d2 = b.replace(1)(new A) // as above, but replaced is the second el
  println(d2)
 */

object exercise2
{
	
	class A
	{
		override def toString: String = "A"
	}
	
	class B(val x: Int) extends A
	{
		override def toString: String = "B:" + x.toString
	}
	
	class C(x: Int) extends B(x)
	{
		override def toString: String = "C:" + x.toString
	}
	
	case class TwistedMonoPair[+T](t: (T, T))
	{
		def apply(i: Int): T = if (i == 0) t._1 else t._2
		
		override def toString: String = t._1.toString + " " + t._2.toString
		
		def replace[U >: T](i: Int)(other: U): TwistedMonoPair[U] =
			if (i == 0) new TwistedMonoPair[U](t.copy(_1 = other)) else new TwistedMonoPair[U](t.copy(_2 = other))
	}
	
	def main(args: Array[String]): Unit =
	{
		val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
		println(a(0))
		println(a(1))
		println(a)
		val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new C(77)) // covariantnes
		println(b)
		//val c: TwistedMonoTuple[A] = new TwistedMonoTuple[B](new B(9), new A) // should not compile, covariantness
		val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair
		println(d1)
		val tA: TwistedMonoPair[A] = d1
		//val tB : TwistedMonoPair[B] = d1// can not compile
		val d2 = b.replace(1)(new A) // as above, but replaced is the second el
		println(d2)
	}
}
