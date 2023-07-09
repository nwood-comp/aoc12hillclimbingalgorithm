package org.wood

import spock.lang.Specification

class PositionSpec extends Specification {
    def 'constructs from letter'() {
        given:
        Position position = new Position('a')

        expect:
        position.elevation == 0
        position.isStart == false
        position.isEnd == false

        where:
        letter || elevation
        'a'    || 0
        'c'    || 2
        'm'    || 14
        'z'    || 25
    }

    def 'finds start'() {
        given:
        Position position = new Position('S')

        expect:
        new Position('S').elevation == 0
        position.isStart == true
    }

    def 'finds end'() {
        given:
        Position position = new Position('E')

        expect:
        new Position('E').elevation == 25
        position.isEnd == true
    }
}
