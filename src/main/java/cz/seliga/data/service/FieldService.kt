package cz.seliga.data.service

import cz.seliga.data.entity.Field

/**
 * Created by Vlasta on 2/24/2019.
 */
interface FieldService {
	fun createOrUpdate(field: Field): Field
	fun deleteById(id: Long)
	fun findById(id: Long): Field?
	fun existsById(id: Long): Boolean
}