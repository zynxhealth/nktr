import org.junit.Test
import static org.junit.Assert.assertEquals

class CoreDataTests {
    @Test
    void testGetNameEndpoint() {
        def space = 'urn:zynx:nktr:testmoduleA'
        def uri = 'active:getName2+name@John'

        String results = callNKResource(space, uri)

        assertEquals('Say hello to John', results)
    }







    private String callNKResource(String space, String uri) {
        String request = generateRequest(space, uri)
        String results = request.toURL().getText()
        results
    }




    def generateRequest(space, uri) {
        def encodedSpace = java.net.URLEncoder.encode(space)
        def doublyEncodedSpace = java.net.URLEncoder.encode(encodedSpace)
        def encodedUri = java.net.URLEncoder.encode(uri)
        def doublyEncodedUri = java.net.URLEncoder.encode(encodedUri)

        return "http://localhost:8080/nktr/run/$doublyEncodedUri/$doublyEncodedSpace"
    }
}