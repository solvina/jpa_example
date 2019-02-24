package cz.seliga.data.entity

import javax.persistence.*

/**
 * Created by Vlasta on 2/23/2019.
 */
@Entity
data class Field(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
		@JoinColumn(name = "joinTrail")
		val joinTrail: JoinTrail,

		@Column
		val placeholder: String = "",

		@Column
		val value: String = ""


) {
	override fun toString(): String {
		return "Field(id=$id, " +
				"joinTrail=${joinTrail}, " +
				"placeholder='$placeholder', " +
				"value='$value')"
	}
}