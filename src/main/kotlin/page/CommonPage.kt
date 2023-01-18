package page

import com.microsoft.playwright.Page

open class CommonPage(private val page: Page) {

    private val dropdownSwitchTheme = page.locator("#switch-version-select")

    fun selectSwitchTheme(value: String): ListPage {
        dropdownSwitchTheme.selectOption(value)
        return ListPage(page)
    }

}
