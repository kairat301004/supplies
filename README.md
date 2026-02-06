Проект: Приёмка поставок (тестовое задание)

Небольшое приложение на Spring Boot для учёта поставок от поставщиков.
Можно добавлять поставки с несколькими продуктами и смотреть отчёт за период.

Используемые технологии:

- Java 17

- Spring Boot 3

- Spring Data JPA

- PostgreSQL

Как запустить проект:

Создать базу данных в PostgreSQL, например supplies.

В application.properties указать:

spring.datasource.url=jdbc:postgresql://localhost:5432/supplies
spring.datasource.username=postgres
spring.datasource.password=ваш пароль


После запуска сервис будет доступен по адресу:

http://localhost:8080

Основные запросы API
1. Добавление поставки

POST /api/deliveries

Пример тела запроса:

{
"supplierId": 1,
"date": "2024-02-05",
"items": [
{ "productId": 1, "weight": 120, "price": 3.5 },
{ "productId": 2, "weight": 80, "price": 4.1 }
]
}

2. Получение отчёта по поставкам за период

GET /api/reports/deliveries?start=YYYY-MM-DD&end=YYYY-MM-DD

Например:

GET http://localhost:8080/api/reports/deliveries?start=2024-02-01&end=2024-02-10


Возвращает список поставщиков с общим весом, стоимостью и разбивкой по продуктам.

Примечание:

Перед использованием нужно заранее создать:

поставщиков

продукты