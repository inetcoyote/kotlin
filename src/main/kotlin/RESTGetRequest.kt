import khttp.get

fun main() {
    val url = "https://jsonplaceholder.typicode.com/posts/1"

    val response = get(url)

    println("Status code: ${response.statusCode}")
    println("Response body: ${response.text}")
}