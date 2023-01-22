import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage
import util.BaseTest
import kotlin.test.assertEquals

private const val SAVE_SUCCESS_MESSAGE = "Your data has been successfully stored into the database. Edit Record or Go back to list"
private const val DELETE_QUESTION = "Are you sure that you want to delete this 1 item?"
private const val DELETE_SUCCESSFULL = "Your data has been successfully deleted from the database."

class CustomerTest : BaseTest() {

    private lateinit var listPage: ListPage
    private lateinit var addCustomerPage: AddCustomerPage

    @BeforeEach
    fun preConditions() {
        listPage = ListPage(browserPage)
        addCustomerPage = AddCustomerPage(browserPage)

        listPage.switchTheme("Bootstrap V4 Theme")
    }

    @Test
    fun shouldAddACustomer() {
        listPage.addRecord()

        addCustomerPage
            .fillCustomerName("User Test 1")
            .fillContactLastName("Test")
            .fillContactFirstName("User")
            .fillPhone("99 99999-9999")
            .fillAddressLine1("Some Street")
            .fillAddressLine2("None")
            .fillCity("New York")
            .fillState("NY")
            .fillPostalCode("99999-999")
            .fillCountry("BRAZIL")
            .fillSalesRepEmployeeNumber("99")
            .fillCreditLimit("999999")
            .save()

        assertEquals(SAVE_SUCCESS_MESSAGE, addCustomerPage.getReportSuccessText())
    }

    @Test
    fun shouldAddAndDeleteCustomer() {
        val name = "User Test 2"

        listPage.addRecord()

        addCustomerPage
            .fillCustomerName(name)
            .fillContactLastName("Test")
            .fillContactFirstName("User")
            .fillPhone("99 99999-9999")
            .fillAddressLine1("Some Street")
            .fillAddressLine2("None")
            .fillCity("New York")
            .fillState("NY")
            .fillPostalCode("99999-999")
            .fillCountry("BRAZIL")
            .fillSalesRepEmployeeNumber("99")
            .fillCreditLimit("999999")
            .save()
            .goBackToList()

        listPage
            .fillSearchName(name)
            .toggleSelectAll()
            .deleteSelected()

        assertEquals(DELETE_QUESTION, listPage.getDeleteAlertText())

        listPage.confirmDelete()

        assertEquals(DELETE_SUCCESSFULL, listPage.getMessage())
    }

}