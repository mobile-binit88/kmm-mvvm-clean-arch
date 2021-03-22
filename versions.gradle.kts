mapOf(
    "androidMaterialVersion" to "1.2.1",
    "appcompatVersion" to "1.2.0",
    "constraintlayoutVersion" to "2.0.2",
    "navigationVersion" to "2.2.2",
    "viewpagerVersion" to "1.0.0",
    "intuitVersion" to "1.0.6",
    "kodeinVersion" to "7.1.0",
    "coroutineVersion" to "1.3.9-native-mt-2",
    "serializerVersion" to "1.0.0-RC",
    "mockkVersion" to "1.9.3",
    "mokoMvvmVersion" to "0.8.0",
    "ktorVersion" to "1.4.0",
    "coilVersion" to "1.1.1"
).forEach { (name, version) ->
    project.extra.set(name, version)
}
