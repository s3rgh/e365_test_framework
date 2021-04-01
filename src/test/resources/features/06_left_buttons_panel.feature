Feature: Кнопки левого меню

#Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Click button Enter


#Переход в раздел Календарь по кнопке из левого меню
  Scenario: Переход в Календарь по кнопке из левого меню
    Given   Main page is opened
    And     Open unit "Календарь"
    Then    Unit "Календарь" is opened


#Переход в раздел Задачи по кнопке из левого меню
  Scenario: Переход в Задачи по кнопке из левого меню
    Given   Main page is opened
    And     Open unit "Задачи"
    Then    Unit "Задачи" is opened


#Переход в раздел Сообщения по кнопке из левого меню
  Scenario: Переход в Сообщения по кнопке из левого меню
    Given   Main page is opened
    And     Open unit "Сообщения"
    Then    Unit "Сообщения" is opened
