package main

import main.pages.LogInPage
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import kotlin.test.AfterTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SauceDemoTest {
    private lateinit var driver : WebDriver

    @Test
    fun testLogIn() {
        driver=ChromeDriver()
        driver.get("https://www.saucedemo.com/")
        val loginPage= LogInPage(driver)
        loginPage.login("standard_user", "secret_sauce")
        val urlAfterLogin=driver.currentUrl
        assertEquals("https://www.saucedemo.com/inventory.html", urlAfterLogin)
    }

    @Test
    fun productPageItemClickTest() {
        driver=ChromeDriver()
        val loginPage= LogInPage(driver)
        val productsPage= loginPage.loginToProductPage()
        val singleProductPage= productsPage.clickOnItemLink()
        assertEquals("Sauce Labs Backpack", singleProductPage.getItemName())
    }

    @Test
    fun addItemToCartFromSingleProductPage() {
        driver=ChromeDriver()
        val singleProductsPage= LogInPage(driver).loginToProductPage().clickOnItemLink()
        singleProductsPage.addItemToCart()
        val cartPage= singleProductsPage.clickOnShoppingCartLink()
        assertEquals("Sauce Labs Backpack", cartPage.getCartItems())

    }

    @Test
    fun isInputFieldDisplayed() {
        driver=ChromeDriver()
        val singleProductsPage= LogInPage(driver).loginToProductPage().clickOnItemLink()
        singleProductsPage.addItemToCart()
        val cartPage= singleProductsPage.clickOnShoppingCartLink()
        val checkoutInformationPage=cartPage.clickOnCheckoutButton()

        assertTrue(checkoutInformationPage.isInputFieldDisplayed)
    }

    @Test
    fun isCheckoutCompleteContainerDisplayed() {
        driver=ChromeDriver()
        val singleProductsPage= LogInPage(driver).loginToProductPage().clickOnItemLink()
        singleProductsPage.addItemToCart()
        val cartPage= singleProductsPage.clickOnShoppingCartLink()
        val checkoutInformationPage=cartPage.clickOnCheckoutButton()
        val checkoutOverviewPage=checkoutInformationPage.inputInformation("Dina", "Dedajic", "71000" )
        val checkoutCompletePage=checkoutOverviewPage.clickFinishButton()
        assertTrue(checkoutCompletePage.isCompleteContainerDisplayed)

    }

    @Test
    fun checkoutOverviewItemNameMatch(){
        driver=ChromeDriver()
        val singleProductsPage= LogInPage(driver).loginToProductPage().clickOnItemLink()
        singleProductsPage.addItemToCart()
        val checkoutOverviewPage=singleProductsPage.clickOnShoppingCartLink().clickOnCheckoutButton().inputInformation("Dina", "Dedajic", "71000" )
        assertEquals("Sauce Labs Backpack",checkoutOverviewPage.inventoryItem)
    }


    @Test
    fun checkoutCompleteReturnHomeButtonTest() {
        driver=ChromeDriver()
        val singleProductsPage= LogInPage(driver).loginToProductPage().clickOnItemLink()
        singleProductsPage.addItemToCart()
        val checkoutCompletePage= singleProductsPage.clickOnShoppingCartLink().clickOnCheckoutButton().inputInformation("Dina", "Dedajic", "71000" ).clickFinishButton()
        checkoutCompletePage.homeButton()
        val urlAfterHomeButton=driver.currentUrl
        assertEquals("https://www.saucedemo.com/inventory.html", urlAfterHomeButton)

    }




    @AfterTest
    fun tearDown() {
        driver.close()
        driver.quit()
    }
}
