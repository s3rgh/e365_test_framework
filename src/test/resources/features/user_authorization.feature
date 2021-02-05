Feature: Авторизация пользователя

  Scenario: Авторизация пользователя с КОРРЕКТНЫМИ учетными данными
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "s3rgh+5@mail.ru" and password "ZAQxsw123"
    And click button Enter
    Then Открыта главная страница

  Scenario Outline: Авторизация пользователя с НЕКОРРЕКТНЫМИ учетными данными
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "<login>" and password "<password>"
    And click button Enter
    Then E-mail или пароль указан не верно

    Examples:
      | login           | password     |
      | s3rgh+4@mail.ru | 321321321321 |
      | sergh@mail.ru   | ZAQxsw123    |


  Scenario: Проверить работу настройки "Запомнить меня"
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "s3rgh+5@mail.ru" and password "ZAQxsw123"
    And select remember me checkBox
    And click button Enter
    Then Открыта главная страница


  Scenario: Проверка выхода из системы
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "s3rgh+5@mail.ru" and password "ZAQxsw123"
    And click button Enter
    When Открыта главная страница
    And Нажать кнопку профиля
    And Профиль диалог открыт
    And Нажать кнопку "Выйти"
    When открыт Exit Dialog
    And Нажать отмена
    And Нажать кнопку профиля
    And Нажать кнопку "Выйти"
    And Нажать ОК
    Then Открыта главная страница