abstract class Plants() extends Food
{
	override def toString: String = "Plants"
}

class Carrot() extends Plants
{
	override def toString: String = "Carrot"
}

abstract class Animal()
{
	type T
	def eat(T: T)
}

trait Food
{
	override def toString: String = "Food"
}

trait Meat
{
	override def toString: String = "Meat"
}

class Rabbit() extends Animal with Meat
{
	override type T = Plants
	
	override def toString: String = "Rabbit"
	
	override def eat(T: T): Unit =
	{
		println(this + " crunches the " + T)
	}
}

class Wolf() extends Animal
{
	override type T = Meat
	
	override def toString: String = "Wolf"
	
	override def eat(T: T): Unit =
	{
		println(this + " tears apart the " + T)
	}
}
