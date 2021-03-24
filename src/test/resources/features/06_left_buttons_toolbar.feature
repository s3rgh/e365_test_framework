Feature: Кнопки левого меню

#Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "s3rgh+6@mail.ru" and password "ZAQxsw123"
    And   Click button Enter

  Scenario: Переход в Календарь по кнопке из левого меню
    When Main page is opened
    And Нажать кнопку левого меню "Календарь"
    When Start page is opened
    And Click profile button
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Main page is opened

  Scenario: Переход в Задачи по кнопке из левого меню
    When Main page is opened
    And Нажать кнопку левого меню "Задачи"
    When Start page is opened
    And Click profile button
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Main page is opened

  Scenario: Переход в Сообщения по кнопке из левого меню
    When Main page is opened
    And Нажать кнопку левого меню "Сообщения"
    When Start page is opened
    And Click profile button
    And Нажать кнопку для выхода "Выйти"
    When открыт Exit Dialog
    And Нажать ОК
    Then Main page is opened