package page

import com.microsoft.playwright.Page
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import java.util.regex.Pattern

class ListPage(private val page: Page) : CommonPage(page) {

    private val buttonAddRecord = page.locator("text=Add Record")
    private val fieldSearchName = page.locator("input[name='customerName']")
    private val clearSearchName = page.locator(".clear-search")
    private val radioToggleSelectAll = page.locator(".select-all-none")
    private val buttonDeleteSelected = page.locator(".delete-selected-button")
    private val bodyModal = page.locator(".alert-delete-multiple")
    private val buttonModalDelete = page.locator(".delete-multiple-confirmation-button")
    private val messageSuccess = page.locator("span[data-growl='message']")

    fun clickAddRecord(): AddCustomerPage {
        buttonAddRecord.click()
        return AddCustomerPage(page)
    }

    fun fillSearchName(text: String): ListPage {
        fieldSearchName.fill(text)
        fieldSearchName.press("Enter")
        clearSearchName.waitFor()
        return this
    }

    fun clickToggleSelectAll(): ListPage {
        radioToggleSelectAll.click()
        return this
    }

    fun clickDeleteSelected(): ListPage {
        buttonDeleteSelected.click()
        return this
    }

    fun verifyModalText(text: String): ListPage {
        assertThat(bodyModal).hasText(Pattern.compile(".*$text.*"))
        return this
    }

    fun clickModalDelete(): ListPage {
        buttonModalDelete.click()
        return this
    }

    fun verifySuccessText(text: String): ListPage {
        assertThat(messageSuccess).hasText(text)
        return this
    }

}