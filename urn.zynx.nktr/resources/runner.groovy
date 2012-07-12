import org.netkernel.layer0.nkf.*

INKFRequestContext currentContext = context

def uri = currentContext.source('arg:uri')
def space = currentContext.source('arg:space')

INKFRequest innerRequest = currentContext.createRequest('active:wormhole')
innerRequest.addArgument('uri', uri)
innerRequest.addArgument('space', space)

def innerRequestResult
try {
    innerRequestResult = currentContext.issueRequest(innerRequest)
} catch (e) {
    def stringWriter = new StringWriter()
    def printWriter = new PrintWriter(stringWriter)
    e.printStackTrace(printWriter)

    innerRequestResult = stringWriter.toString()
}

INKFResponse response = currentContext.createResponseFrom(innerRequestResult)
response.mimeType = 'text/plain'
