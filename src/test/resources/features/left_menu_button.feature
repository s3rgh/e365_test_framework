Feature: Кнопки левого меню

  Scenario: Переход в календарь по кнопке из левого меню
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    When Открыта главная страница
    And Нажать кнопку левого меню "Календарь"