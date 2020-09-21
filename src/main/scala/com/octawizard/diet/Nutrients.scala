package com.octawizard.diet

/**
 * Created by Roberto Manca on 19/09/2020.
 */

sealed class Nutrient(name: String) {
  override def toString: String = name
}

case class Protein(name: String) extends Nutrient(name)

object Protein {
  def of(protein: String, proteins: String*): Set[Protein] = {
    val set = proteins.toSet + protein
    set.map(Protein(_))
  }
}

case class Vegetable(name: String) extends Nutrient(name)

object Vegetable {
  def of(v: String, vv: String*): Set[Vegetable] = {
    val set = vv.toSet + v
    set.map(Vegetable(_))
  }
}

case class Carb(name: String) extends Nutrient(name)

object Carb {
  def of(c: String, cc: String*): Set[Carb] = {
    val set = cc.toSet + c
    set.map(Carb(_))
  }
}
