package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class LogInPage(private val driver: WebDriver) {
    @FindBy(id="user-name")
    private val userNameInput: WebElement?=null
    @FindBy(id="password")
    private val userPasswordInput: WebElement?=null
    @FindBy(id="login-button")
    private val loginButton: WebElement?=null

    init {
        PageFactory.initElements(driver,this)
    }
    fun login(userName:String, userPassword: String){
        userNameInput!!.sendKeys(userName)
        userPasswordInput!!.sendKeys(userPassword)
        loginButton!!.click()
    }
    fun loginToProductPage():ProductsPage{
        driver.get("https://www.saucedemo.com/")
        userNameInput!!.sendKeys("standard_user")
        userPasswordInput!!.sendKeys("secret_sauce")
        loginButton!!.click()
        return ProductsPage(driver)

    }
}