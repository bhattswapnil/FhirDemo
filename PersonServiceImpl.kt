package com.example.demo.person.service

import com.example.demo.Reference
import com.example.demo.organization.model.DTDOrganization
import com.example.demo.person.model.PersonDTO
import com.example.demo.person.repository.PersonRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(
        val personRepository: PersonRepository,
        private var referenceOrganization: Reference<DTDOrganization>
): PersonService{

    override fun getResources(): List<PersonDTO> {
        val persons = personRepository.findAll()
        return persons
    }

    override fun createResource(Person: PersonDTO): PersonDTO {
        val id: String = ObjectId().toString();
        toReference(Person);
        createFullName(Person);
        val person = personRepository.save(PersonDTO(
                id = id,
                name = Person.name,
                birthDate = Person.birthDate,
                gender = Person.gender,
                address = Person.address,
                managingOrganization = referenceOrganization
        ))
        return person
    }

    override fun getResourceByFullName(fullName: String): PersonDTO {
        val person = personRepository.findOneByNameText(fullName.toLowerCase())
        return person
    }

    fun toReference(Person: PersonDTO) {
        val organizationIdentifier = Person.managingOrganization?.identifier;
        val organizationId = Person.managingOrganization?.identifier?.value;
        val type = Person.managingOrganization?.type;
        referenceOrganization.identifier = organizationIdentifier;
        referenceOrganization.type = type;
        referenceOrganization.reference = "/Organization/${organizationId}";
    }

    fun createFullName(Person: PersonDTO){
        val name = Person.name;
        if (name != null) {
            for(humanName in name) {
                for(lastName in humanName.given!!) {
                    val fullName = lastName + humanName.family
                    humanName.text = fullName.toLowerCase()
                }
            }
        }
    }
}