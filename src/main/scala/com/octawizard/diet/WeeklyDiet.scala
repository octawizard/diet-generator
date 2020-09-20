package com.octawizard.diet

import java.time.{DayOfWeek, LocalDate}

import com.octawizard.diet.DayOfWeek.WeekDays

/**
 * Created by Roberto Manca on 19/09/2020.
 */
sealed trait DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek
case object Sunday extends DayOfWeek

object DayOfWeek {
  val WeekDays = List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
}

class WeeklyDiet(proteins: Set[Protein], vegetables: Set[Vegetable], carbs: Set[Carb]) {

  private val diet = generateDiet

  private def generateMeal(proteins: Set[Protein], vegetables: Set[Vegetable], carbs: Set[Carb]): DailyMeal = {
    val lunch = Meal(Set(randomPick(proteins)), Set(randomPick(vegetables)), randomPick(carbs))
    val dinner = Meal(Set(randomPick(proteins)), Set(randomPick(vegetables)), randomPick(carbs))
    DailyMeal(lunch, dinner)
  }

  private def generateDiet: List[(DayOfWeek,DailyMeal)] = {
    WeekDays.map( _ -> generateMeal(proteins, vegetables, carbs))
  }

  private def randomPick[T](s: Set[T]): T = {
    require(s.nonEmpty)
    val n = util.Random.nextInt(s.size)
    s.iterator.drop(n).next
  }

  override def toString: String = {
    val stringBuilder = new StringBuilder
    diet.foreach{ entry => {
      stringBuilder.append("***********\n")
      stringBuilder.append(s"* ${entry._1}\n")
      stringBuilder.append(s"*** Lunch:\t${entry._2.lunch}\n")
      stringBuilder.append(s"*** Dinner:\t${entry._2.dinner}\n")
      stringBuilder.append("***********\n\n")
    }}
    stringBuilder.result()
  }
}

case class DailyMeal(lunch: Meal, dinner: Meal)

case class Meal(proteins: Set[Protein], vegetables: Set[Vegetable], carb: Carb) {

  override def toString: String = {
    s"Proteins: $proteins\tVegetables: $vegetables\tCarbohydrates: $carb"
  }
}