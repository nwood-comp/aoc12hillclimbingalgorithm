package org.wood

import spock.lang.Specification

class PositionSpec extends Specification {
    def 'creates position'() {
        given:
        Position position = new Position(1, 0)

        expect:
        position.x == 1
        position.y == 0
    }
}
