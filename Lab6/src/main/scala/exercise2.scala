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
