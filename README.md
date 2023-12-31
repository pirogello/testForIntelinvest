# Тестовое задание для java-developer 💻

## Описание

Задание состоит из нескольких частей, `часть 1` является обязательной,
все остальные опциональные, но повышают ваши шансы на успех.
Реализация бонусной задачи повышает ваши шансы вдвое 🚀

Проект рассчитан на работу с `java 17+`

Удачи ☺

## Общие данные
В проекте уже создан сервис для работы с Московской биржей `MoexSerivce`, 
rest-контроллер `MoexEndpoint` и сущность акции `Stock`

## Часть 1 - Реализовать парсинг данных с Московской биржи

Есть список акций, торгующихся на бирже. 
Необходимо:

* дополнить POJO-модель акции `Stock` необходимыми полями, с использованием jackson-аннотаций. 
* получить данные из API Московской биржи [https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/.json?iss.meta=off&iss.only=securities&iss.json=extended](https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/.json?iss.meta=off&iss.only=securities&iss.json=extended)
* преобразовать ответ к модели `List<Stock>`

Результатом успешного выполнения первого пункта будет реализация метода `ru/intelinvest/career/service/MoexService.java:17`


## Часть 2 - Реализация endpoint'a для получения информации по акциям

Используя сервис `MoexSerivce` разработанный выше, дополните контроллер `MoexEndpoint` 

* добавьте модель запроса `StockFilter` для возможности отфильтровать список `Stock` по полям `LISTLEVEL`, `SECID`, `LOTSIZE`
  * фильтрация по `LISTLEVEL` должна поддерживать множественный выбор, например, чтобы в выборку попали все акции
  с `LISTLEVEL` 1 и 2
  * фильтрация по `SECID` должна поддерживать множественный выбор, например, чтобы в выборку попали необходимые акции
    с `SECID` `ABIO` и `ABRD`
  * фильтрация по `LOTSIZE` должна иметь только одиночный выбор, например, можно указать значение 
  `LOTSIZE` 10 и в выборку должно попасть акции с `LOTSIZE` равному 10

Результатом успешного выполнения второго пункта будет реализация метода `ru/intelinvest/career/controller/MoexEndpoint.java:23`


## Часть 3 - Доработка endpoint'а `MoexEndpoint` для поддержки паджинации

Добавьте поддержку паджинации (постраничной загрузки данных) в запрос `/moex/stocks`

* возможность указать размер загружаемых данных (размер страницы)
* в ответе должно отдаваться общее количество данных, размер загруженных данных
* остальное на ваше усмотрение


## 💎 Бонусная часть - получение баланса в блокчейн сети ethereum

* Реализуйте сервис EthereumService, создайте метод, который вернет баланс ETH
для переданного в аргументах адреса. 

Тестовый адрес `0x77DDc987516abd90803b7e2A18F0F53a98438362

Документация по API `https://docs.etherscan.io/`