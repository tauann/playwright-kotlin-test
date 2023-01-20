package page

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import com.microsoft.playwright.options.SelectOption

abstract class BasePage<T>(pwPage: Page) {

    private val dropdownSwitchTheme = pwPage.locator("#switch-version-select")

    protected abstract fun getThis(): T

    fun selectSwitchTheme(value: String): T {
        dropdownSwitchTheme.selectOption(SelectOption().setLabel(value))
        return getThis()
    }

    fun getText(locator: Locator): String = waitForLocator(locator).textContent()

    private fun waitForLocator(locator: Locator): Locator {
        locator.waitFor()
        return locator
    }

}
