package zynx.nktr

import org.junit.Test
import static org.junit.Assert.assertEquals

class SampleTests {
    @Test
    void testGetValidEndpoint() {
        def space = 'urn:zynx:nktr:testmoduleA'
        def uri = 'active:getName+name@John'
        Runner runner = new Runner()

        String results = runner.callNKResource(space, uri)

        assertEquals('Say hello to John', results)
    }

    @Test
    void testGetInvalidEndPointShouldFail() {
        def space = 'urn:zynx:nktr:testmoduleA'
        def uri = 'active:getName2+name@John'
        Runner runner = new Runner()

        String results = runner.callNKResource(space, uri)

        assertEquals('Say hello to John', results)
    }

}
