$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/SSNMissing.feature");
formatter.feature({
  "line": 2,
  "name": "SSN Missing",
  "description": "",
  "id": "ssn-missing",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SSNMissing"
    }
  ]
});
formatter.before({
  "duration": 22109411426,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "SSN Missing",
  "description": "",
  "id": "ssn-missing;ssn-missing",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I select Let\u0027s Go button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_am_on_Home_page()"
});
formatter.result({
  "duration": 1446711774,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.i_select_Let_s_Go_button()"
});
formatter.result({
  "duration": 10199563769,
  "status": "passed"
});
formatter.after({
  "duration": 813775637,
  "status": "passed"
});
});