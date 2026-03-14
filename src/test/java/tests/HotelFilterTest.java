package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
import pages.actions.HotelPageActions;
import pages.actions.HotelResultPageActions;
import pages.elements.HotelResultPage;

public class HotelFilterTest extends BaseTest{

    @Test
    public void searchAndFilterHotelTest(){
        HomePageActions homepage = new HomePageActions();
        HotelPageActions hotelPage = new HotelPageActions();
        HotelResultPageActions hotelResultPage = new HotelResultPageActions();

        homepage.selectLanguage();
        homepage.selectHotelPage();

        hotelPage.selectDestination();
        hotelPage.searchHotel();

        Assert.assertTrue(hotelResultPage.isHotelResultPageOpened(), "Search Hotel Page is not Opened");

        hotelResultPage.selectFilter();
        hotelResultPage.sortResults();
        Assert.assertTrue(hotelResultPage.isSortedPricesCorrect(), "Sort Prices are not correct");
    }
}
