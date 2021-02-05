@Owner("Mezinov_Sergey")
Feature: FIRST TEST
  @severity=blocker
  Scenario: open start page
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And click button
    And enter your name "Фамилия и имя" to field "Мезинов Сергей"
    And enter your name "Электронная почта" to field "email@mail.ru"
    And enter your name "Номер телефона" to field "88005553535"
    And enter your name "Название компании" to field "Рога и копыта"
    And enter your name "Должность" to field "Директор"