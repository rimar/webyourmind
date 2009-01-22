package org.glob

class XmlSlurperTest extends GroovyTestCase {

    void testXmlParser() {
        def text = """
<characters>
  <props>
    <prop>dd</prop>
  </props>
  <character id="1" name="Wallace">
     <likes>cheese</likes>
  </character>
  <character id="2" name="Gromit">
    <likes>sleep</likes>
  </character>
</characters>
"""

        def node = new XmlSlurper().parseText(text);

        assert node != null
        assert node.children().size() == 3 //, "Children ${node.children()}"

        def characters = node.character
        println "node:" + node.children().size()
        println "characters:" + characters.size()
        for (c in characters) {
            println c['@name']
        }

        assert characters.size() == 2

        assert node.character.likes.size() == 2 //, "Likes ${node.character.likes}"

        // lets find Gromit
        def gromit = node.character.find { it['@id'] == '2' }
        assert gromit != null //, "Should have found Gromit!"
        assert gromit['@name'] == "Gromit"

        // lets find what Wallace likes in 1 query
        def answer = node.character.find { it['@id'] == '1' }.likes.text()
        assert answer == "cheese"
    }
}
