Feature: Верхнее меню

  #Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "s3rgh+6@mail.ru" and password "ZAQxsw123"
    And   Click button Enter


  # Запустить бизнес-процесс по кнопке из верхнего меню
  Scenario: Создать задачу по кнопке из верхнего меню
    Given   Main page is opened
    And     Click button "Создать"
    And     Settings popover is opened
    And     Click popover button "Запустить бизнес-процесс"
    And     Dialog is opened
    And     Click dialog button "Системные процессы"
    And     Click dialog button "Задача"
    And     Modal form "Задача" is opened
    And     Fill modal form field "Тема" with text "topic@"
    And     Fill modal form field "Исполнитель" with text "Test1"
    And     User choice is available
    And     Click button "Создать задачу"
    Then    Message "Создана новая задача" is shown


  # Создать задачу по кнопке из верхнего меню
  Scenario: Запустить бизнес-процесс по кнопке из верхнего меню
    Given   Main page is opened
    And     Click button "Создать"
    And     Settings popover is opened
    And     Click popover button "Задача"
    And     Modal form "Задача" is opened
    And     Fill modal form field "Тема" with text "topic@"
    And     Fill modal form field "Исполнитель" with text "Test1"
    And     User choice is available
    And     Click button "Создать задачу"
    Then    Message "Создана новая задача" is shown


  # Запустить конкретный бизнес-процесс по кнопке из верхнего меню
  Scenario: Запустить конкретный бизнес-процесс по кнопке из верхнего меню
    Given   Main page is opened
    And     Click button "Создать"
    And     Settings popover is opened
    And     Click popover button "test_process"
    And     Dialog is opened
    And     Fill dialog field "Название" with text "Process"
    And     Click button "Задача"
    Then    Message "Запущен процесс" is shown


  # Создать элемент приложения по кнопке из верхнего меню
  Scenario: Создать элемент приложения по кнопке из верхнего меню
    Given   Main page is opened
    And     Click button "Создать"
    And     Settings popover is opened
    And     Click popover button "Test"
    And     Click popover button "test_app"
    And     Modal form "test_app" is opened
    And     Fill modal form field "Название" with text "name@"
    And     Click button "Сохранить"
    Then    Message "успешно создан" is shown


  # Проверить отображение приложений по разделам в верхнем меню
  Scenario: Проверить отображение приложений по разделам в верхнем меню
    Given   Main page is opened