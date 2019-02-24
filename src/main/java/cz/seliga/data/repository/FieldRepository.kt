package cz.seliga.data.repository

import cz.seliga.data.entity.Field
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Vlasta on 2/24/2019.
 */
@Repository
internal interface FieldRepository:JpaRepository<Field,Long>