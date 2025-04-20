package com.unlam.marvel.Data.repository

import com.unlam.marvel.Data.model.Character
import com.unlam.marvel.Data.model.CharactersResponse
import com.unlam.marvel.Data.remote.MarvelCharactersClient

class RetrofitCharactersRepository(private val apiClient: MarvelCharactersClient) :
    CharactersRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Character> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<Character> {
        return this.characters.list.map {
            Character(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }
}