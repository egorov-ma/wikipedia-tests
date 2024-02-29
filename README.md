<h1 align="center">Проект по автоматизации тестирования мобильного приложения Wikipedia</h1>
<p align="center">
<a href="https://ru.wikipedia.org/"><img title="https://ru.wikipedia.org/" src="media/logo/img.png"></a>
</p>

>Википе́дия (англ. Wikipedia) — общедоступная многоязычная универсальная интернет-энциклопедия со свободным контентом, 
>реализованная на принципах вики. Википедия является международным проектом, который состоит из языковых разделов.

##  Содержание:
- <a href="#cases"> Тест-кейсы</a>
- <a href="#autotests"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>


Тесты написаны на языке <code>Java</code> с использованием фреймворка для автоматизации тестирования <code>[Selenide](https://selenide.org/)</code>, сборщик - <code>Gradle</code>.

<code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.

Для локального тестирования приложения на мобильных устройствах используется <code>Android Studio</code> и <code>Appium</code>.
Для удаленного тестирования в различных платформах <code>Browserstack</code>

Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета
и отправкой результатов в <code>Telegram</code> при помощи бота.

____
<a id="cases"></a>
## 🕵️‍♂️ Тест-кейсы
### При запуске локально (local) на эмуляторе:
- Проверка

### При запуске удаленно (remote) на Browserstack:
- Проверка
- Проверка
- Проверка

____
<a id="autotests"></a>
## ▶️ Команда для запуска автотестов из терминала

Запуск локально (local) на эмуляторе:
```bash 
gradle clean local_test -DdeviceHost=local
```
> Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium

Запуск удаленно (remote) на Browserstack:
```bash 
gradle clean remote_test -DdeviceHost=remote
```

















