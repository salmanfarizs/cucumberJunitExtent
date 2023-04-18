@tag
Feature: Title of your feature
  I want to use this template for my feature file


  @tag2
  Scenario Outline: 1st Title of your scenario outline "<channel>"
    Given Set channel "<channel>"
    Then Login into Application
    And perform amazon shopping

    Examples: 
      | channel |
      | UI      |
      |API|
  
  
  
  Scenario Outline: 2nd Title of your scenario outline "<channel>"
    Given Set channel "<channel>"
    Then Login into Application
    And perform amazon shopping

    Examples: 
      | channel |
      | UI      |
      |API|
