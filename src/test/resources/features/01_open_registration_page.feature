Feature: Получение пробного стенда
  Scenario: Активация бесплатной версии
    Given   Open start page "https://s-elma365.com"
    When    Start page is opened
    And     Click try button
    And     Enter your data "Мезинов Сергей" to field "Фамилия и имя"
    And     Enter your data "email@mail.ru" to field "Электронная почта"
    And     Enter your data "88005553535" to field "Номер телефона"
    And     Enter your data "Рога и копыта" to field "Название компании"
    And     Enter your data "Automation QA engineer" to field "Должность"
    And     Choose item "< 20" in list on label "Численность компании"
    And     Accept the terms of the user agreement
    And     Click submit button "Попробовать (14 дней бесплатно)"
    #And     Click captcha
    Then    Success reg message is displayed