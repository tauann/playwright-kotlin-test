package page

import com.microsoft.playwright.Page

class ListPage(private val page: Page) : BasePage<ListPage>(page) {

    private val addRecordButton = page.locator("text=Add Record")
    private val searchNameField = page.locator("input[name='customerName']")
    private val clearSearchButton = page.locator(".clear-search")
    private val toggleSelectAllButton = page.locator(".select-all-none")
    private val deleteSelectedButton = page.locator(".delete-selected-button")
    private val deleteAlertBody = page.locator(".alert-delete-multiple-one")
    private val modalConfirmButton = page.locator(".delete-multiple-confirmation-button")
    private val message = page.locator("span[data-growl='message']")

    override fun getThis(): ListPage = this

    fun addRecord(): AddCustomerPage {
        addRecordButton.click()
        return AddCustomerPage(page)
    }

    fun fillSearchName(text: String): ListPage {
        searchNameField.fill(text)
        searchNameField.press("Enter")
        waitForLocator(clearSearchButton)
        return this
    }

    fun toggleSelectAll(): ListPage {
        toggleSelectAllButton.click()
        return this
    }

    fun deleteSelected(): ListPage {
        deleteSelectedButton.click()
        return this
    }

    fun getDeleteAlertText(): String = getText(deleteAlertBody).trim()

    fun confirmDelete(): ListPage {
        modalConfirmButton.click()
        return this
    }

    fun getMessage(): String = getText(message)

}