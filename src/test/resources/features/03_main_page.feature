Feature: ELMA 365 Главная страница

  #Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Click button Enter


    # Используя кнопку на основной странице
  Scenario: Добавить раздел с главной страницы
    Given   Main page is opened
    And     Click button Create Unit
    And     Click dialog button "Создать"
    And     Click dialog button "Раздел"
    And     Fill dialog field "Название Раздела" with text "Test"
    And     Click dialog button "Создать"
    Then    Unit created


    # Используя кнопку в левом меню
  Scenario: Добавить раздел по кнопке в левом меню
    Given   Main page is opened
    And     Click left menu button Create Unit
    And     Click dialog button "Создать"
    And     Click dialog button "Раздел"
    And     Fill dialog field "Название Раздела" with text "Test"
    And     Click dialog button "Создать"
    Then    Unit created


  Scenario: Перейти в приложения с главной страницы
    Given   Main page is opened
    And     Open unit "Компания"
    Then    Unit "Компания" is opened


  Scenario: Настроить страницу в две колонки
    Given   Main page is opened
    And     Click button settings
    And     Settings popover is opened
    And     Click popover button "Настройки страницы"
    And     Dialog is opened
    And     Click dialog button "Две колонки"
    And     Click dialog button "Сохранить"
    Then    Two column is displayed


  Scenario: Настроить страницу в одну колонку
    Given   Main page is opened
    And     Click button settings
    And     Settings popover is opened
    And     Click popover button "Настройки страницы"
    And     Dialog is opened
    And     Click dialog button "Одна колонка"
    And     Click dialog button "Сохранить"
    Then    One column is displayed


  # Добавить пользователя с главной страницы
  Scenario: Добавить пользователя с главной страницы
    Given   Main page is opened
    And     Open unit "Администрирование"
    And     Unit "Администрирование" is opened
    And     Open "Пользователи" application
    And     App "Пользователи" is opened
    And     Click button "+ Пользователь"
    And     Modal form "Приглашение пользователя" is opened
    And     Fill modal form field "Эл. почта" with text "vasya@mailinator.com"
    And     Click button "Выслать приглашение"
    Then    User is created


  # Перейти в чат технической поддержки с главной страницы
  Scenario: Перейти в чат технической поддержки с главной страницы
    Given   Main page is opened
    And     Open unit "Сообщения"
    And     Unit "Сообщения" is opened
    And     Open "Техническая поддержка" application
    And     App "Техническая поддержка" is opened