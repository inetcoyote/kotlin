import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.URI
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

fun main() {
    // Создаём "доверяющий всем" TrustManager (небезопасно!)
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) = Unit
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) = Unit
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    })

    // Настроить SSLContext для игнорирования ошибок
    val sslContext = SSLContext.getInstance("TLS").apply {
        init(null, trustAllCerts, java.security.SecureRandom())
    }

    val client = HttpClient.newBuilder()
        .sslContext(sslContext)
        .build()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://my-json-server.typicode.com/inetcoyote/users-api/users/11"))
        .build()

    try {
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val statusCode = response.statusCode()
        val statusText = HttpStatus.getText(statusCode)

        println("Статус: $statusCode $statusText")
        println("Тело ответа: ${response.body()}")

    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
        e.printStackTrace()
    }
}

object HttpStatus {
    private val statusMap = mapOf(
        100 to "Продолжить",
        101 to "Переключение протоколов",
        200 to "Успешно",
        201 to "Создано",
        202 to "Принято",
        204 to "Нет содержимого",
        301 to "Перемещено навсегда",
        302 to "Найдено",
        304 to "Не изменено",
        400 to "Неверный запрос",
        401 to "Неавторизовано",
        403 to "Доступ запрещён",
        404 to "Не найдено",
        405 to "Метод не поддерживается",
        408 to "Время ожидания истекло",
        409 to "Конфликт",
        410 to "Удалено",
        413 to "Слишком большой объём данных",
        414 to "Слишком длинный URI",
        415 to "Неподдерживаемый тип данных",
        429 to "Слишком много запросов",
        500 to "Внутренняя ошибка сервера",
        501 to "Не реализовано",
        502 to "Плохой шлюз",
        503 to "Сервис недоступен",
        504 to "Шлюз не отвечает"
    )

    fun getText(code: Int): String = statusMap[code] ?: "Неизвестный статус"
}