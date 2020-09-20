package com.octawizard.diet

/**
 * Created by Roberto Manca on 19/09/2020.
 */
case class Protein(name: String)

object Protein {
  def of(protein: String, proteins: String*): Set[Protein] = {
    val set = proteins.toSet + protein
    set.map(Protein(_))
  }
}

case class Vegetable(name: String)

object Vegetable {
  def of(v: String, vv: String*): Set[Vegetable] = {
    val set = vv.toSet + v
    set.map(Vegetable(_))
  }
}

case class Carb(name: String)

object Carb {
  def of(c: String, cc: String*): Set[Carb] = {
    val set = cc.toSet + c
    set.map(Carb(_))
  }
}