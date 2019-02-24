package cz.seliga.data.entity

import cz.seliga.config.BaseConfiguredTest
import junit.framework.TestCase.assertTrue
import org.hibernate.testing.transaction.TransactionUtil
import org.junit.Test


/**
 * Created by Vlasta on 2/23/2019.
 */
class FieldTest : BaseConfiguredTest() {
	@Test
	fun givenField_whenSaved_thenFound() {
		TransactionUtil.doInHibernate(({ sessionFactory() }), { session ->
			var dataset = DataSet(0)
			session.persist(dataset)
			session.refresh(dataset)
			var joinTrail = JoinTrail(0, dataset)
			session.persist(joinTrail)
			session.refresh(joinTrail)


			var fieldToSave = Field(0, joinTrail)
			var fieldWithId = Field(1, joinTrail)
			session.persist(fieldToSave)
			assertTrue(fieldToSave == fieldWithId)
			val fieldFound = session.find(Field::class.java, 1L)
			session.refresh(fieldFound)

			assertTrue(fieldToSave == fieldWithId)
			assertTrue(fieldToSave == fieldFound)
		})
	}

}