import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.BaseTest

class PlaywrightExample : BaseTest() {

    @Test
    fun shouldOpenPage() {
        val pageUrl = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
        page.navigate(pageUrl)
        assertEquals(pageUrl, page.url())
    }

}