Feature: Кнопки левого меню

#Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "s3rgh+6@mail.ru" and password "ZAQxsw123"
    And   Click button Enter