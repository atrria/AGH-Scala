/*
Exercise 2
It is about expressions matching. We have a data:
 val data = List( Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
    Map("company" -> "ABB", "origin" -> "Sweden"),
    Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
    Map("company" -> "F4", "origin" -> "Poland"),
    List("Cos", "innego"),
    Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
    Map("company" -> "AGH", "origin" -> "Poland"),
    Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
  )
We want to have function that will extract from it all companies. During the extraction, a class Company (trivial case class can be used) should be created.
getCompanies(data) should result in:
List(Company(ABB,Sweden), Company(F4,Poland), Company(Salina Bochnia,Poland), Company(AGH,Poland))
 */

object exercise2
{
	def main(args: Array[String]): Unit =
	{
		val data = List(Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
			Map("company" -> "ABB", "origin" -> "Sweden"),
			Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
			Map("company" -> "F4", "origin" -> "Poland"),
			List("Cos", "innego"),
			Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
			Map("company" -> "AGH", "origin" -> "Poland"),
			Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14"))
		println(getCompanies(data))
	}
	
	case class Company(name:String, country:String)
	
	def getCompanies(data:List[Any]):List[Company] =
	{
		filterCompanies(
			data.map{
			case m: Map[String, String] if m contains "company" => Company(m("company"), m("origin"))
			case _ => Nil
			}
		)
	}
	
	def filterCompanies(list: List[Any]): List[Company] = list.filter(_.isInstanceOf[Company]).asInstanceOf[List[Company]]
}
