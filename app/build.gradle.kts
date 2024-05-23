plugins {
    id("java")
    application
}

application {
    mainClass = "hexlet.code.App"
    tasks.withType<Jar> {
        manifest {
            attributes["Main-Class"] = mainClass
        }
    }
}

group = "hexlet.code"
version = "1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}