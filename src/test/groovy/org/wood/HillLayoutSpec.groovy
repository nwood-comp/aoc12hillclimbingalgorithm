package org.wood

import spock.lang.Specification

class HillLayoutSpec extends Specification {
    def 'parses a string'() {
        given:
        String input = 'abc'

        when:
        HillLayout hillLayout = new HillLayout(input)

        then:
        hillLayout.layout[0][0].elevation == 0
        hillLayout.layout[0][1].elevation == 1
        hillLayout.layout[0][2].elevation == 2
    }

    def 'parses multiline string'() {
        given:
        String input = """\
            abc
            cde
        """.stripIndent().replace(' ', '')

        when:
        HillLayout hillLayout = new HillLayout(input)

        then:
        hillLayout.layout[0][0].elevation == 0
        hillLayout.layout[0][1].elevation == 1
        hillLayout.layout[0][2].elevation == 2
        hillLayout.layout[1][0].elevation == 2
        hillLayout.layout[1][1].elevation == 3
        hillLayout.layout[1][2].elevation == 4
    }

    def 'returns position of start node'() {
        given:
        String input = """\
            abc
            cSe
        """.stripIndent().replace(' ', '')
        HillLayout hillLayout = new HillLayout(input)

        expect:
        hillLayout.findStartPosition() == new Position(1, 1)
    }

    def 'returns node at a position'() {
        given:
        String input = """\
            abc
            cSe
        """.stripIndent().replace(' ', '')
        HillLayout hillLayout = new HillLayout(input)

        when:
        Node node = hillLayout.findNodeAtPosition(new Position(2, 1))

        then:
        node == new Node('e')
    }

    def 'finds valid neighbors for a position'() {
        given:
        String input = 'zcb'
        HillLayout hillLayout = new HillLayout(input)

        expect:
        hillLayout.isNodesValidNeighbors(new Position(0, 0), new Position(1, 0)) == true

    }

    def 'finds positions of valid neighbors of a given position'() {
        given:
        String input = """\
            aza
            bxy
            Exa
        """.stripIndent().replace(' ', '')
        HillLayout hillLayout = new HillLayout(input)

        when:
        Set<Position> validNeighbors = hillLayout.findValidNeighbors(new Position(1, 1))

        then:
        validNeighbors == [new Position(0, 1), new Position(2, 1), new Position(1, 2)] as Set
    }
}
