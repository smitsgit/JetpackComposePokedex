package com.plcoding.jetpackcomposepokedex.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.plcoding.jetpackcomposepokedex.data.PokeRepo
import com.plcoding.jetpackcomposepokedex.data.remote.PokedexApi
import com.plcoding.jetpackcomposepokedex.data.remote.list.PokemonList
import com.plcoding.jetpackcomposepokedex.data.remote.response.PokeMon
import com.skydoves.sandwich.ApiResponse
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class PokeRepoImpl @Inject constructor(val pokedexApi: PokedexApi): PokeRepo {

    override suspend fun getAllPokemons(limit: Int, offset:Int): ApiResponse<PokemonList> {
        return pokedexApi.getAllPokemons(limit, offset)
    }

    override suspend fun getPokemon(name: String): ApiResponse<PokeMon> {
        return pokedexApi.getPokemon(name)
    }
}