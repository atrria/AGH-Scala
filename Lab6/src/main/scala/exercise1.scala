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
