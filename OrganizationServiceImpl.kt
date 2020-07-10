package com.example.demo.organization.service

import com.example.demo.organization.model.DTDOrganization
import com.example.demo.organization.repository.OrganizationRepository
import com.example.demo.person.model.PersonDTO
import com.example.demo.person.repository.PersonRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class OrganizationServiceImpl(
        private val organizationRepository : OrganizationRepository,
        private val personRepository: PersonRepository
) :OrganizationService {

    override fun createResource(Organization: DTDOrganization): DTDOrganization {
        val id: String = ObjectId().toString();
        val organization = organizationRepository.save(DTDOrganization(
                id = id,
                name = Organization.name,
                address = Organization.address
        ))
        return organization
    }

    override fun getAssociatedPersonByOrgName(name: String): List<PersonDTO>? {
        val id = organizationRepository.findOneByName(name).id
        val persons = id?.let { personRepository.findByManagingOrganizationIdentifierValue(it) }
        return persons
    }

    override fun getResourceById(id: String): DTDOrganization {
        val organization = organizationRepository.findOneById(id)
        return organization
    }

    override fun getResources(): List<DTDOrganization> {
        val organizations = organizationRepository.findAll()
        return organizations
    }
}