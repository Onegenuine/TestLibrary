# Веб-приложение по заказу книг в библиотеке
## Используемые технологии
JDK – Java 
IoC - SpringBoot
Front – Spring Web
DB – PostgreSQL
Сборщик: Maven
 
## Деплоймент (особенности запуска  проекта)

### 1. Создать БД в PostgreSQL c названием: "the_library_the_test_task"
### 2. Указать настройки в файле application.properties 


```spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/the_library_the_test_task
spring.datasource.username=???
spring.datasource.password=???

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.show_sql=true

spring.mvc.hiddenmethod.filter.enabled=true
```


### 3. Запустить SQL код в файле postgres.sql
### 4. Запустить приложение
	
 
## Описание
Веб-приложение по заказу книг в библиотеке. 
Простой веб интерфейс должен быть сделан на Spring Web. 
1. Может выводить список книг http://localhost:8080/books;
2. Позволяет добавить книгу (наименование, автор, ISBN) (http://localhost:8080/books/new);
3. Редактировать книгу http://localhost:8080/books/14/edit?;
4. Вписок список клиентов (http://localhost:8080/people/people);
5. Добавить клиента (ФИО, дата рождения) (http://localhost:8080/people/new);
6. Редактировать клиента (http://localhost:8080/people/13/edit?);
### Создан интерфейс взятия книги на прочтение (считаем, что количество книг в библиотеке одного ISBN бесконечно).
### Создан Rest интерфейс который будет возвращать JSON со всеми читающими клиентами
Выводится список объектов со следующими полями (ФИО клиента, дата рождения клиента, наименование книги, автор книги, ISBN книги, дата взятия книги на прочтение.
