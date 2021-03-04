package com.dzmitrykavalioum.rsstut.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root (name = "item", strict = false)
data class Article (
    @Element(name = "title")
    var title:String,

    @Element(name = "link")
    var link:String
)