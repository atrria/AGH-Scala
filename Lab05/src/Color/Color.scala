package Color {
	
	abstract class Shape(val center: (Int, Int), size: Int)
	
	class Triangle(center: (Int, Int), val rotation: Int, val size: Int) extends Shape(center, size)
	{
		override def toString: String = "Triangle of side size " + size + " rotation " + rotation + " At (" + center._1 + "," + center._2 + ")"
	}
	
	object Triangle
	{
		def apply(center: (Int, Int), rotation: Int, size: Int): Triangle = new Triangle(center, rotation, size)
	}
	
	class ColorTriangle(center: (Int, Int), rotation: Int, size: Int, var color: (Int, Int, Int)) extends Triangle(center = center, rotation = rotation, size = size)
	{
		def red: Int = color._1
		
		def green: Int = color._2
		
		def blue: Int = color._3
		
		def setColor(r: Int, g: Int, b: Int): Unit = color = (r, g, b)
		
		def increaseRedBy(r: Double): Unit = color = color.copy(_1 = if ((color._1 + color._1 * r).toInt > 255) 255 else (color._1 + color._1 * r).toInt)
		
		def increaseGreenBy(g: Double): Unit = color = color.copy(_2 = if ((color._2 + color._2 * g).toInt > 255) 255 else (color._2 + color._2 * g).toInt)
		
		def increaseBlueBy(b: Double): Unit = color = color.copy(_3 = if ((color._3 + color._3 * b).toInt > 255) 255 else (color._3 + color._3 * b).toInt)
		
		def decreaseRedBy(r: Double): Unit = color = color.copy(_1 = if ((color._1 - color._1 * r).toInt > 255) 255 else (color._1 - color._1 * r).toInt)
		
		def decreaseGreenBy(g: Double): Unit = color = color.copy(_2 = if ((color._2 - color._2 * g).toInt > 255) 255 else (color._2 - color._2 * g).toInt)
		
		def decreaseBlueBy(b: Double): Unit = color = color.copy(_3 = if ((color._3 - color._3 * b).toInt > 255) 255 else (color._3 - color._3 * b).toInt)
		
		override def toString: String = super.toString + " with color r:" + color._1.toInt + " g:" + color._2.toInt + " b:" + color._3.toInt
	}
	
	object ColorTriangle
	{
		def apply(center: (Int, Int), rotation: Int, size: Int, color: (Int, Int, Int)): ColorTriangle = new ColorTriangle(center, rotation, size, color)
	}
	
	class Square(center: (Int, Int), size: Int) extends Shape(center = center, size = size)
	{
		override def toString: String = "Square of size " + size + " At (" + center._1 + "," + center._2 + ")"
	}
	
	object Square
	{
		def apply(center: (Int, Int), size: Int): Square = new Square(center, size)
	}
	
	class ColorSquare(center: (Int, Int), size: Int, var color: (Int, Int, Int)) extends Square(center = center, size = size)
	{
		def red: Int = color._1
		
		def green: Int = color._2
		
		def blue: Int = color._3
		
		def setColor(r: Int, g: Int, b: Int): Unit = color = (r, g, b)
		
		def increaseRedBy(r: Double): Unit = color = color.copy(_1 = if ((color._1 + color._1 * r).toInt > 255) 255 else (color._1 + color._1 * r).toInt)
		
		def increaseGreenBy(g: Double): Unit = color = color.copy(_2 = if ((color._2 + color._2 * g).toInt > 255) 255 else (color._2 + color._2 * g).toInt)
		
		def increaseBlueBy(b: Double): Unit = color = color.copy(_3 = if ((color._3 + color._3 * b).toInt > 255) 255 else (color._3 + color._3 * b).toInt)
		
		def decreaseRedBy(r: Double): Unit = color = color.copy(_1 = if ((color._1 - color._1 * r).toInt > 255) 255 else (color._1 - color._1 * r).toInt)
		
		def decreaseGreenBy(g: Double): Unit = color = color.copy(_2 = if ((color._2 - color._2 * g).toInt > 255) 255 else (color._2 - color._2 * g).toInt)
		
		def decreaseBlueBy(b: Double): Unit = color = color.copy(_3 = if ((color._3 - color._3 * b).toInt > 255) 255 else (color._3 - color._3 * b).toInt)
		
		override def toString: String = super.toString + " with color r:" + color._1.toInt + " g:" + color._2.toInt + " b:" + color._3.toInt
	}
	
	object ColorSquare
	{
		def apply(center: (Int, Int), size: Int, color: (Int, Int, Int)): ColorSquare = new ColorSquare(center, size, color)
	}
	
}