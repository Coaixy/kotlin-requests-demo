import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(args: Array<String>) {
    get()
    post()
}
fun get(){
    var client = HttpClient.newHttpClient()
    var request = HttpRequest.newBuilder()
        .uri(URI.create("http://webcode.me"))
        .build()
    var response = client.send(request,HttpResponse.BodyHandlers.ofString())
    println(response.body())
}
fun post(){
    var values = HashMap<String,String>()
    values["name"] = "Coaixy"
    values["occupation"] = "gardener"
    var objectMapper = ObjectMapper()
    var requestBody = objectMapper.writeValueAsString(values)
    var client = HttpClient.newHttpClient()
    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://httpbin.org/post"))
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build()
    val response = client.send(request,HttpResponse.BodyHandlers.ofString())
    println(response.body())
}