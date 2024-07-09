package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SingleProductPage(private val driver: WebDriver){
    @FindBy(className ="inventory_details_name")
    private val itemName: WebElement?=null
    @FindBy(id="add-to-cart")
    private val addToCartButton: WebElement?=null
    @FindBy(className ="shopping_cart_link")
    private val shoppingCartLink: WebElement?=null

    init {
        PageFactory.initElements(driver,this)
    }
    fun getItemName():String {
        return itemName!!.text

    }

    fun addItemToCart() {
        addToCartButton!!.click()
    }

    fun clickOnShoppingCartLink():CartPage {
        shoppingCartLink!!.click()
        return CartPage(driver)
    }
}