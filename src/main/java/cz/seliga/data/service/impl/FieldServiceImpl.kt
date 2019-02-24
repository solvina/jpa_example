package cz.seliga.data.service.impl

import cz.seliga.data.entity.Field
import cz.seliga.data.repository.FieldRepository
import cz.seliga.data.service.FieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Vlasta on 2/24/2019.
 */
@Service("fieldService")
class FieldServiceImpl : FieldService {
	@Autowired
	private lateinit var fieldRepository: FieldRepository

	override fun createOrUpdate(field: Field): Field = fieldRepository.save(field)

	override fun deleteById(id: Long) = fieldRepository.deleteById(id)

	override fun findById(id: Long): Field = fieldRepository.findById(id).orElse(null)

	override fun existsById(id: Long): Boolean = fieldRepository.existsById(id)
}