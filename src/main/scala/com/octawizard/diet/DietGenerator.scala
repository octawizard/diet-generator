package com.octawizard.diet

/**
 * Created by Roberto Manca on 19/09/2020.
 */
object DietGenerator extends App {

  val proteins: Set[Protein] = Protein.of(
    "chicken",
    "tuna",
    "shrimps",
    "eggs",
    "beans",
    "chickpeas",
    "lentil",
    "cottage cheese",
    "clams",
    "cod",
    "salmon"
  )
  val vegetables = Vegetable.of(
    "broccoli",
    "spinach",
    "beetroot",
    "cauliflower",
    "eggplant",
    "zucchini",
    "red pepper",
    "green beans",
    "edamame",
    "cabbage",
    "pumpkin"
  )
  val sideVegetables = Vegetable.of(
    "cucumber",
    "tomato",
    "carrot",
    "rucola",
    "lettuce",
    "dried tomato"
  )
  val carbs = Carb.of("pasta", "brown rice", "brown bread", "potato", "sweet potato", "quinoa")
  val weeklyDiet = new WeeklyDiet(proteins, vegetables, carbs)

  println(weeklyDiet.toString)
}
