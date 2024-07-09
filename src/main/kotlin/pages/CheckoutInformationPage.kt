package main.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CheckoutInformationPage (private val driver: WebDriver) {
    @FindBy(id="first-name")
    private val firstNameInput: WebElement? = null
    @FindBy(id="last-name")
    private val lastNameInput: WebElement? = null
    @FindBy(id="postal-code")
    private val postalCodeInput: WebElement? = null
    @FindBy(id="continue")
    private val continueButton: WebElement? = null

    init {
        PageFactory.initElements(driver,this)
    }

    fun inputInformation(firstName:String, lastName:String, postalCode:String):CheckoutOverviewPage {
        firstNameInput!!.sendKeys(firstName)
        lastNameInput!!.sendKeys(lastName)
        postalCodeInput!!.sendKeys(postalCode)
        continueButton!!.click()
        return CheckoutOverviewPage(driver)

    }

    val isInputFieldDisplayed: Boolean get()= firstNameInput!!.isDisplayed









}