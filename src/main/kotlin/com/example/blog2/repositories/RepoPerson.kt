package com.example.blog2.repositories

import com.example.blog2.pojo.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepoPerson:JpaRepository<Person, Long>