#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Manage ToDo List 
  
   @Homepage
   Scenario: Navigate to Homepage
      
    Given User is on Home page
    Then ToDos Header should be visible
    
    @AddingItems
    Scenario: Add an Item to ToDo List
    
    	Given User is on Home page
    	When Add Item to ToDo List as "My test item one"
    	When Add Item to ToDo List as "My test item two"
    	When Add Item to ToDo List as "My test item three"
    	Then Items Left to Complete as "3"
    	
    @MarkItemAsComplete
    Scenario: Mark Item Completed
    	Given User is on Home page
      When Add Item to ToDo List as "My test item one"
    	When Add Item to ToDo List as "My test item two"
    	When Add Item to ToDo List as "My test item three" 
    	When Mark Item Completed as "My test item two"
    	Then Items Left to Complete as "2"
    	When Navigate to Completed
    	Then Item Listed In completed as "My test item two"
    	When Navigate to Active
    	Then Verify Item In Active as "My test item one"
    	Then Verify Item In Active as "My test item three"
    	
    	@ClearCompleted
    	Scenario: Clear Completed Items
    	Given User is on Home page
      When Add Item to ToDo List as "My test item one"
    	When Add Item to ToDo List as "My test item two"
    	When Add Item to ToDo List as "My test item three" 
    	When Mark Item Completed as "My test item two"
    	When Navigate to Completed
    	When Clear Completed Items
    	When Navigate to All
    	Then Verify Number of Items as 2
    	
    	@DeleteItem
    	Scenario: Delete Items
    	Given User is on Home page
      When Add Item to ToDo List as "My test item one"
    	When Add Item to ToDo List as "My test item two"
    	When Add Item to ToDo List as "My test item three" 
    	When Delete Item from ToDo List as "My test item two"
    	Then Verify Number of Items as 2
    	
   