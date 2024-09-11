package com.example.pokedexjetpackcompose.repository

import com.example.pokedexjetpackcompose.data.remote.PokeApi
import com.example.pokedexjetpackcompose.data.remote.response.Pokemon
import com.example.pokedexjetpackcompose.data.remote.response.PokemonList
import com.example.pokedexjetpackcompose.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository  @Inject constructor(
    private  val api:PokeApi
){

    suspend fun getPokemonList(limit:Int,offset:Int):NetworkResult<PokemonList>{
        val response = try {
            api.getPokemonList(limit,offset)
        }catch (e:Exception){
            return NetworkResult.Error("An unknown error occurred")
        }

        return NetworkResult.Success(response)

    }


    suspend fun getPokemonDetails(pokemonName:String):NetworkResult<Pokemon>{
        val response = try {
            api.getPokemonDetails(pokemonName )
        }catch (e:Exception){
            return NetworkResult.Error("An unknown error occurred")
        }

        return NetworkResult.Success(response)

    }


}