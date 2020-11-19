/*
Exercise 1
In this exercise a functional class Complex needs to be written. It should be written in such a way that the example below works:
val x = Complex(1,2)
val y = Complex(3,2)
println("x " + x + " y " + y + " x+y " +(x+y) + " x-y " +(x-y))
val f = Complex.polar(r=3, angle=math.Pi)
println(f)
println( "|x| "+ x.r + " angle " +x.angle)

// expected result
x Re:{1.0} Im:{2.0} y Re:{3.0} Im:{2.0} x+y Re:{4.0} Im:{4.0} x-y Re:{-2.0} Im:{0.0}
Re:{-3.0} Im:{3.6739403974420594E-16}
|x| 2.23606797749979 angle 1.1071487177940904
*/

object exercise1
{
	def main(args: Array[String]): Unit =
	{
		val x = Complex(1, 2)
		val y = Complex(3, 2)
		println("x " + x + " y " + y + " x+y " + (x + y) + " x-y " + (x - y))
		val f = Complex.polar(r = 3, angle = math.Pi)
		println(f)
		println("|x| " + x.r + " angle " + x.angle)
	}
}
