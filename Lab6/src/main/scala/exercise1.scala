/*
Exercise 1
The goal is to use traits to implement a decorator pattern. We want to be able to construct classes/objects that describe food sold in a street booth. An example of a meal could be:
val myLunch =  new Sandwitch with Butter with Salad with Egg with Mayonaise
val yourLunch = new Sandwitch with Ham
Or a whole class of foods can be created:
class ChefsBest extends Sandwitch with Butter with Salad with Ham with Cheese
I should be able to ask objects myLunch, yourLunch or any object of the class ChefsBest for the list of ingredients and the price (i.e. it should be sum of the prices of all ingredients).
println(myLuncch.price) // 5.5 exact number are not relevant of course
println(myLuncch.content) // results in List[Sandwitch, Butter, Salad Egg, Mayonaise]
 */

object exercise1
{
	def main(args: Array[String]): Unit =
	{
		val myLunch = new Sandwich with Butter with Salad with Egg with Mayonaise
		println(myLunch.price)
		println(myLunch.content)
		
		val yourLunch = new Sandwich with Ham
		println(yourLunch.price)
		println(yourLunch.content)
		
		val chefs = new ChefsBest
		println(chefs.price)
		println(chefs.content)
	}
}
