package org.masha.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilteringAndSortingSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("^I set (.*) value in min cost field and press OK$")
    public void setValueInMinCostFieldAndPressEnter(String minCost) {
        searchResultsPage.getMinPriceInput().clear();
        searchResultsPage.getMinPriceInput().setValue(minCost);
        searchResultsPage.getPriceFilterOKButton().click();
    }

    @Then("^I verify that all prices greater than (.*)$")
    public void assetThatAllGoodsPricesGreaterThatValue(int cost) {
        for (Integer price: searchResultsPage.getGoodsPrices()) {
            assertTrue(price >= cost);
        }
    }
}
