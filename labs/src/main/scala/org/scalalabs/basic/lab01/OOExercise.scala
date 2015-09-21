package org.scalalabs.basic.lab01
import scala.language.implicitConversions

class Euro(val euro: Int, val cents: Int = 0) extends Currency("EUR") with Ordered[Euro] {
  
  def inCents: Int = euro * 100 + cents;
  
  def +(rightSide: Euro) = Euro.fromCents(inCents + rightSide.inCents)
  
  def *(multiplier: Int) = Euro.fromCents(multiplier * inCents)
  
  override def toString() = {
    val strCents = if (cents == 0) "--" else f"$cents%02d"
    f"$symbol: $euro,$strCents"      
  }
  
  override def compare(other: Euro) = inCents compare other.inCents
  
}

object Euro {
  
  def fromCents(cents: Int): Euro = new Euro(cents / 100, cents % 100)
  
  implicit class TransformIntToEuro(val value: Int) {
     def *(euro: Euro): Euro = euro * value 
  }
  
  implicit def TransformDollarToEuro(dollar: Dollar) 
    (implicit converter: CurrencyConverter): Euro = {
      Euro.fromCents(converter.toEuroCents(dollar.inCents))
  } 
    
  
}

abstract class Currency(val symbol: String) { }

class Dollar(val dollar: Int, val cents: Int = 0) extends Currency("DOL") { 
  def inCents: Int = dollar * 100 + cents;
  
}