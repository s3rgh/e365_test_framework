Feature: Кнопки левого меню

    """ Given open start page "https://25gnp6o6ro6lu.elma365.ru/"
    When Start page is opened
    And hover mouseCursor to email enter
  # And enter your login "k.matveev+1@elma-bpm.com" and password "matVcxzqwe1"
   And click button Enter
     Then Открыта главная страница """
  Scenario: открытие раздела Календарь
    Given open start page "https://s-elma365.com"
    When Start page is opened
    And hover mouseCursor to button enter
    And enter your login "Krouwander@yandex.ru" and password "matVcxzqwe1"
    And click button Enter
    Then Открыта главная страница

