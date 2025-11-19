
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.URI
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

fun main() {
    // Создаём "доверяющий всем" SSLContext (небезопасно!)
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    })

    val sslContext = SSLContext.getInstance("TLS").apply {
        init(null, trustAllCerts, java.security.SecureRandom())
    }

    val client = HttpClient.newBuilder()
        .sslContext(sslContext)
        .build()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://my-json-server.typicode.com/inetcoyote/users-api/users/11"))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    println("Status: ${response.statusCode()}")

    println("Body: ${response.body()}")
}