package com.octawizard.diet

/**
 * Created by Roberto Manca on 19/09/2020.
 */
object DietGenerator extends App {

  val proteins: Set[Protein] = Protein.of("chicken", "tuna", "shrimps")
  val vegetables = Vegetable.of("broccoli", "spinach", "beetroot", "coliflower", "carrot", "tomato")
  val carbs  = Carb.of("pasta", "rice", "bread", "potato", "sweet potato")
  val weeklyDiet = new WeeklyDiet(proteins, vegetables, carbs)

  println(weeklyDiet.toString)
}
