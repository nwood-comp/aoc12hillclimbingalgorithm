package org.wood

import groovy.transform.EqualsAndHashCode

import static org.wood.Constants.getBaseAscii

@EqualsAndHashCode
class Node {
    boolean isStart = false
    boolean isEnd = false
    Integer elevation

    Node(String letter) {
        if (letter == 'S') {
            isStart = true
            elevation = 0
        } else if (letter == 'E') {
            isEnd = true
            elevation = 25
        } else {
            elevation = 0 + (int) letter - baseAscii
        }
    }

    boolean isValidNeighbor(Node toNode) {
        int elevationChange = toNode.elevation - elevation
        return elevationChange <= 1
    }
}
