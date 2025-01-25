package org.example

fun randomPosition(animals: Map<Vector2d, Animal>): Vector2d? {
    return animals.keys.randomOrNull()
}

fun randomFreePosition(mapSize: Vector2d, animals: Map<Vector2d, Animal>): Vector2d? {
    val allPositions = (0 until mapSize.x).flatMap { x ->
        (0 until mapSize.y).map { y -> Vector2d(x, y) }
    }
    return allPositions.filterNot { it in animals.keys }.randomOrNull()
}