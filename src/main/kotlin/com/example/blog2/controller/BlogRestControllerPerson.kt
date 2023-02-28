package com.example.blog2.controller
import com.example.blog2.pojo.Person
import com.example.blog2.repositories.RepoPerson
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
@RequestMapping("/api/v1/person")
class BlogRestControllerPerson(val repoPerson: RepoPerson)
{
    @GetMapping("/getAll")
    fun getAll() = repoPerson.findAll()

    @GetMapping("/getById/{id}")
    fun getById(@PathVariable id: Long) = repoPerson.findById(id)

    @DeleteMapping("/deleteById/{id}")
    fun deletePersonById(@PathVariable id: Long):ResponseEntity<Void>
    {
        val deletePerson = repoPerson.findById(id)
        if(deletePerson.isEmpty)
        {
            return ResponseEntity.notFound().build()
        }
        repoPerson.delete(deletePerson.get())
        return ResponseEntity.status(204).build()
    }

    @PostMapping("/createPerson")
    fun createPerson(@RequestBody person: Person):ResponseEntity<Person>
    {
        val createPerson = Person(0, person.login, person.description, person.firstName, person.lastName, person.age)
        repoPerson.saveAndFlush(createPerson)
        return ResponseEntity.created(URI("/createAuthor/${createPerson.id}")).build()
    }

    @PutMapping("/updatePerson/{id}")
    fun updatePerson(@PathVariable id:Long, @RequestBody person: Person)
    {
        val updatePerson = repoPerson.findById(id)
        if(updatePerson.isPresent)
        {
            val newPerson = updatePerson.get()
            newPerson.login = person.login
            newPerson.description = person.description
            newPerson.firstName = person.firstName
            newPerson.lastName = person.lastName
            newPerson.age = person.age
            repoPerson.saveAndFlush(newPerson)
        }
    }
}