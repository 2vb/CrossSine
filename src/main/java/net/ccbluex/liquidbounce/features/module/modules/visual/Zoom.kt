package net.ccbluex.liquidbounce.features.module.modules.visual

import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.Render2DEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.features.value.*
import net.ccbluex.liquidbounce.utils.render.EaseUtils
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import org.lwjgl.input.Keyboard

@ModuleInfo(name = "Zoom", category = ModuleCategory.VISUAL)
class Zoom : Module() {
    private val slowSen = BoolValue("Slow Sensitivity", false)
    private val smoothSpeed = FloatValue("Smooth Speed", 0.1F, 0.1F, 5F)
    private val keyValue = KeyValue("KeyBind:", Keyboard.KEY_C)
    private var oldFov = 0F
    override fun onEnable() {
        oldFov = mc.gameSettings.fovSetting
    }

    override fun onDisable() {
        mc.gameSettings.fovSetting = oldFov
    }

    @EventTarget
    fun onRender2D(event: Render2DEvent) {
        if (mc.currentScreen == null) {
            oldFov = mc.gameSettings.fovSetting
            mc.gameSettings.smoothCamera = (Keyboard.isKeyDown(keyValue.get()) && slowSen.get())
            if (mc.gameSettings.fovSetting <= 25F) {
                mc.gameSettings.fovSetting = 25F
            }
            if (mc.gameSettings.fovSetting >= oldFov) {
                mc.gameSettings.fovSetting = oldFov
            }
            if (Keyboard.isKeyDown(keyValue.get()) && mc.gameSettings.fovSetting > oldFov) {
                mc.gameSettings.fovSetting = oldFov
            }
            if (Keyboard.isKeyDown(keyValue.get()) && mc.gameSettings.fovSetting == 25F) return
            var zoom = 0F
            zoom += (0.0075F * smoothSpeed.get() * RenderUtils.deltaTime * if (Keyboard.isKeyDown(keyValue.get())) 1F else -1F)
            zoom = zoom.coerceIn(0F, 1F)

            if (Keyboard.isKeyDown(keyValue.get()) || mc.gameSettings.fovSetting != oldFov) {
                mc.gameSettings.fovSetting -= ((oldFov - 25) * EaseUtils.easeOutCirc(zoom.toDouble()).toFloat())
            }
        }
    }
}