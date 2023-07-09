package org.wood


import static org.wood.Constants.getBaseAscii

class Position {
    boolean isStart = false
    boolean isEnd = false
    Integer elevation

    Position(String letter) {
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

}
