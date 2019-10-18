package selenium;

import com.szendzij.FirstSeleniumProject.pages.HomePage;
import com.szendzij.FirstSeleniumProject.pages.ShopingCartPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ShopingTest extends InitialTest {
    private HomePage homePage;
    private ShopingCartPage shopingPage;


    @Test
    public void asCustomerIWantBuyABlouse() throws InterruptedException {

        final String expectedBlousePrice = "$27.00";
        final String expectedShippingCost = "$2.00";

        //given
        homePage = new HomePage();
        shopingPage = new ShopingCartPage();

        homePage.moveToBlouseElement();
        homePage.waitForAddToCartBlouseElement();
        homePage.clickAddToCartBlouseElement();

        //when
        homePage.waitForProceedElement();
        homePage.clickProceedBtn();

        //then
        assertEquals(expectedBlousePrice, shopingPage.getBlousePrice());
        assertEquals(expectedShippingCost, shopingPage.getShippingCosts());
    }
}
