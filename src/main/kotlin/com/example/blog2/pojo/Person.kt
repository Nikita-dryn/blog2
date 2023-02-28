package com.example.blog2.pojo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "person")
data class Person
    (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long=0,
    var login: String,
    var firstName: String,
    var lastName: String,
    var description: String,
    var age:Int
    )