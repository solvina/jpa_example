package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class Workbook(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@OneToMany(mappedBy = "workbook")
		val datasets: Collection<DataSet>? = null,

		@OneToMany(mappedBy = "workbook")
		val analyticsView: Collection<AnalyticsView>? = null
) {
	override fun toString(): String {
		return "Workbook(id=$id, datasets=${datasets?.map { it.id }}, analyticsView=${analyticsView?.map { it.id }})"
	}
}