package cz.seliga.config

import cz.seliga.data.entity.*
import org.hibernate.cfg.Configuration
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase
import java.io.IOException
import java.util.*

/**
 * Created by Vlasta on 2/23/2019.
 */
abstract class BaseConfiguredTest : BaseCoreFunctionalTestCase() {
	private val properties: Properties
		@Throws(IOException::class)
		get() {
			val properties = Properties()
			properties.load(javaClass.classLoader.getResourceAsStream("hibernate.properties"))
			return properties
		}
//	override fun getAnnotatedPackages(): Array<String> = arrayOf("cz.seliga.data.repository.entity")

	override fun getAnnotatedClasses() = arrayOf(Workbook::class.java,
			AnalyticsView::class.java,
			DataSet::class.java,
			DataColumn::class.java,
			Field::class.java,
			JoinTrail::class.java)


	override fun configure(configuration: Configuration) {
		super.configure(configuration)
		configuration.properties = properties
	}

}