package com.plcoding.jetpackcomposepokedex.data

import com.plcoding.jetpackcomposepokedex.data.remote.list.PokemonList
import com.plcoding.jetpackcomposepokedex.data.remote.response.PokeMon
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Path

interface PokeRepo {
    suspend fun getPokemon(name: String): ApiResponse<PokeMon>
    suspend fun getAllPokemons(limit: Int, offset: Int): ApiResponse<PokemonList>
}