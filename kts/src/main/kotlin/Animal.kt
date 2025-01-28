package org.example

class Animal (var position: Vector2d, var orientation: MapDirection, private val map: WorldMap) {

    fun move(direction: MoveDirection) {
        when (direction) {
            MoveDirection.RIGHT -> orientation = orientation.next()
            MoveDirection.LEFT -> orientation = orientation.previous()
            else->{
                if (direction === MoveDirection.BACKWARD) {
                   val newPosition: Vector2d= position - orientation.toUnitVector()
                    if (map.canMoveTo(newPosition)) {
                        position = newPosition
                    }
                }
                val newLocation: Vector2d = position + orientation.toUnitVector()
                if (map.canMoveTo(newLocation)) {
                    position = newLocation
                }
        }}
    }

    override fun toString(): String = when (orientation) {
            MapDirection.NORTH -> "N"
            MapDirection.EAST -> "E"
            MapDirection.SOUTH -> "S"
            MapDirection.WEST -> "W"
        }

    fun isAt(position2: Vector2d?): Boolean {
        return position == position2
    }

}