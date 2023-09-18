package com.example.server

import org.springframework.data.jpa.repository.JpaRepository


/*
MySQL과 연결하기 위한 코드
UserRepository.kt: 엔티티에 대한 데이터베이스 조작을 위한 리포지토리 인터페이스
 */


interface UserRepository : JpaRepository<UserEntity, Long> {
    // 추가적인 쿼리 메서드를 여기에 정의할 수 있음
}
