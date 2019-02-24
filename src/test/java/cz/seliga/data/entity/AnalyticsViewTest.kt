package cz.seliga.data.entity

import cz.seliga.data.entity.AnalyticsView
import cz.seliga.data.entity.Workbook
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test


/**
 * Created by Vlasta on 2/23/2019.
 */
class AnalyticsViewTest {
	@Test
	fun testChart() {
		var view = AnalyticsView(id = 1, workbook = Workbook(0))

		assertNotNull(view)
		assertEquals(view.id, 1)
	}
}