package util

import com.microsoft.playwright.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

private const val URL = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"

abstract class BaseTest {

    protected lateinit var browserPage: Page

    private lateinit var context: BrowserContext

    @BeforeEach
    fun createContextAndPage() {
        context = browser.newContext()
        browserPage = context.newPage()
        browserPage.navigate(URL)
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
            browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(true))
        }

        @JvmStatic
        @AfterAll
        fun closeBrowser() {
            playwright.close()
        }
    }

}