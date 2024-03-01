<h1 align="center">Проект по автоматизации тестирования мобильного приложения Wikipedia</h1>
<p align="center">
<a href="https://ru.wikipedia.org/"><img title="https://ru.wikipedia.org/" src="media/logo/img.jpg"></a>
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
- Открытие первой найденной ссылки
- Проверка поиска
- Проверка onboarding screen

### При запуске удаленно (remote) на Browserstack:
- Проверка поиска
- Открытие первой найденной ссылки
- Проверка краткого описания статьи

____
<a id="autotests"></a>
## ▶️ Команда для запуска автотестов из терминала

Запуск локально (local) на эмуляторе:
```bash 
gradle clean local_test -DdeviceHost=local
```
> Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium ([инструкция](https://autotest.how/appium-setup-for-local-android-tutorial))

Запуск удаленно (remote) на Browserstack:
```bash 
gradle clean remote_test -DdeviceHost=remote
```
---
<a id="jenkins"></a>
## <img width="20" style="vertical-align:middle" title="Jenkins" src="media/logo/jenkins.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/job/wikipedia-tests/"> Jenkins </a>
Для доступа в Jenkins необходима регистрация на ресурсе [Jenkins](https://jenkins.autotests.cloud/) 
Для запуска сборки необходимо нажать кнопку <code>Build now</code>.
<p align="center">
<img title="jenkins" src="media/screenshots/imgJenkins.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки 
<code>Allure Report</code>, при клике на которые откроется страница с сформированным html-отчетом.

____
<a id="allureReport"></a>
## <img width="30" style="vertical-align:middle" title="Allure Report" src="media/logo/allure.svg"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/job/wikipedia-tests/5/allure/"> Allure-отчета </a>
<p align="center">
<img title="Allure Report" src="media/screenshots/screenshotsAllure.png">
</p>

____
<a id="tg"></a>
## <img width="30" style="vertical-align:middle" title="Telegram" src="media/logo/telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом
о прогоне тестов в [специально настроенный чат](https://t.me/+m0gDb0Dy9ckwZTYy).
<p align="center" style="background-color: #18222d">
<img width="40%" title="Telegram Notifications" src="media/screenshots/screenshotsTelegram.png">
</p>