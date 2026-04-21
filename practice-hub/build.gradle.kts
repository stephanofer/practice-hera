val paperApiVersion: String by project
val mockBukkitPaperVersion: String by project
val placeholderApiVersion: String by project
val zmenuApiVersion: String by project
val scoreboardLibraryVersion: String by project
val voicechatApiVersion: String by project
val mockBukkitVersion: String by project

plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.3.0"
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

dependencies {
    implementation(project(":practice-api"))
    implementation(project(":practice-core"))
    implementation(project(":practice-data"))

    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
    compileOnly("me.clip:placeholderapi:$placeholderApiVersion")
    compileOnly("fr.maxlego08.menu:zmenu-api:$zmenuApiVersion")
    compileOnly("de.maxhenkel.voicechat:voicechat-api:$voicechatApiVersion")

    implementation("net.megavex:scoreboard-library-api:$scoreboardLibraryVersion")
    runtimeOnly("net.megavex:scoreboard-library-implementation:$scoreboardLibraryVersion")

    testImplementation("io.papermc.paper:paper-api:$mockBukkitPaperVersion")
    testImplementation("org.mockbukkit.mockbukkit:mockbukkit-v1.21:$mockBukkitVersion")
}

tasks {
    runServer {
        minecraftVersion("26.1.2")
        jvmArgs("-Xms2G", "-Xmx2G")
    }

    processResources {
        val props = mapOf("version" to version)
        filesMatching("plugin.yml") {
            expand(props)
        }
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
