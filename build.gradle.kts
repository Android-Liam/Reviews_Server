import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.JavaVersion

plugins {
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_20
}

repositories {
	mavenCentral()
	// Spring Boot의 Milestone Repository 추가
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	// Spring Boot 기본 의존성
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// 데이터베이스 관련 의존성
	implementation("org.hibernate:hibernate-core:5.6.2.Final")
	implementation("jakarta.persistence:jakarta.persistence-api:2.2.3")
	implementation("com.h2database:h2")

	// Kotlin 및 코루틴 관련 의존성
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

	// JSON 직렬화 관련 의존성
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Spring Boot GraphQL 관련 의존성
	// implementation("org.springframework.boot:spring-boot-starter-graphql")

	// 테스트 의존성
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-webflux")
	testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


