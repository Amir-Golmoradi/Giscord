plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "1.9.10"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    application
    java
}

java {
    withSourcesJar() // Ensures a source JAR is generated
}

group = "amirgol"
version = "0.0.1"
val koinVersion = "3.5.0"
val mockVersion = "1.13.7"
val jUnitVersion = "5.10.0"
val okHttpVersion = "4.12.0"
val jacksonVersion = "2.15.0"
val postgresVersion = "42.7.4"
val coroutinesVersion = "1.7.3"
val javaPersistenceVersion = "2.2"
val koinAnnotationVersion = "1.1.0"
val kotlinSerializeVersion = "1.6.0"
val koinKspCompilerVersion = "1.2.0"
val jakartaAnnotationVersion = "2.1.1"
val coreHibernateVersion = "6.2.13.Final"
val kspProcessorApiVersion = "1.5.30-1.0.0"
val hibernateValidatorVersion = "8.0.2.Final"
repositories {
    mavenCentral()
}

dependencies {
    // Kotlin Standard Library
    implementation(kotlin("stdlib"))

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")

    // Dependency Injection - Koin
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-core-jvm:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
    ksp("io.insert-koin:koin-ksp-compiler:$koinKspCompilerVersion")
    implementation("io.insert-koin:koin-annotations:$koinAnnotationVersion")


    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializeVersion")

    // KSP API dependency
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspProcessorApiVersion")

    // HTTP Client - OkHttp
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    // JSON Parsing - Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    // Hibernate ORM
    implementation("org.hibernate:hibernate-core:$coreHibernateVersion")
    implementation("javax.persistence:javax.persistence-api:$javaPersistenceVersion")
    implementation("org.hibernate.validator:hibernate-validator:$hibernateValidatorVersion")
    implementation("jakarta.annotation:jakarta.annotation-api:$jakartaAnnotationVersion")

    // PostgreSQL
    implementation("org.postgresql:postgresql:$postgresVersion")

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
    testImplementation("io.mockk:mockk:$mockVersion")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("amirgol.MainKt") // Adjust to your actual main class path
}

sourceSets {
    val main by getting {
        java.srcDir("src/main/java")
        kotlin.srcDir("src/main/kotlin")
        kotlin.srcDir("build/generated/ksp/main/kotlin")

    }
    val test by getting {
        java.srcDir("src/test/java")
        kotlin.srcDir("src/test/kotlin")
    }
}

tasks.test {
    useJUnitPlatform()
}
