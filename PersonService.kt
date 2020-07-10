package com.example.demo.person.service

import com.example.demo.person.model.PersonDTO

interface PersonService {

    fun getResources(): List<PersonDTO>
    fun createResource(Person : PersonDTO) : PersonDTO
    fun getResourceByFullName(fullName : String): PersonDTO

}