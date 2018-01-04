package io.jadon.valhalla

import io.jadon.valhalla.team.AbstractPlayer
import io.jadon.valhalla.team.VTeam

class Game(
        val name: String,
        val arenaIds: List<Int>,
        val teams: List<VTeam>,
        val spectators: List<AbstractPlayer>
)

class Arena() {

    var id: Int = -1

    fun getGame(): Game? {
        return Valhalla.games.find { it.arenaIds.contains(id) }
    }

}
