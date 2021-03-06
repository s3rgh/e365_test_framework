#Установка окружения

###Ubuntu

1. Установка openjdk 
   
* Обновим репозитории   
  
`sudo apt-get update`
  
* Установим сам JDK
  
`sudo apt-get install openjdk-8-jdk`

* Проверим, что всё корректно установлено

`java -version`

`javac -version`

2. Установка Maven

* Установка

`sudo apt-get install maven`

* Проверим, что всё корректно установлено

`mvn -version`

3. Установка git

* Установка

`sudo apt install git`

* Проверим, что всё корректно установлено

`git --version`

4. Для работы может потребоваться Chrome

* Загрузим пакет для установки

`wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb`

* Запустим команду для инсталляции пакета

`sudo dpkg -i google-chrome-stable_current_amd64.deb`

* Если есть какие-то ошибки, можно запустить команду

`sudo apt -f install`

* После установки запустим сам Chrome

`google-chrome`

5. Создадим каталог для нашего проекта 

`mkdir projects`

`cd ./projects`

`pwd`

`git clone https://stash.elewise.com/scm/e3q/e365.git`

> Необходимо будет ввести логин и пароль от аккаунта в stash.elewise.com

5. Установим IDE (Intellij IDEA)

* Установка

`sudo snap install intellij-idea-community --classic`

* Запуск IDE

`intellij-idea-community`


6. Установка плагинов для IDE

* Необходимо поставить плагины для Cucumber и Gherkin для работы с фреймворком




###Ссылка на видео по установке окружения: [click](https://drive.google.com/file/d/1XR_kefxLII_YQLS9gk5EEci17j6mVv7Z/view?usp=sharing)

> P.S. если будут какие-то вопросы, то пишите в личку 



#Запуск тестов:

    git clone https://stash.elewise.com/scm/e3q/e365.git
    mvn clean install
    mvn allure:serve



`mvn clean install` - выполнить `clean` в каждом модуле перед запуском `install` для каждого модуля. Это позволяет очистить все скомпилированные файлы, которые у вас есть, убедившись, что вы действительно компилируете каждый модуль с нуля.

`mvn allure:serve` - для формирования allure report

`mvn verify` - будем использовать для подготовки cucumber report, если потребуется



[maven  docs](https://maven.apache.org/)

[cucumber docs](https://cucumber.io/docs/installation/)

[selenium docs](https://www.selenium.dev/documentation/en/)

# E365_TEST_FRAMEWORK

<details>
  <summary>ALLURE DESCRIPTION for more info take a look for https://docs.qameta.io</summary>

#Allure
## Cucumber JVM info [here](https://docs.qameta.io/allure/#_cucumber_jvm)

Installation

Each major version of Cucumber JVM requires a particular version of Allure Cucumber JVM adapter.

The available latest version of adapters:

[Cucumber JVM 6.x - allure-cucumber6-jvm Allure Cucumber JVM 6.x](https://mvnrepository.com/artifact/io.qameta.allure/allure-cucumber6-jvm/2.13.8)

Maven

Simply add allure-cucumber6-jvm plugin as a dependency to your project and add it to CucumberOptions:

`pom.xml`

```xml
<properties>
    <aspectj.version>1.8.10</aspectj.version>
</properties>

<dependencies>
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-cucumber4-jvm</artifactId>
        <version>LATEST_VERSION</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.20</version>
            <configuration>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    -Dcucumber.options="--plugin io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
                </argLine>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${aspectj.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```
Then execute `mvn clean test` goal. After tests executed allure JSON files will be placed in allure-results directory by default.

### Features

This adapter provides runtime integration allowing conversion of Gherkin dsl features into basic Allure features

### Display Name

Titles for tests and suites are extracted at runtime from `.feature` files

### Description

Feature’s description appears on every scenario

### Steps

All scenario steps are automatically translated into allure steps

### Attachments

An attachment in Java code is simply a method annotated with `@Attachment` that returns either a String or byte[], which should be added to the report:
```java
import io.qameta.allure.Attachment;
...
@Attachment
public String performedActions(ActionSequence actionSequence) {
    return actionSequence.toString();
}

@Attachment(value = "Page screenshot", type = "image/png")
public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
}
```
Or you can use Allure helper methods

```java
import io.qameta.allure.Allure;
...
Allure.addAttachment("My attachment", "My attachment content");

Path content = Paths.get("path-to-my-attachment-contnet");
    try (InputStream is = Files.newInputStream(content)) {
        Allure.addAttachemnt("My attachment", is);
}
```


> If return type in a method annotated with `@Attachment` differs from `String` or `byte[]` we call `toString()` on return value to get attachment contents.

You can specify exact MIME type for each attached file using type parameter of `@Attachment` annotation like shown above.
However there’s no need to explicitly specify attachment type for all attached files as Allure by default analyses attachment contents and can determine attachment type automatically.
You usually need to specify attachment type when working with plain text files.

### Links

To pass issues to report, just add `@issue=<ISSUE-NUMBER>` on top of Scenario on Feature in your `.feature` file.

To pass TMS links to report, just add `@tmsLink=<TEST-CASE-ID>` on top of Scenario on Feature in your `.feature` file.
>   do not forget to configure allure properties with link patterns.

### Severity

To set severity, add `@severity=blocker` on top of Scenario on Feature in your `.feature` file.
If severity has wrong value it will be forced to normal (default).

Supported severity values: `blocker`, `critical`, `normal`, `minor`, `trivial`.

###Test markers

Every Feature or Scenario can be annotated by following tags: `@flaky`, `@muted`, `@known`

### Test fixtures

All methods annotated by `@import cucumber.api.java.After` or `@cucumber.api.java.Before` annotations
will appear in the report as steps with method names.
If `@Before` execution fails, the scenario will be marked as skipped.
If `@After` execution fails, the scenario will be marked as passed, and only After method’s step
will be marked as failed.

### Behaviours Mapping

Allure Cucumber JVM integration uses information extracted from `Feature:` section.

### Configuration

Location of `allure-results` directory, and patterns for `@TmsLink` and `@Issue` links can be set by placing `allure.properties` file with following properties to resources directory: `src/test/resources`

*allure.properties*
```
allure.results.directory=target/allure-results
allure.link.issue.pattern=https://example.org/browse/{}
allure.link.tms.pattern=https://example.org/browse/{}
```

Or by setting system properties in `pom.xml`

*pom.xml*
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.20</version>
            <configuration>
                ...
                <systemPropertyVariables>
                    <allure.results.directory>${project.build.directory}/allure-results</allure.results.directory>
                    <allure.link.issue.pattern>https://example.org/browse/{}</allure.link.issue.pattern>
                    <allure.link.tms.pattern>https://example.org/browse/{}</allure.link.tms.pattern>
                </systemPropertyVariables>
            </configuration>
            ...
        </plugin>
    </plugins>
</build>
```
</details>