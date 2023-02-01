package util

import java.io.FileInputStream
import java.time.Duration
import java.util.*

object PropertiesLoader {

    private val properties = Properties()

    init {
        properties.load(FileInputStream("src/main/resources/local.properties"))
    }

    fun applicationUrl(): String = properties.getProperty("application.url")

    fun driverTimeout(): Duration = Duration.ofSeconds(properties.getProperty("driver.timeout").toLong())

    fun driverBrowser(): String = properties.getProperty("driver.browser").uppercase()

    fun driverEnableHeadless(): Boolean = properties.getProperty("driver.enable.headless").toBoolean()

}

