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

class WeeklyDiet(proteins: Set[Protein], vegetables: Set[Vegetable], sideVegetables: Set[Vegetable], carbs: Set[Carb]) {

  private val diet = generateDiet

  private def generateDailyMeals(
                            proteins: Set[Protein],
                            vegetables: Set[Vegetable],
                            sideVegetables: Set[Vegetable],
                            carbs: Set[Carb])
  : DailyMeal = {
    //todo avoid repeated veggies, add rules to limit meat proteins, favouring the rest
    val lunch = Meal(randomPick(proteins), randomPick(vegetables), randomPick(sideVegetables, 3), randomPick(carbs))
    val dinner = Meal(randomPick(proteins), randomPick(vegetables), randomPick(sideVegetables, 3), randomPick(carbs))
    DailyMeal(lunch, dinner)
  }

  private def generateDiet: List[(DayOfWeek, DailyMeal)] = {
    WeekDays.map(_ -> generateDailyMeals(proteins, vegetables, sideVegetables, carbs))
  }

  private def randomPick[T](s: Set[T]): T = {
    require(s.nonEmpty)
    val n = util.Random.nextInt(s.size)
    s.iterator.drop(n).next
  }

  private def randomPick[T](s: Set[T], count: Int = 1): Set[T] = {
    require(s.nonEmpty && count > 0)
    Set.fill(count) {
      //todo check logic for repetition
      val n = util.Random.nextInt(s.size)
      s.iterator.drop(n).next
    }
  }

  override def toString: String = {
    val stringBuilder = new StringBuilder
    diet.foreach {
      entry => {
        stringBuilder.append("***********\n")
        stringBuilder.append(s"* ${entry._1}\n")
        stringBuilder.append(s"*** Lunch:\t${entry._2.lunch}\n")
        stringBuilder.append(s"*** Dinner:\t${entry._2.dinner}\n")
        stringBuilder.append("***********\n\n")
      }
    }
    stringBuilder.result()
  }
}

case class DailyMeal(lunch: Meal, dinner: Meal)

case class Meal(proteins: Protein, vegetables: Vegetable, sideVegetables: Set[Vegetable], carb: Carb) {

  override def toString: String = {
    s"Proteins: $proteins\tVegetables: $vegetables\tSide Vegetables: $sideVegetables\tCarbohydrates: $carb"
  }
}