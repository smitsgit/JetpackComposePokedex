package com.plcoding.jetpackcomposepokedex.data.remote

import com.plcoding.jetpackcomposepokedex.data.remote.list.PokemonList
import com.plcoding.jetpackcomposepokedex.data.remote.response.PokeMon
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexApi {
    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ApiResponse<PokemonList>

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): ApiResponse<PokeMon>
}