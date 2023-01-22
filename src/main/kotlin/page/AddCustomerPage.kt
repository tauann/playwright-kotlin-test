package page

import com.microsoft.playwright.Page

class AddCustomerPage(private val page: Page) : BasePage<AddCustomerPage>(page) {

    private val customerNameField = page.locator("#field-customerName")
    private val contactLastNameField = page.locator("#field-contactLastName")
    private val contactFirstNameField = page.locator("#field-contactFirstName")
    private val phoneField = page.locator("#field-phone")
    private val addressLine1Field = page.locator("#field-addressLine1")
    private val addressLine2Field = page.locator("#field-addressLine2")
    private val cityField = page.locator("#field-city")
    private val stateField = page.locator("#field-state")
    private val postalCodeField = page.locator("#field-postalCode")
    private val countryField = page.locator("#field-country")
    private val salesRepEmployeeNumberField = page.locator("#field-salesRepEmployeeNumber")
    private val creditLimitField = page.locator("#field-creditLimit")
    private val savebutton = page.locator("#form-button-save")
    private val reportSuccessMessage = page.locator("#report-success")
    private val goBackToListLink = page.locator("text='Go back to list'")

    override fun getThis(): AddCustomerPage = this

    fun fillCustomerName(text: String): AddCustomerPage {
        customerNameField.fill(text)
        return this
    }

    fun fillContactLastName(text: String): AddCustomerPage {
        contactLastNameField.fill(text)
        return this
    }

    fun fillContactFirstName(text: String): AddCustomerPage {
        contactFirstNameField.fill(text)
        return this
    }

    fun fillPhone(text: String): AddCustomerPage {
        phoneField.fill(text)
        return this
    }

    fun fillAddressLine1(text: String): AddCustomerPage {
        addressLine1Field.fill(text)
        return this
    }

    fun fillAddressLine2(text: String): AddCustomerPage {
        addressLine2Field.fill(text)
        return this
    }

    fun fillCity(text: String): AddCustomerPage {
        cityField.fill(text)
        return this
    }

    fun fillState(text: String): AddCustomerPage {
        stateField.fill(text)
        return this
    }

    fun fillPostalCode(text: String): AddCustomerPage {
        postalCodeField.fill(text)
        return this
    }

    fun fillCountry(text: String): AddCustomerPage {
        countryField.fill(text)
        return this
    }

    fun fillSalesRepEmployeeNumber(text: String): AddCustomerPage {
        salesRepEmployeeNumberField.fill(text)
        return this
    }

    fun fillCreditLimit(text: String): AddCustomerPage {
        creditLimitField.fill(text)
        return this
    }

    fun save(): AddCustomerPage {
        savebutton.click()
        return this
    }

    fun getReportSuccessText(): String = getText(reportSuccessMessage)

    fun goBackToList(): ListPage {
        goBackToListLink.click()
        return ListPage(page)
    }

}