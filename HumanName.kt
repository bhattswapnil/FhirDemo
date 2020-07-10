package com.example.demo

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class HumanName(
        //id: String? = null,
        var family: String? = null,
        var text: String?= null,
        var given: MutableSet<String>? = null
) {
}