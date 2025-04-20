package com.unlam.marvel.Data.repository

import com.unlam.marvel.Data.model.Character

interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Character>
}