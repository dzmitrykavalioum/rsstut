package com.dzmitrykavalioum.rsstut.api

import com.dzmitrykavalioum.rsstut.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.xml.bind.JAXBContextFactory

object RetrofitInstance {


    val interceptor = HttpLoggingInterceptor()


    private val retrofit by lazy {
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client:OkHttpClient = OkHttpClient().newBuilder().build()//.addNetworkInterceptor(interceptor).build()
        Retrofit.Builder()

            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(client)
            .build()
    }

    val api:TutApiService by lazy {
        retrofit.create(TutApiService::class.java)

    }
}