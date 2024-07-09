package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ProductsPage(private val driver: WebDriver) {
    @FindBy(id="item_4_title_link")
    private val item4Link: WebElement?=null

    init {
        PageFactory.initElements(driver,this)
    }

    fun clickOnItemLink(): SingleProductPage {
        item4Link!!.click()
        return SingleProductPage(driver)

    }

}