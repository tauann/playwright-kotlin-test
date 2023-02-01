import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage
import util.BaseTest
import util.Constants.DELETE_QUESTION
import util.Constants.DELETE_SUCCESSFULL
import util.Constants.SAVE_SUCCESS_MESSAGE

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
            .fillCustomerName("User 1 Test")
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

        Assertions.assertEquals(SAVE_SUCCESS_MESSAGE, addCustomerPage.getReportSuccessText())
    }

    @Test
    fun shouldAddAndDeleteCustomer() {
        val name = "User 2 Test"

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

        Assertions.assertEquals(DELETE_QUESTION, listPage.getDeleteAlertText())

        listPage.confirmDelete()

        Assertions.assertEquals(DELETE_SUCCESSFULL, listPage.getMessage())
    }

}