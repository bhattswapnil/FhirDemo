package com.example.demo

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class Reference<Organization>(
        //val id: String? = null,
        var reference: String? = null,
        var type: String? = null,
        var identifier: Identifier? = null
) {


}