package org.wood

class HillLayout {
    List<List> layout

    HillLayout(String hill) {
        layout = []
        List hillRows = hill.split(/\n/)
        hillRows.each { String hillRow ->
            layout << hillRow.collect { new Node(it) }
        }
    }

    Position findStartPosition() {
        int y = layout.findIndexOf { hillRow -> hillRow.find { it.isStart } }
        int x = layout[y].findIndexOf { hillRow -> hillRow.isStart }
        return new Position(x, y)
    }

    Node findNodeAtPosition(Position position) {
        return layout[position.y][position.x]
    }

    boolean isNodesValidNeighbors(Position from, Position to) {
        Node fromNode = findNodeAtPosition(from)
        Node toNode = findNodeAtPosition(to)

        return fromNode.isValidNeighbor(toNode)
    }

    Set<Position> findValidNeighbors(Position from) {
        Set<Position> positionalNeighbors = [
                new Position(from.x + 1, from.y),
                new Position(from.x - 1, from.y),
                new Position(from.x, from.y + 1),
                new Position(from.x, from.y - 1),
        ]

        positionalNeighbors.findAll {
            isNodesValidNeighbors(from, it)
        }
    }
}
