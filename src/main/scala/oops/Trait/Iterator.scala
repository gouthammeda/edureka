package oops.Trait

import scala.collection.Iterator

//Traits
//traits are used for code reuse, traits encapsulates methods and field definitions which can be reused by mixing into classes
//use extend keyword to to extend a trait and implement abstract members of trait using override keyword.

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}

