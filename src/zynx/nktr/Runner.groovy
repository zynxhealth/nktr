package zynx.nktr

class Runner {

    def String callNKResource(String space, String uri) {
        String request = generateRequest(space, uri)
        String results = request.toURL().getText()

        if (results.startsWith('<ex>')) {
            throw new NetKernelException(results)
        }
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
