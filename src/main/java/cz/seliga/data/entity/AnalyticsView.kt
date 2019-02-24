package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class AnalyticsView(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@ManyToOne(fetch = FetchType.EAGER)
		val workbook: Workbook? = null,

		@OneToMany(mappedBy = "analyticsView")
		val dataColumns: Collection<DataColumn>? = null
) {
	override fun toString(): String {
		return "AnalyticsView(id=$id, workbook=$workbook, dataColumns=${dataColumns?.map { it.id }})"
	}
}