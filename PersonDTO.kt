package com.example.demo.person.model

import com.example.demo.Address
import com.example.demo.HumanName
import com.example.demo.Reference
import com.example.demo.organization.model.DTDOrganization
import org.springframework.data.annotation.Id
import java.time.LocalDate

data class PersonDTO(
        val id: String?= null,
        val name: MutableSet<HumanName>? = null,
        val gender: String? = null,
        val birthDate: LocalDate? = null,
        val address: MutableSet<Address>? = null,
        val managingOrganization: Reference<DTDOrganization>? = null
){

}