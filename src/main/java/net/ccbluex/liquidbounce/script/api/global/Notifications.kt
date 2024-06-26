
package net.ccbluex.liquidbounce.script.api.global

import net.ccbluex.liquidbounce.CrossSine
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType

object Notifications {

    @Suppress("unused")
    @JvmStatic
    fun create(name: String?, content: String?, notify: String?, time: Int?) {
        var notifytype = NotifyType.WARNING
        when(notify?.lowercase()) {
            "success" -> notifytype = NotifyType.SUCCESS

            "info" -> notifytype = NotifyType.INFO

            "error" -> notifytype = NotifyType.ERROR

            "warning" -> notifytype = NotifyType.WARNING
        }
        CrossSine.hud.addNotification(Notification(name ?: "ScriptAPI", content ?: "Notification register failed", notifytype, time ?: 1000))
    }
}