package cz.seliga.data.service

import cz.seliga.data.entity.DataSet
import cz.seliga.data.entity.Field
import cz.seliga.data.entity.JoinTrail
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by Vlasta on 2/24/2019.
 */
@ComponentScan("cz.seliga")
@RunWith(SpringJUnit4ClassRunner::class)
@DataJpaTest
class FieldServiceTest{
	@Autowired
	lateinit var fieldService: FieldService

	@Test
	fun testExistsById(){
		assertFalse(fieldService.existsById(1000L))
	}

	@Test
	fun testCascadeSaveFromField(){
		var field = Field(0, JoinTrail(0, DataSet(0)),"%placeholder%","employee.name")

		assertEquals(field.id,0L)
		assertEquals(field.joinTrail.id,0L)
		assertEquals(field.joinTrail.dataSet.id,0L)
		var savedField = fieldService.createOrUpdate(field)

		assertEquals(savedField.id,1)
		assertEquals(savedField.joinTrail.id,1L)
		assertEquals(savedField.joinTrail.dataSet.id,1L)


	}
}