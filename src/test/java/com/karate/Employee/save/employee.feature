Feature: Create and read employee...

	 Background:
    * url baseUrl
    * def employeeCreate = '/employee/'

  Scenario: Create an employee:Success

    Given path employeeCreate
    And request { emp_name: 'Johney', blood_group: 'B positive', age: 30, salary: 6000, manager: 'Ella', team: 'OEP', department: 'Digital', goals: 'excellence', experience: '20' }
    And header Accept = 'application/json'
    When method post
    Then status 200
    * print 'the response is' , response
    * def responseR = response
    * def TestVal = { emp_name: 'Johney', manager: 'Ella', team: 'OEP', department: 'Digital', goals: 'excellence', experience: '20'}
    * match responseR contains TestVal
     
   Scenario: Create an employee:Failure

    Given path employeeCreate
    And request {blood_group: 'B positive', age: 30, salary: 6000, manager: 'Ella', team: 'OEP', department: 'Digital', goals: 'excellence', experience: '20' }
    And header Accept = 'application/json'
    When method post
    Then status 500