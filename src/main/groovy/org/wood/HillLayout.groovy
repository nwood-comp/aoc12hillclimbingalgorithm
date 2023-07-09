package org.wood

class HillLayout {
    List layout

    HillLayout(String hill) {
        layout = []
        List hillRows = hill.split(/\n/)
        hillRows.each { String hillRow ->
            layout << hillRow.collect { new Position(it) }
        }
    }
}
