package org.wood

import spock.lang.Specification

class HillLayoutSpec extends Specification {
    def 'parses a string'() {
        given:
        String string = 'abc'

        when:
        HillLayout hillLayout = new HillLayout(string)

        then:
        hillLayout.layout[0][0].elevation == 0
        hillLayout.layout[0][1].elevation == 1
        hillLayout.layout[0][2].elevation == 2
    }

    def 'parses multiline string'() {
        given:
        String string = """\
            abc
            cde
        """.stripIndent().replace(' ', '')

        when:
        HillLayout hillLayout = new HillLayout(string)

        then:
        hillLayout.layout[0][0].elevation == 0
        hillLayout.layout[0][1].elevation == 1
        hillLayout.layout[0][2].elevation == 2
        hillLayout.layout[1][0].elevation == 2
        hillLayout.layout[1][1].elevation == 3
        hillLayout.layout[1][2].elevation == 4

    }
}
