@tag
Feature: Title of your feature
  I want to use this template for my feature file


  @tag2
  Scenario Outline: First Shopping scenario for "<channel>"
    Given Set channel "<channel>"
    Then Login into Application
    And perform amazon shopping

    Examples: 
      | channel |
      | UI      |
      |API|
  
  
  
  #Scenario Outline: Second Shooping scenario for "<channel>"
    #Given Set channel "<channel>"
    #Then Login into Application
    #And perform amazon shopping
#
    #Examples: 
      #| channel |
      #| UI      |
      #|API|
