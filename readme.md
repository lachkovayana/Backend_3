
### Краткое описание задачи

Написать приложение, которое будет вести реестр автомобилей и предоставлять гибкий поиск этих авто.

### Технологический стек

   1. JDK 11
   2. Spring Boot 2.6.4 (web и data jpa)
   3. Lombok
   4. Flyway для миграций БД
   5. Apache Maven
   6. PostgreSQL
  
### Функции

1. Метод получения Производителя по идентификатору

   GET /manufacturer/{id}
   
2. Метод создания нового Производителя

   POST /manufacturer
   {
       "name": "string"
   }
   
3. Метод получения Машины по идентификатору

   GET /cars/{id}

4. Метод создания новой Машины

   POST /cars

   <code>
   {
       "carModel": "string",
       "releaseYear": 2001,
       "manufacturer": "string" // идентификатор
   }
   </code>
  
5. Метод инициализации данных приложения  

   POST /cars/init
   
6. Метод поиска по произвольному набору полей

   POST /cars/fetch
  
     <code>
      {
       "filters": {
         "carModel": "string",
      "releaseYear": 2016,
      ...
      }
      }
      </code>
