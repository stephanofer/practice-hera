val hikariVersion: String by project
val mysqlConnectorVersion: String by project
val lettuceVersion: String by project

plugins {
    `java-library`
}

dependencies {
    api(project(":practice-api"))
    api(project(":practice-core"))

    implementation("com.zaxxer:HikariCP:$hikariVersion")
    implementation("com.mysql:mysql-connector-j:$mysqlConnectorVersion")
    implementation("io.lettuce:lettuce-core:$lettuceVersion")
}
