package com.octawizard.diet

import scala.collection.mutable

/**
 * Created by Roberto Manca on 21/09/2020.
 */
trait SetRandomPicker {

  def randomPick[T](s: Set[T]): T = {
    require(s.nonEmpty)
    val n = util.Random.nextInt(s.size)
    s.iterator.drop(n).next
  }


  def randomPick[T](s: Set[T], count: Int = 1): Set[T] = {
    require(s.nonEmpty && count > 0)
    val shuffled = scala.util.Random.shuffle(s.toList)
    shuffled.take(count).toSet
  }
}
