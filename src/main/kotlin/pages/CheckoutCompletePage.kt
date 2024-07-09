package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CheckoutCompletePage(private val driver: WebDriver) {
    @FindBy(id="checkout_complete_container")
    private val completeContainer: WebElement?=null
    @FindBy(id="back-to-products")
    private val backToProductsPageButton: WebElement?=null
    val isCompleteContainerDisplayed: Boolean get()= completeContainer!!.isDisplayed

    fun homeButton():ProductsPage {
        backToProductsPageButton!!.click()
        return ProductsPage(driver)
    }

    init {
        PageFactory.initElements(driver,this)
    }





}