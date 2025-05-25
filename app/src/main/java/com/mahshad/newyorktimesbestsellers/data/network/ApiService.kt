package com.mahshad.newyorktimesbestsellers.data.network

import com.mahshad.newyorktimesbestsellers.data.models.dtos.response.BookDto
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/svc/books/v3/lists/current/hardcover-fiction.json?api-key=6EfObmGb8YSI6avWFQOpUSQOGEVFaGeD")
    fun getBookDtos(): Single<Response<List<BookDto>>>
}