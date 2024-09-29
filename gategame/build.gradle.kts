plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "com.example.gategame"
version = "1.0"

repositories {
    mavenCentral()
}


dependencies {
//    implementation("org.jline:jline:3.26.3")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // used to parse engine configuration files
    implementation("com.google.code.gson:gson:2.11.0")
}

tasks.test {
    useJUnitPlatform()
    forkEvery = 1
}

tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "com.example.gategame.Main"))
    }
}