package org.wood

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Position {
    int x
    int y

    Position(int x, int y) {
        this.x = x
        this.y = y
    }
}
