package org.example

import kotlin.math.max
import kotlin.math.min

class Vector2d(val x: Int, val y: Int) {

    override fun toString(): String {
        return String.format("%d, %d", x, y)
    }
    operator fun compareTo(other: Vector2d): Int {
        return if (x <= other.x && y <= other.y){
            -1
        } else if(x >= other.x && y >= other.y){
            1
        } else{
            0
        }
    }

    fun add (other: Vector2d): Vector2d{
        return Vector2d(x + other.x, y + other.y)
    }

    operator fun plus(other: Vector2d):Vector2d{
        return Vector2d(x + other.x, y + other.y)
    }

    operator fun minus (other: Vector2d):Vector2d{
        return Vector2d(x - other.x, y - other.y)
    }

    fun lowerLeft(other: Vector2d): Vector2d {
        return Vector2d(min(x, other.x), min(y, other.y))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector2d

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        return 17 * x + y
    }

}
fun MapDirection.toUnitVector(): Vector2d {
    return when (this) {
        MapDirection.NORTH -> Vector2d(0, 1)
        MapDirection.WEST -> Vector2d(-1, 0)
        MapDirection.SOUTH -> Vector2d(0, -1)
        MapDirection.EAST -> Vector2d(1, 0)
    }
}