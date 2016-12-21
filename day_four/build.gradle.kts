buildscript {

    repositories {
        mavenCentral()
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("application")
}

apply {
    plugin("kotlin")
}

configure<ApplicationPluginConvention> {
    mainClassName = "SectorSum.kt"
}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib", "1.0.5"))

    subprojects.forEach {
        testCompile(it.buildDir)
    }
}