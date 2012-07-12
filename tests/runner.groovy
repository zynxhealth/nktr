import org.junit.Test
import static org.junit.Assert.assertEquals

class CoreDataTests {
    @Test
    void testGetNameEndpoint() {
        def space = 'urn:zynx:nktr:testmoduleB'

        def uri = 'active:getName+name@John'

        String request = generateRequest(space, uri)
        String results = request.toURL().getText()

        assertEquals('Say hello to John', results)
    }

    def generateRequest(space, uri) {
        def encodedSpace = java.net.URLEncoder.encode(space)
        def doublyEncodedSpace = java.net.URLEncoder.encode(encodedSpace)
        def encodedUri = java.net.URLEncoder.encode(uri)

        return "http://localhost:8080/nktr/run/$encodedUri/$doublyEncodedSpace"
    }
}