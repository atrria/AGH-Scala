abstract class ingridients
{
	def price:Double
	def content: List[String]
}

class Sandwich extends ingridients
{
	override def price: Double = 5
	override def content: List[String] = List("Sandwich")
}

trait Butter extends ingridients
{
	abstract override def price: Double = super.price+2
	abstract override def content:List[String] = super.content:+"Butter"
}

trait Egg extends ingridients
{
	abstract override def price: Double = super.price+5
	abstract override def content:List[String] = super.content:+"Egg"
}

trait Salad extends ingridients
{
	abstract override def price: Double = super.price+7
	abstract override def content:List[String] = super.content:+"Salad"
}

trait Mayonaise extends ingridients
{
	abstract override def price: Double = super.price+2
	abstract override def content:List[String] = super.content:+"Mayonaise"
}

trait Ham extends ingridients
{
	abstract override def price: Double = super.price+4
	abstract override def content:List[String] = super.content:+"Ham"
}

trait Cheese extends ingridients
{
	abstract override def price: Double = super.price+1
	abstract override def content:List[String] = super.content:+"Cheese"
}

class ChefsBest extends Sandwich with Butter with Salad with Ham with Cheese