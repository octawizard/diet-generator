package com.octawizard.diet

import scala.collection.mutable

/**
 * Created by Roberto Manca on 19/09/2020.
 */
case class Protein(name: String)

object Protein {
  def of(protein: String, proteins: String*): Set[Protein] = {
    val set = mutable.Set(protein)
    proteins.foreach(p => set.add(p))
    set.map(Protein(_)).toSet
  }
}

case class Vegetable(name: String)
object Vegetable {
  def of(v: String, vv: String*): Set[Vegetable] = {
    val set = mutable.Set(v)
    vv.foreach(set.add)
    set.map(Vegetable(_)).toSet
  }
}

case class Carb(name: String)
object Carb {
  def of(c: String, cc: String*): Set[Carb] = {
    val set = mutable.Set(c)
    cc.foreach(set.add)
    set.map(Carb(_)).toSet
  }
}