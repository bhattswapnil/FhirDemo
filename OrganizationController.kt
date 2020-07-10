package com.example.demo.organization.controller

import com.example.demo.organization.model.DTDOrganization
import com.example.demo.organization.repository.OrganizationRepository
import com.example.demo.organization.service.OrganizationService
import com.example.demo.person.model.PersonDTO
import com.example.demo.person.repository.PersonRepository
import com.example.demo.person.service.PersonService
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.xml.stream.events.DTD

@RestController
@RequestMapping("/Organization")
class OrganizationController(
        private val organizationService: OrganizationService
) {

    @GetMapping
    fun getAllOrganization(): ResponseEntity<List<DTDOrganization>> {
        val organizations = organizationService.getResources()
        return ResponseEntity.ok(organizations)
    }

    @GetMapping("/{id}")
    fun getOneOrganization(@PathVariable("id") id: String): ResponseEntity<DTDOrganization> {
        val organization = organizationService.getResourceById(id)
        return ResponseEntity.ok(organization)
    }

    //Get persons associated with organization name
    @GetMapping("/name")
    fun getPersonByName(@RequestParam("name") name : String) : List<PersonDTO>? {
        val persons = organizationService.getAssociatedPersonByOrgName(name)
        return persons
    }

    @PostMapping
    fun createOrganization(@RequestBody request: DTDOrganization): ResponseEntity<DTDOrganization> {
        val organization = organizationService.createResource(request)
        return ResponseEntity(organization, HttpStatus.CREATED)
    }


}