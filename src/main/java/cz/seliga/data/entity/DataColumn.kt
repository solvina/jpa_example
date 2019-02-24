package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class DataColumn(
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@ManyToOne(fetch = FetchType.EAGER)
		val analyticsView: AnalyticsView,

		@ManyToOne(fetch = FetchType.EAGER)
		val dataSet: DataSet
)