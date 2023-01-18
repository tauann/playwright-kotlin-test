package util

import com.microsoft.playwright.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

abstract class BaseTest {

    protected lateinit var pwPage: Page
    private lateinit var context: BrowserContext

    @BeforeEach
    fun createContextAndPage() {
        context = browser.newContext()
        pwPage = context.newPage()
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
            browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
        }

        @JvmStatic
        @AfterAll
        fun closeBrowser() {
            playwright.close()
        }
    }

}