package com.dzmitrykavalioum.rsstut.model

import org.simpleframework.xml.*
import java.io.Serializable


data class Feed (


    var title: String? = null,

    var listArticle: List<Article>? = null


)
