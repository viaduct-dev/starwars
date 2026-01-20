val viaductVersion: String by settings

// When part of composite build, use local gradle-plugins
// When standalone, use Maven Central (only after version is published)
pluginManagement {
    if (gradle.parent != null) {
        includeBuild("../../gradle-plugins")
    } else {
        repositories {
            mavenCentral()
            gradlePluginPortal()
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    versionCatalogs {
        create("libs") {
            from(files("gradle/viaduct.versions.toml"))
            version("viaduct", viaductVersion)
        }
    }
}

include(":modules:filmography")
include(":common")
include(":modules:universe")
