package io.jadon.valhalla.world

import io.jadon.valhalla.team.VTeam

interface AbstractWorld {
    fun getName(): String
}

class VLocation(val x: Double, val y: Double, val z: Double, val world: AbstractWorld)

abstract class VMap(
        val name: String,
        val worldName: String,
        val authors: List<String>,
        val spawns: Map<VTeam, VLocation>) {

    // Weird bug with accessing the setter from Java
    internal var isLoaded: Boolean = false

    fun setLoaded(isLoaded: Boolean) {
        this.isLoaded = isLoaded
    }

    fun isLoaded(): Boolean = isLoaded

    abstract fun loadWorld()
    abstract fun unloadWorld()

}

