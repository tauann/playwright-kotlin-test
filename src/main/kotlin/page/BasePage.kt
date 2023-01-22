package page

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import com.microsoft.playwright.options.SelectOption

abstract class BasePage<T>(pwPage: Page) {

    protected abstract fun getThis(): T

    private val dropdownSwitchTheme = pwPage.locator("#switch-version-select")

    fun switchTheme(value: String): T {
        dropdownSwitchTheme.selectOption(SelectOption().setLabel(value))
        return getThis()
    }

    fun getText(locator: Locator): String = waitForLocator(locator).textContent()

    protected fun waitForLocator(locator: Locator): Locator {
        locator.waitFor()
        return locator
    }

}
