package org.wood

import spock.lang.Specification

class NodeSpec extends Specification {
    def 'constructs from letter'() {
        given:
        Node node = new Node(letter)

        expect:
        node.elevation == elevation
        node.isStart == false
        node.isEnd == false

        where:
        letter || elevation
        'a'    || 0
        'c'    || 2
        'm'    || 12
        'z'    || 25
    }

    def 'finds start'() {
        given:
        Node node = new Node('S')

        expect:
        new Node('S').elevation == 0
        node.isStart == true
    }

    def 'finds end'() {
        given:
        Node node = new Node('E')

        expect:
        new Node('E').elevation == 25
        node.isEnd == true
    }

    def 'for nodes=["#from", "#to"], isValidNeighbor="isValidNeighbor"'() {
        given:
        Node fromNode = new Node(from)
        Node toNode = new Node(to)

        expect:
        fromNode.isValidNeighbor(toNode) == isValidNeighbor

        where:
        from | to  || isValidNeighbor
        'c'  | 'a' || true
        'c'  | 'b' || true
        'c'  | 'c' || true
        'c'  | 'd' || true
        'c'  | 'e' || false
        'c'  | 'z' || false
    }
}
