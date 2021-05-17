Feature: Авторизация пользователя

  Scenario: Авторизация пользователя с КОРРЕКТНЫМИ учетными данными
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Click button Enter
    Then  Main page is opened


  Scenario Outline: Авторизация пользователя с НЕКОРРЕКТНЫМИ учетными данными
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "<login>" and password "<password>"
    And   Click button Enter
    Then  Email or password is incorrect

    Examples:
      | login           | password     |
      | s3rgh+4@mail.ru | 321321321321 |
      | sergh@mail.ru   | ZAQxsw123    |


  Scenario: Проверка настройки "Запомнить меня"
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Select remember me checkBox
    And   Click button Enter
    Then  Main page is opened


  Scenario: Проверка выхода из системы
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Click button Enter
    When  Main page is opened
    And   Click profile button
    And   Profile popover is opened
    And   Click user profile button "Выйти"
    When  Dialog is opened
    And   Click dialog button "Отмена"
    And   Click profile button
    And   Click user profile button "Выйти"
    When  Dialog is opened
    And   Click dialog button "ОК"
    Then  Login title text is displayed