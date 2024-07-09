package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CartPage(private val driver: WebDriver) {
    init {
        PageFactory.initElements(driver,this)
    }
    @FindBy(className = "inventory_item_name")
    private val cartItemName: WebElement?=null
    @FindBy(id= "checkout")
    private val checkoutButton: WebElement?=null

    fun getCartItems(): String {
        return cartItemName!!.text
    }

    fun clickOnCheckoutButton():CheckoutInformationPage {
        checkoutButton!!.click()
        return CheckoutInformationPage(driver)

    }
}