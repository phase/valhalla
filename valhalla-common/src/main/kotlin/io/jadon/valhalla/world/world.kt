package io.jadon.valhalla.world

import io.jadon.valhalla.team.VTeam

interface AbstractWorld {
    fun getName(): String
}

class VLocation(val x: Double, val y: Double, val z: Double, val world: AbstractWorld)

abstract class VMap(
        val name: String,
        internal val worldName: String,
        val authors: List<String>,
        val spawns: Map<VTeam, VLocation>) {

    // Weird bug with accessing the fields from Java
    internal var isLoaded: Boolean = false

    fun setLoaded(isLoaded: Boolean) {
        this.isLoaded = isLoaded
    }

    fun isLoaded(): Boolean = isLoaded

    fun getWorldName(): String = worldName

    abstract fun loadWorld()
    abstract fun unloadWorld()

}

