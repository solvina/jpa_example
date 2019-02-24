package cz.seliga.data.entity

import cz.seliga.config.BaseConfiguredTest
import junit.framework.TestCase.*
import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import org.junit.Test

/**
 * Created by Vlasta on 2/23/2019.
 */
class WorkbookTest : BaseConfiguredTest(){
	@Test
	fun testWorkbook() {
		var workbook = Workbook(1, listOf(DataSet(1, Workbook(0)), DataSet(2,Workbook(0))))

		assertNotNull(workbook)
		assertEquals(workbook.id, 1)
		assertEquals(workbook.datasets?.size, 2)
	}

	@Test
	fun givenWorkbook_whenSaved_thenFound() {
		doInHibernate(({ sessionFactory() }), { session ->
			val workbookToSave = Workbook()
			session.persist(workbookToSave)
			val personFound = session.find(Workbook::class.java, 1L)
			session.refresh(personFound)

			assertTrue(workbookToSave == personFound)
		})
	}
}