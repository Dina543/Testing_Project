package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CheckoutOverviewPage(private val driver: WebDriver) {
    @FindBy(className = "inventory_item_name")
    private val inventoryItemName: WebElement?=null
    @FindBy(id = "finish")
    private val finishButton: WebElement?=null
    val inventoryItem:String get()=inventoryItemName!!.text


    fun clickFinishButton():CheckoutCompletePage{
        finishButton?.click()
        return CheckoutCompletePage(driver)
    }





    init {
        PageFactory.initElements(driver,this)
    }
}