#### Сборка
java 8 (проверялось на openJDK OpenJDK Runtime Environment (build 1.8.0_432-b07))
gradle (проверялось на Gradle 8.10.2)

1. склонировать git-репозиторий
2. вызвать из корня проекта:

    `$ gradle clean build (можно через ./gradlew clean build)`
3. Для запуска понадобится postgresql (при разаработке использовалась postgresql:16)

         POSTGRES_USER: postgres
         POSTGRES_PASSWORD: postgres
         POSTGRES_DB: registry
    запустить локально или через docker_compose.yml - из корня проекта:

    `$ docker-compose up`
    
4. запуск приложения из корня проекта:
   `$ java -jar build/libs/apodlatov-test-respak-0.0.1.jar`

5. http://localhost:8091/swagger-ui/index.html