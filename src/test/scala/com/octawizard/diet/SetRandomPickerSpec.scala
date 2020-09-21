package com.octawizard.diet

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

/**
 * Created by Roberto Manca on 21/09/2020.
 */
class SetRandomPickerSpec extends AnyFlatSpec with should.Matchers with SetRandomPicker {

  "A SetRandomPicker" should "pick one random element from a given set" in {
    val set = Set("a", "b", "c")
    val e = randomPick(set)
    set should contain (e)
  }

  it should "pick n random elements from a given set with less than n elements" in {
    val set = Set("a", "b", "c")
    val str = randomPick(set, 5)
    str.size shouldBe 3
    println(str)
  }

  it should "pick n random elements from a given set with more than n elements" in {
    val set = Set("a", "b", "c")
    val str = randomPick(set, 3)
    str.size shouldBe 3
    println(str)
  }
}
