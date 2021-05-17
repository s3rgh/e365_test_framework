Feature: Разделы

  #Precondition: Авторизоваться в системе под пользователем с правами администратора
  Background:
    Given Open start page "https://s-elma365.com"
    When  Start page is opened
    And   Hover mouseCursor to button enter
    And   Enter your login "kropot1842@mail.ru" and password "KropoT42"
    And   Click button Enter


  # Создать раздел
  #Scenario: Создать раздел
  #  Given   Main page is opened


  # Скачать раздел (Выбрать готовый Раздел из каталога)
  #Scenario: Скачать раздел (Выбрать готовый Раздел из каталога)
  #  Given   Main page is opened


  # Скачать раздел (Загрузить файл)
  #Scenario: Скачать раздел (Загрузить файл)
  #  Given   Main page is opened