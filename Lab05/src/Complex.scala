class Complex(val x: Double, val y: Double)
{
	def +(other: Complex): Complex = Complex(x + other.x, y + other.y)
	
	def -(other: Complex): Complex = Complex(x - other.x, y - other.y)
	
	override def toString: String =	"Re:{" + x + "} Im:{" + y + "}"
	
	def r: Double = Math.sqrt(x * x + y * y)
	
	def angle: Double = Math.atan2(y, x)
}

object Complex
{
	def apply(x: Double, y: Double): Complex = new Complex(x, y)
	
	def polar(r: Double, angle: Double): Complex = new Complex(r * Math.cos(angle), r * Math.sin(angle))
}
