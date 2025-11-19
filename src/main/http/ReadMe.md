### Задача 1:

**Задание**

Вызвать тестовый URL HTTP методом GET и отобразить з него данные в формате json

**Решение на kotlin**


```kotlin
import khttp.get

fun main() {
    val url = "https://my-json-server.typicode.com/inetcoyote/users-api/users/1"
    val response = get(url)

    println("Статус: ${response.statusCode}") 
    println("Тело ответа: ${response.text}")     
}

```
**Пример результата <span style="color:green">успешного</span> вызова:**
```
Статус: 200 Успешно
Тело ответа: {
"id": 1,
"name": "Eugene",
"age": 35
}
```

**Пример результата <span style="color:red">неуспешного</span> вызова:**
```
Статус: 404 Не найдено
Тело ответа: {}
```
