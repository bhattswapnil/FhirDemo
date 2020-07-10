package com.example.demo.organization.service

import com.example.demo.organization.model.DTDOrganization
import com.example.demo.person.model.PersonDTO

interface OrganizationService {

    fun createResource(Organization :DTDOrganization):DTDOrganization

    fun getAssociatedPersonByOrgName(name: String): List<PersonDTO>?

    fun getResourceById(id: String): DTDOrganization

    fun getResources(): List<DTDOrganization>
}