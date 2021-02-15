Feature: Авторизация пользователя

  Scenario: Переход в календарь по кнопке из левого меню
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    Then Открыта главная страница