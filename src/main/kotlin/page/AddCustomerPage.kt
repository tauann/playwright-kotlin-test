package page

import com.microsoft.playwright.Page
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat

class AddCustomerPage(private val page: Page) : CommonPage(page) {

    private val fieldCustomerName = page.locator("#field-customerName")
    private val fieldContactLastName = page.locator("#field-contactLastName")
    private val fieldContactFirstName = page.locator("#field-contactFirstName")
    private val fieldPhone = page.locator("#field-phone")
    private val fieldAddressLine1 = page.locator("#field-addressLine1")
    private val fieldAddressLine2 = page.locator("#field-addressLine2")
    private val fieldCity = page.locator("#field-city")
    private val fieldState = page.locator("#field-state")
    private val fieldPostalCode = page.locator("#field-postalCode")
    private val fieldCountry = page.locator("#field-country")
    private val fieldSalesRepEmployeeNumber = page.locator("#field-salesRepEmployeeNumber")
    private val fieldCreditLimit = page.locator("#field-creditLimit")
    private val buttonSave = page.locator("#form-button-save")
    private val reportSuccess = page.locator("#report-success")
    private val linkGoBackToList = page.locator("text='Go back to list'")

    fun fillCustomerName(text: String): AddCustomerPage {
        fieldCustomerName.fill(text)
        return this
    }

    fun fillContactLastName(text: String): AddCustomerPage {
        fieldContactLastName.fill(text)
        return this
    }

    fun fillContactFirstName(text: String): AddCustomerPage {
        fieldContactFirstName.fill(text)
        return this
    }

    fun fillPhone(text: String): AddCustomerPage {
        fieldPhone.fill(text)
        return this
    }

    fun fillAddressLine1(text: String): AddCustomerPage {
        fieldAddressLine1.fill(text)
        return this
    }

    fun fillAddressLine2(text: String): AddCustomerPage {
        fieldAddressLine2.fill(text)
        return this
    }

    fun fillCity(text: String): AddCustomerPage {
        fieldCity.fill(text)
        return this
    }

    fun fillState(text: String): AddCustomerPage {
        fieldState.fill(text)
        return this
    }

    fun fillPostalCode(text: String): AddCustomerPage {
        fieldPostalCode.fill(text)
        return this
    }

    fun fillCountry(text: String): AddCustomerPage {
        fieldCountry.fill(text)
        return this
    }

    fun fillSalesRepEmployeeNumber(text: String): AddCustomerPage {
        fieldSalesRepEmployeeNumber.fill(text)
        return this
    }

    fun fillCreditLimit(text: String): AddCustomerPage {
        fieldCreditLimit.fill(text)
        return this
    }

    fun clickSave(): AddCustomerPage {
        buttonSave.click()
        return this
    }

    fun verifyReportMessage(message: String): AddCustomerPage {
        assertThat(reportSuccess).hasText(message)
        return this
    }

    fun clickGoBackToList(): ListPage {
        linkGoBackToList.click()
        return ListPage(page)
    }


}