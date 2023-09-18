package com.example.server

import jakarta.persistence.Entity
import jakarta.persistence.Id
import javax.persistence.*

/*
MySQL과 연결하기 위한 코드
UserEntity.kt: "user_info" 테이블과 매핑되는 엔티티 클래스
 */

@Entity
@Table(name = "user_info")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userIndex: Long?,

    @Column(name = "name", length = 15)
    val name: String? = null,

    @Column(name = "id", length = 30)
    var id: String? = null,

    @Column(name = "pwd", length = 30)
    val pwd: String? = null,

    @Column(name = "spiciness_level")
    val spicinessLevel: Int? = null,

    @Column(name = "portion_size")
    val portionSize: Int? = null,

    @Column(name = "taste_sensitivity")
    val tasteSensitivity: Int? = null
) {
    constructor() : this(null, null, null, null, null, null, null)
}

