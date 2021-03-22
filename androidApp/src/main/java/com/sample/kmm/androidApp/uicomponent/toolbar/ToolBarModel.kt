package com.sample.kmm.androidApp.uicomponent.toolbar

class ToolBarModel(
    val titleResId: Int? = null,
    val leftAction: ToolBarActionTextModel? = null,
    val rightAction: ToolBarActionTextModel? = null,
    val leftActionImage: ToolBarActionButtonModel? = null,
    val rightActionImage: ToolBarActionButtonModel? = null,
    val toolBarColorType: ToolBarColorType = ToolBarColorType.LIGHT

) {
    data class ToolBarActionTextModel(
        val actionResId: Int, val stringResId: Int,
        val callBack: (() -> Unit)? = null
    )

    data class ToolBarActionButtonModel(
        val actionResId: Int, val drawableResId: Int,
        val callBack: (() -> Unit)? = null
    )

    enum class ToolBarColorType constructor(var intValue: Int) {
        SOLID(intValue = 0),
        LIGHT(intValue = 1)
    }
}
