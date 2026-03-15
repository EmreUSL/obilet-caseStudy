package tests;

import assertions.AssertActions;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
import pages.actions.HotelPageActions;
import pages.actions.HotelResultPageActions;

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

        AssertActions.assertTrue(hotelResultPage.isHotelResultPageOpened(), "Verify hotel result page is opened");

        hotelResultPage.selectFilter();
        AssertActions.assertTrue(hotelResultPage.isFilterSelected(), "Verify filter is selected");

        hotelResultPage.sortResults();
        AssertActions.assertTrue(hotelResultPage.isSortedPricesCorrect(), "Verify prices are sorted correctly");
    }
}
