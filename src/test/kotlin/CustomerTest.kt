import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page.ListPage
import util.BaseTest
import kotlin.test.assertEquals

class CustomerTest : BaseTest() {

    private val pageUrl = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
    private val saveSuccessMessage =
        "Your data has been successfully stored into the database. Edit Record or Go back to list"

    private lateinit var page: ListPage

    @BeforeEach
    fun goToUrl() {
        pwPage.navigate(pageUrl)
        page = ListPage(pwPage)
    }

    @Test
    fun shouldAddACustomer() {
        val addPage = fillAllCustomerFields()

        assertEquals(saveSuccessMessage, addPage.getTextReportMessage())
    }

//    @Test
//    fun shouldAddAndDeleteCustomer() {
//        val addPage = fillAllCustomerFields()
//        page
//            .clickGoBackToList()
//            .fillSearchName("User Test")
//            .clickToggleSelectAll()
//            .clickDeleteSelected()
//            .getTextModal("Are you sure that you want to delete")
//            .clickModalDelete()
//        page
//            .getTextSuccess("Your data has been successfully deleted from the database.")
//    }

    private fun fillAllCustomerFields() = page
        .selectSwitchTheme("Bootstrap V4 Theme")
        .clickAddRecord()
        .fillCustomerName("User Test")
        .fillContactLastName("Test")
        .fillContactFirstName("User")
        .fillPhone("99 99999-9999")
        .fillAddressLine1("Some Street")
        .fillAddressLine2("None")
        .fillCity("New York")
        .fillState("NY")
        .fillPostalCode("99999-999")
        .fillCountry("USA")
        .fillSalesRepEmployeeNumber("99")
        .fillCreditLimit("999999")
        .clickSave()

}