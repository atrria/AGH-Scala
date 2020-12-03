/*
Exercise 1
The goal is to write classes/traits which element allow to write a hierarchy of consumers & consumed.
We want to avoid the possibility that an animal that is "designed" to eat plants accepts to eat meat and another way around.
Effectively there are two hierarchies of top classes/traits.
One with the  Food class/trait at the top and another with the Animal at the top  (they actually mix a bit for specific classes).
Following entities exist: Food, Carrot, Rabbit, Wolf, Meat, Plants, Animal.

Expected result:
  Rabbit crunches the  Carrot
  Wolf tears apart the Rabbit
 */

object exercise1
{
	def main(args: Array[String]): Unit =
	{
		val c: Plants = new Carrot
		val r = new Rabbit
		val w = new Wolf
		// this two should compile and run w/o problems
		r.eat(c)
		w.eat(r)
		// whereas these should not compile
		//r.eat(r)
		//w.eat(c)
	}
}
