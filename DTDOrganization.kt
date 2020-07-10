package com.example.demo.organization.model

import com.example.demo.Address

data class DTDOrganization(
        var id: String?=null,
       // var identifier: MutableSet<Identifier>? = null,
        var name: String? = null,
        var address: MutableSet<Address>? = null
)