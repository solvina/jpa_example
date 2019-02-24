package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class DataSet(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@ManyToOne(fetch = FetchType.EAGER)
		val workbook: Workbook? = null,

		@OneToMany(mappedBy = "dataSet")
		val joinTrails: Collection<JoinTrail>? = null,

		@OneToMany(mappedBy = "dataSet")
		val dataColumns: Collection<DataColumn>? = null

) {
	override fun toString(): String {
		return "DataSet(id=$id, " +
				"workbook=$workbook, " +
				"joinTrails=${joinTrails?.map { it.id }}, " +
				"dataColumns=${dataColumns?.map { it.id }})"
	}
}