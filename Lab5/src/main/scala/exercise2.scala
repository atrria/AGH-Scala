/*
Exercise 2
In the exercise we need to write classes hierarchy with a very rich interface for operations on color.

In particular, those methods need to be available. Copy/paste approach is not acceptable. Also the base class should not provide all the functionality.
 color : Tuple3[Int,Int,Int]()
 setColor(Int,Int,Int)
 red: Int
 green: Int
 blue: Int
 increaseRedBy(redPercentage: float): Unit
 increaseGreenBy(...)
 increaseBlueBy(...)
 decreaseRedBy(redPercentage: float)
 decraaseGreenBy(...)
 decreaseBlueBy(...)
 
expected result:
Triangle of side size 50 rotation 90 At (0,0)
Triangle of side size 25 rotation 30 At (0,0) with color r:255 g: 0 b: 70
Square of size 10 At (3,-3)
Square of size 12 At (3,3) with color r:10 g: 178 b: 0
 */

import Color._

object exercise2
{
	def main(args: Array[String]): Unit =
	{
		val a = ColorTriangle(center=(0,0), rotation=30, size=25, color=(20,20, 120))
		a.setColor(100,0,70)
		a.increaseRedBy(2.0) // czerwony = czerwony + czerwony*2
		val b = ColorSquare(center=(3,3), size=12, color=(20,20, 120) )
		b.setColor(10, 255, 0)
		b.decreaseGreenBy(0.3)
		// itd ...
		val shapes = List[Shape]( Triangle((0,0), 90, 50), a, Square((3,-3), 10), b )
		println(shapes.mkString("\n"))
		
	}
	
}
