/*
 * FDPClient Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge by LiquidBounce.
 * https://github.com/SkidderMC/FDPClient/
 */
package net.ccbluex.liquidbounce.features.module.modules.other;

import net.ccbluex.liquidbounce.LiquidBounce;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType;

@ModuleInfo(name = "PacketFix", category = ModuleCategory.OTHER)
public class PacketFix extends Module {


    @Override
    public void onEnable(){
        LiquidBounce.hud.addNotification(new Notification("WARNING","If you using this module in a low version server < 1.12.Server AntiCheat will detect this as a hack when you right click!", NotifyType.WARNING,4000,500));
    }
}