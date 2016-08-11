package com.learning.scala.entity

import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}

import scala.beans.BeanProperty

/**
  * Created by amits on 10/08/16.
  */
@Entity
class Customer(firstNameParam: String, lastNameParam: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int = 0
  @BeanProperty
  var firstName: String = firstNameParam
  @BeanProperty
  var lastName: String = lastNameParam

  override def toString: String = String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName)
}
