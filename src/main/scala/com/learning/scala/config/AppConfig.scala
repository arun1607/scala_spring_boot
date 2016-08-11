package com.learning.scala.config

import java.lang.Iterable

import com.learning.scala.entity.Customer
import com.learning.scala.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

/**
  * Created by amits on 10/08/16.
  */
@SpringBootApplication
class AppConfig {

  @Bean
  def demo(repository: CustomerRepository): CommandLineRunner = {

    val log = LoggerFactory.getLogger(classOf[AppConfig])

    (args: String*) => {
      // save a couple of customers
      repository.save(new Customer("Jack", "Bauer"))
      repository.save(new Customer("Chloe", "O'Brian"))
      repository.save(new Customer("Kim", "Bauer"))
      repository.save(new Customer("David", "Palmer"))
      repository.save(new Customer("Michelle", "Dessler"))

      // fetch all customers
      log.info("Customers found with findAll():")
      log.info("-------------------------------")
      val customers: Iterable[Customer] = repository.findAll()

      for (cust <- customers) {
        log.info(cust.toString())
      }

      val custConsumer = (cust: Customer) => println(cust.toString)

      customers.forEach(println(_))
      log.info("")

      // fetch an individual customer by ID
        customer = repository.findOne(1L)
      log.info("Customer found with findOne(1L):")
      log.info("--------------------------------")
      log.info(customer.toString())
      log.info("")

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):")
      log.info("--------------------------------------------")
      for (Customer bauer: repository.findByLastName("Bauer"))
      {
        log.info(bauer.toString())
      }
      log.info("")
    }
  }
}
