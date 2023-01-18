package util

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

abstract class BaseTest {

    protected lateinit var page: Page
    private lateinit var context: BrowserContext

    @BeforeEach
    fun createContextAndPage() {
        context = browser.newContext()
        page = context.newPage()
    }

    @AfterEach
    fun closeContext() {
        context.close()
    }

    companion object {
        private lateinit var playwright: Playwright
        private lateinit var browser: Browser

        @JvmStatic
        @BeforeAll
        fun launchBrowser() {
            playwright = Playwright.create()
            browser = playwright.chromium().launch()
        }

        @JvmStatic
        @AfterAll
        fun closeBrowser() {
            playwright.close()
        }
    }

}