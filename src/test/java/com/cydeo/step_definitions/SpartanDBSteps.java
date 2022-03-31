package com.cydeo.step_definitions;

import com.cydeo.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class SpartanDBSteps {

    String query;
    Map<String, Object> rowMap;
    @When("User gets info of a certain spartan with ID {int}")
    public void user_gets_info_of_a_certain_spartan_with_id(Integer id) {
        query = "select * from spartans where spartan_id="+id;
        rowMap = DBUtils.getRowMap(query);
        System.out.println("rowMap = " + rowMap);
   }
    @Then("Spartan name should be {string}")
    public void spartan_name_should_be(String expectedName) {
        String actualName = (String) rowMap.get("name");
       Assert.assertEquals(expectedName,actualName);
    }
}
