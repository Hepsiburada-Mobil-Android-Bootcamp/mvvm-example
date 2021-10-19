package com.synthesizer.source.empty.data.mapper

import com.synthesizer.source.empty.data.CharacterResponse

fun CharacterResponse.toDomain(): Character {
    return Character(id = id, image = image, name = name, status = status)
}