package com.example.demo.organization.repository

import com.example.demo.organization.model.DTDOrganization
import org.springframework.data.mongodb.repository.MongoRepository

interface OrganizationRepository : MongoRepository<DTDOrganization, String> {
    fun findOneById(id: String): DTDOrganization
    fun findOneByName(name : String) : DTDOrganization
}