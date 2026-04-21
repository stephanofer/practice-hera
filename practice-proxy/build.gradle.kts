val velocityApiVersion: String by project

plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.3.0"
    id("xyz.jpenilla.run-velocity") version "3.0.2"
}

dependencies {
    implementation(project(":practice-api"))
    implementation(project(":practice-core"))

    compileOnly("com.velocitypowered:velocity-api:$velocityApiVersion")
    annotationProcessor("com.velocitypowered:velocity-api:$velocityApiVersion")
}

tasks {
    runVelocity {
        velocityVersion(velocityApiVersion)
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveClassifier.set("")
        destinationDirectory.set(rootProject.layout.projectDirectory.dir("target"))
    }

    build {
        dependsOn(shadowJar)
    }
}
