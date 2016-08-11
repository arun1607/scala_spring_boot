package com.learning.scala.repository

import com.learning.scala.entity.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
  * Created by amits on 10/08/16.
  */
@Repository
trait CustomerRepository extends CrudRepository[Customer, Long] {

  def findByLastName(lastName: String): List[Customer]
}
