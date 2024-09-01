<h1>ДЕМО ПРОЕКТ ДЛЯ АЙЫЛ-БАНК</h1>

ИНТРУКЦИЯ ДЛЯ ЗАПУСКА
1) Иметь Docker на локальной машине

2) Создание:<br>
  a) открыть консоль по паке "aiylbank-demo" <br>
  б) прописать команды запуска:

```
docker build -f Dockerfile -t demo:v.0.1 .
```

```
docker run -p 8080:8080 demo:v.0.1
```

3) ПЕРЕЙТИ ПО ССЫЛКЕ В SWAGGER <br>
(возможны неполадки с некоторыми браузерами советую использовать Firefox, Opera) <br>
http://localhost:8080/swagger-ui/index.html
