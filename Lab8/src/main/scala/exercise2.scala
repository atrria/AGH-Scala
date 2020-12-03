/*
Exercise 2
 The goal of the exercise is to use scala collections in order to perform various tasks.
 We have a list of people:
 val people = List( ("John", "Doe", 23, "male"), ("Joan", "Doe", 23, "female"), ("Steve", "Jenkins", 24, "male"), ("Eva", "Robinson", 25, "female"),
 ("Ben", "Who", 22, "male"), ("Janet", "Reed", 21, "female"), ("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female") )
 The meaning of fields is obvious.

 Using collections API (simple for loop solutions are excluded) print the following information.
 - Print list of females and list of males.
 - Obtain names of all people of age above 23.
 - Check if among the people on the list there is someone of name Joe and John.
 - Check if everyone is older than 20.
 - Obtain a list of First names and age.
 - Group all people by age.
 - Split the list of people into younger and older than 23.
 - Find the oldest and youngest.
 - In a single set of transformations check if the number of males and females in the list is identical.
 - Obtain a sorted list of people of age above 23 with dropWhile and sort.
 */

object exercise2
{
	def printDecor(): Unit = println("----------------------------------------------------------------------------------------------")
	
	def main(args: Array[String]): Unit =
	{
		val people = List(("John", "Doe", 23, "male"), ("Joan", "Doe", 23, "female"), ("Steve", "Jenkins", 24, "male"),
			("Eva", "Robinson", 25, "female"), ("Ben", "Who", 22, "male"), ("Janet", "Reed", 21, "female"),
			("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female"))
		
		println("Males:")
		println(people.filter(_._4 == "male"))
		printDecor()
		
		println("Females:")
		println(people.filter(_._4 == "female"))
		printDecor()
		
		println("Names of people above age 23:")
		println(people.filter(_._3 > 23).map(_._1))
		printDecor()
		
		println("John or Joe found:")
		println(people.exists(_._1 == "John") || people.exists(_._1 == "Joe"))
		printDecor()
		
		println("Everyone older than 20: ")
		println(people.filterNot(_._3 <= 20).length == people.length)
		printDecor()
		
		println("List of names and ages:")
		println(people.map(_._1) ++ people.map(_._3))
		printDecor()
		
		println("People grouped by age:")
		println(people.groupBy(_._3))
		printDecor()
		
		println("Younger than 23:")
		println(people.partition(_._3 <= 23)._1)
		println("Older than 23:")
		println(people.partition(_._3 <= 23)._2)
		printDecor()
		
		println("Oldest:")
		println(people.maxBy(_._3))
		println("Youngest:")
		println(people.minBy(_._3))
		printDecor()
		
		println("Equal number of males and females:")
		println(people.count
		{ _._4 == "female" } == people.length / 2)
		printDecor()
		
		println("Sorted list of people of age above 23:")
		println(people.sortBy(_._3).dropWhile(_._3 <= 23))
		printDecor()
	}
}
