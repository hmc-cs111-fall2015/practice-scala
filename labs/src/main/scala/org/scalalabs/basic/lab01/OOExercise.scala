package org.scalalabs.basic.lab01
import scala.language.implicitConversions

/*
 * Header comment changes, because it was inconsistent with other things:
 * - Changed examples of toString method to match actual test cases and example functions
 * - The conversion is from Dollar to Euro, not from Euro to Dollar
 */

/**
 * The goal of this exercise is to get familiar basic OO constructs in scala
 *
 * Fix the code so that the unit test 'CurrencyExerciseTest' passes.
 *
 * In order for the tests to pass you need to do the following:
 * 
 * Exercise 1:
 * - Create a class Euro
 * - Provide it with two constructor parameters: euro:Int, cents:Int
 * - Provide the cents field with default value: 0
 * - Provide an immutable field named: inCents that converts euro + cents into cents.
 * - Create an object Euro with a factory method named: fromCents that creates an Euro based on cents.
 * - Create a method named: + to the Euro class that adds another Euro
 * - Create a method named: * to the Euro class that multiplies an Euro by an integer
 * 
 * Exercise 2:
 * - Create an abstract class Currency
 * - Provide it with one constructor parameter: symbol:String
 * - Extend the previously created Euro class from Currency
 * - Override the toString method of Euro to represent the following String:
 *   -> symbol + ': ' + euro + ',' + cents.  E.g: EUR: 200,05
 * - In case the cents are 0 use this representation:
 *   -> symbol + ': ' + euro + ',--. E.g.: EUR: 200,--
 *   
 * OPTIONAL: Exercise 3:
 * - Mix the Ordered trait in Euro
 * - Implement the compare method  
 * 
 * OPTIONAL: Exercise 4:
 * - Provide an implicit class that adds a *(euro:Euro) method to Int
 * - Create a new currency Dollar
 * - Provide a implicit conversion method that converts from Dollar to Euro using the 
 *   [[org.scalalabs.basic.lab01.DefaultCurrencyConverter]]
 * 
 * OPTIONAL: Exercise 5:
 * - Extend the conversion method from Dollar to Euro with an implicit parameter 
 *   of type [[org.scalalabs.basic.lab01.CurrencyConverter]]
 * - Use the implicit CurrencyConverter to do the conversion. 
 */

abstract class Currency(val symbol:String) {
	
}

/**
 * A very small currency with only minimal methods.
 * Ideally most of the Euro methods would be moved to the base Currency class
 */
class Dollar(val dollar:Int, val cents:Int = 0) extends Currency("USD") {
	val inCents:Int = dollar * 100 + cents
	
	implicit def toEuro:Euro = Euro.fromCents(DefaultCurrencyConverter.toEuroCents(inCents))
}

class Euro(val euro:Int, val cents:Int = 0) extends Currency("EUR") with Ordered[Euro] {
	// Theoretically it would be better to make a CENTS_PER_EURO val instead of using 100 as a magic number everywhere.
	// However, the word “cents” means per 100; if the EU starts dividing its currency differently the variable names also change.
	val inCents:Int = euro * 100 + cents
		
	def +(that:Euro) : Euro = {
		val centSum = this.cents + that.cents
		new Euro(this.euro + that.euro + (centSum / 100), centSum % 100)
	}
	
	def *(that:Int) : Euro = Euro.fromCents (this.inCents * that)
	
	override def toString : String = {
		// Ideally much of this would be provided by system settings
		s"$symbol: $euro," + (if (cents == 0) "--" else f"$cents%02d")
	}
	
	def compare(that: Euro) : Int = this.inCents - that.inCents
}

object Euro {
	def fromCents (cents:Int) : Euro = new Euro(cents / 100, cents % 100) 
	implicit def fromDollar(dollar:Dollar)(implicit converter:CurrencyConverter):Euro = {
		Euro.fromCents (converter.toEuroCents(dollar.inCents))
	}

	implicit class IntMultiplier(i:Int) {
		def *(that:Euro) : Euro = that * i
	}
}
