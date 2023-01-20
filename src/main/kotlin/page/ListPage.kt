package page

import com.microsoft.playwright.Page

class ListPage(private val page: Page) : BasePage<ListPage>(page) {

    private val buttonAddRecord = page.locator("text=Add Record")
    private val fieldSearchName = page.locator("input[name='customerName']")
    private val clearSearchName = page.locator(".clear-search")
    private val radioToggleSelectAll = page.locator(".select-all-none")
    private val buttonDeleteSelected = page.locator(".delete-selected-button")
    private val bodyModal = page.locator(".alert-delete-multiple")
    private val buttonModalDelete = page.locator(".delete-multiple-confirmation-button")
    private val messageSuccess = page.locator("span[data-growl='message']")

    override fun getThis(): ListPage = this

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

    fun getTextModal(text: String): String = getText(bodyModal).trim()

    fun clickModalDelete(): ListPage {
        buttonModalDelete.click()
        return this
    }

    fun getTextSuccess(text: String): String = getText(messageSuccess)

}