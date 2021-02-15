Feature: Кнопки левого меню

  Scenario: Переход в Календарь по кнопке из левого меню
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    When Открыта главная страница
    And Нажать кнопку левого меню "Календарь"
    When Start page is opened
    And Нажать кнопку профиля
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Открыта главная страница

  Scenario: Переход в Задачи по кнопке из левого меню
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    When Открыта главная страница
    And Нажать кнопку левого меню "Задачи"
    When Start page is opened
    And Нажать кнопку профиля
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Открыта главная страница

  Scenario: Переход в Сообщения по кнопке из левого меню
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    When Открыта главная страница
    And Нажать кнопку левого меню "Сообщения"
    When Start page is opened
    And Нажать кнопку профиля
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Открыта главная страница