package com.example.demo.person.controller

import com.example.demo.*
import com.example.demo.organization.model.DTDOrganization
import com.example.demo.organization.repository.OrganizationRepository
import com.example.demo.person.model.PersonDTO
import com.example.demo.person.repository.PersonRepository
import com.example.demo.person.service.PersonService
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
    @RequestMapping("/person")
    class PersonController(
        private val personService: PersonService

    ) {
        @GetMapping
        fun getAllPersons(): ResponseEntity<List<PersonDTO>> {
            val persons = personService.getResources()
            return ResponseEntity.ok(persons)
        }

        @GetMapping("/{fullName}")
        fun getPersonByName(@PathVariable("fullName") name :String): ResponseEntity<PersonDTO> {
            val person = personService.getResourceByFullName(name.toLowerCase())
            return ResponseEntity.ok(person)
        }


        @PostMapping
        fun createPerson(@RequestBody request: PersonDTO): ResponseEntity<PersonDTO> {
            val person = personService.createResource(request)
            return ResponseEntity(person, HttpStatus.CREATED)
        }

    }

