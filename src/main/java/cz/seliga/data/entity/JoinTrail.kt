package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class JoinTrail(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@ManyToOne(fetch = FetchType.EAGER,cascade = [CascadeType.ALL])
		val dataSet: DataSet,

		@OneToMany(mappedBy = "joinTrail")
		val fields: Collection<Field> = listOf()

) {
	override fun toString(): String {
		return "JoinTrail(id=$id, " +
				"dataSet=${dataSet}, " +
				"fields=${fields?.map { it.id }})"
	}
}