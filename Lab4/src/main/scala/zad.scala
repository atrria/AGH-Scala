import MapPoint._

object zad extends App
{
	
	val krk = MapPoint("Krakow", 50.061389, 19.938333);
	
	println(krk);
	
	val nyc = MapPoint("NYC", 40.7127, -74.0059);
	
	println(nyc);
	
	val porto = MapPoint("Porto", 41.162142, -8.621953);
	
	val irkutsk = MapPoint("Irkutsk", 52.283333, 104.283333);
	
	println(irkutsk);
	
	
	
	println(porto - irkutsk)
	
	println(krk - irkutsk)
	
	println(krk.distanceTo(porto))
	
	
	val mp = inTheMiddle(krk, irkutsk, "Somwhere in Russia");
	
	println(mp + " " + (mp - krk) + " " + (mp - irkutsk))
	
	
	
	val r = Route( krk, nyc, porto )
	
	println( r );
	
	r.addStop( porto.move( 1, 1 ) )
	
	r.addStop( irkutsk )
	
	println( r )
	
	
	/* expected result

Krakow 50.061389N 19.938333E
NYC 40.7127N 74.0059W
Irkutsk 52.283333N 104.283333E
113.45168353092112
84.37426183463258
29.914654160942675
Somwhere in Russia 51.172360999999995N 62.110833E 42.18713091731629 42.18713091731629
Porto 41.162142N 8.621953W -> NYC 40.7127N 74.0059W -> Krakow 50.061389N 19.938333E
Irkutsk 52.283333N 104.283333E -> Nearby Porto 42.162142N 7.6219529999999995W -> Porto 41.162142N 8.621953W -> NYC 40.7127N 74.0059W -> Krakow 50.061389N 19.938333E

 */
	
	case class MapPoint(str: String, d: Double, d1: Double)
	{
		override def toString: String =
		{
			val signX =
				this.d match {
					case n if (n > 0) => "N"
					case s if (s < 0) => "S"
					case _ => ""
				}
			
			val signY =
				this.d1 match {
					case e if (e > 0) => "E"
					case w if (w < 0) => "W"
					case _ => ""
				}
			
			str + " " + Math.abs(this.d) + signX + " " + Math.abs(this.d1) + signY
		}
		
		def -(that: MapPoint): Double =
		{
			Math.sqrt(Math.pow(that.d - this.d, 2) + Math.pow(that.d1 - this.d1, 2))
		}
		
		def distanceTo(that: MapPoint): Double =
		{
			this - that
		}
		
		def move(x: Double, y: Double): MapPoint =
		{
			MapPoint("Nearby "+this.str, this.d+x, this.d1+y)
		}
	}
	
	def inTheMiddle(point1: MapPoint, point2: MapPoint, name: String): MapPoint =
	{
		MapPoint(name, (point1.d + point2.d) / 2.0, (point1.d1 + point2.d1) / 2.0)
	}
	
	case class Route(pts: MapPoint*)
	{
		var points: Seq[MapPoint] = pts
		
		override def toString: String =
		{
			points.reverse.mkString(" -> ")
		}
		
		def addStop(p: MapPoint): Unit =
		{
			points=points:+p
		}
	}
}