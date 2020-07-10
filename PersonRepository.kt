package com.example.demo.person.repository

import com.example.demo.person.model.PersonDTO
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonRepository : MongoRepository<PersonDTO, String> {
    fun findOneById(id: String): PersonDTO
    fun findOneByNameText(name :String): PersonDTO
    fun findByManagingOrganizationIdentifierValue(organizationId: String): List<PersonDTO>?

}