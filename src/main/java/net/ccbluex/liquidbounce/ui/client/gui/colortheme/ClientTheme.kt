package net.ccbluex.liquidbounce.ui.client.gui.colortheme

import net.ccbluex.liquidbounce.features.module.modules.visual.CustomClientColor
import net.ccbluex.liquidbounce.features.value.BoolValue
import net.ccbluex.liquidbounce.features.value.IntegerValue
import net.ccbluex.liquidbounce.features.value.ListValue
import net.ccbluex.liquidbounce.utils.extensions.setAlpha
import net.ccbluex.liquidbounce.utils.render.ColorUtils
import java.awt.Color

object ClientTheme {
    val ClientColorMode = ListValue(
        "ColorMode",
        arrayOf("Cherry", "Water", "Magic", "DarkNight", "Sun", "Tree", "Flower", "Loyoi", "Soniga", "May", "Mint", "Cero", "Azure"),
        "Cherry"
    ).displayable { false }
    val textValue = BoolValue("TextStaticColor", false).displayable { false }
    val fadespeed = IntegerValue("Fade-speed", 1, 1, 10).displayable { false }
    val updown = BoolValue(
        "Fade-Type",
        false
    ).displayable { false }
    fun setColor(type: String, alpha: Int): Color {
        if (CustomClientColor.state) return CustomClientColor.getColor(alpha)
        when (ClientColorMode.get().lowercase()) {

            "cherry" -> if (type == "START") {
                return Color(215, 171, 168, alpha)
            } else if (type == "END") {
                return Color(206, 58, 98, alpha)
            }

            "water" -> if (type == "START") {
                return Color(108, 170, 207, alpha)
            } else if (type == "END") {
                return Color(35, 69, 148, alpha)
            }

            "magic" -> if (type == "START") {
                return Color(255, 180, 255, alpha)
            } else if (type == "END") {
                return Color(192, 67, 255, alpha)
            }

            "darknight" -> if (type == "START") {
                return Color(203, 200, 204, alpha)
            } else if (type == "END") {
                return Color(93, 95, 95, alpha)
            }

            "sun" -> if (type == "START") {
                return Color(252, 205, 44, alpha)
            } else if (type == "END") {
                return Color(255, 143, 0, alpha)
            }

            "flower" -> if (type == "START") {
                return Color(182, 140, 195, alpha)
            } else if (type == "END") {
                return Color(184, 85, 199, alpha)
            }

            "tree" -> if (type == "START") {
                return Color(76, 255, 102, alpha)
            } else if (type == "END") {
                return Color(18, 155, 38, alpha)
            }

            "loyoi" -> if (type == "START") {
                return Color(255, 131, 124, alpha)
            } else if (type == "END") {
                return Color(255, 131, 0, alpha)
            }

            "soniga" -> if (type == "START") {
                return Color(100, 255, 255, alpha)
            } else if (type == "END") {
                return Color(255, 100, 255, alpha)
            }
            "may" -> if (type == "START") {
                return Color(255, 255, 255, alpha)
            } else if (type == "END") {
                return Color(255, 80, 255, alpha)
            }
            "mint" -> if (type == "START") {
                return Color(85, 255, 255, alpha)
            } else if (type == "END") {
                return Color(85, 255, 140, alpha)
            }
            "cero" -> if (type == "START") {
                return Color(170, 255, 170, alpha)
            } else if (type == "END") {
                return Color(170, 0, 170, alpha)
            }
            "azure" -> if (type == "START") {
                return Color(0, 180, 255, alpha)
            } else if (type == "END") {
                return Color(0, 90, 255, alpha)
            }

        }

        return Color(-1)
    }

    fun getColor(index: Int): Color {
        if (CustomClientColor.state) return CustomClientColor.getColor()
        when (ClientColorMode.get().lowercase()) {
            "cherry" -> return ColorUtils.mixColors(
                Color(206, 58, 98),
                Color(215, 171, 168),
                fadespeed.get() / 5.0 * if (updown.get()) 1 else -1,
                index
            )

            "water" -> return ColorUtils.mixColors(
                Color(35, 69, 148),
                Color(108, 170, 207),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "magic" -> return ColorUtils.mixColors(
                Color(255, 180, 255),
                Color(181, 139, 194),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "tree" -> return ColorUtils.mixColors(
                Color(18, 155, 38),
                Color(76, 255, 102),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "darknight" -> return ColorUtils.mixColors(
                Color(93, 95, 95),
                Color(203, 200, 204),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "sun" -> return ColorUtils.mixColors(
                Color(255, 143, 0),
                Color(252, 205, 44),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "flower" -> return ColorUtils.mixColors(
                Color(184, 85, 199),
                Color(182, 140, 195),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "loyoi" -> return ColorUtils.mixColors(
                Color(255, 131, 0),
                Color(255, 131, 124),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "soniga" -> return ColorUtils.mixColors(
                Color(255, 100, 255),
                Color(100, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "may" -> return ColorUtils.mixColors(
                Color(255, 80, 255),
                Color(255, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "mint" -> return ColorUtils.mixColors(
                Color(85, 255, 140),
                Color(85, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "cero" -> return ColorUtils.mixColors(
                Color(170, 0, 170),
                Color(170, 255, 170),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "azure" -> return ColorUtils.mixColors(
                Color(0, 90, 255),
                Color(0, 180, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

        }
        return Color(-1)
    }
    fun getColorFromName(name: String,index: Int): Color {
        if (CustomClientColor.state) return CustomClientColor.getColor()
        when (name.lowercase()) {
            "cherry" -> return ColorUtils.mixColors(
                Color(206, 58, 98),
                Color(215, 171, 168),
                fadespeed.get() / 5.0 * if (updown.get()) 1 else -1,
                index
            )

            "water" -> return ColorUtils.mixColors(
                Color(35, 69, 148),
                Color(108, 170, 207),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "magic" -> return ColorUtils.mixColors(
                Color(255, 180, 255),
                Color(181, 139, 194),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "tree" -> return ColorUtils.mixColors(
                Color(18, 155, 38),
                Color(76, 255, 102),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "darknight" -> return ColorUtils.mixColors(
                Color(93, 95, 95),
                Color(203, 200, 204),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "sun" -> return ColorUtils.mixColors(
                Color(255, 143, 0),
                Color(252, 205, 44),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "flower" -> return ColorUtils.mixColors(
                Color(184, 85, 199),
                Color(182, 140, 195),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )

            "loyoi" -> return ColorUtils.mixColors(
                Color(255, 131, 0),
                Color(255, 131, 124),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "soniga" -> return ColorUtils.mixColors(
                Color(255, 100, 255),
                Color(100, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "may" -> return ColorUtils.mixColors(
                Color(255, 80, 255),
                Color(255, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "mint" -> return ColorUtils.mixColors(
                Color(85, 255, 140),
                Color(85, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "cero" -> return ColorUtils.mixColors(
                Color(170, 0, 170),
                Color(170, 255, 170),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
            "azure" -> return ColorUtils.mixColors(
                Color(0, 90, 255),
                Color(0, 180, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            )
        }
        return Color(-1)
    }
    fun getColorWithAlpha(index: Int, alpha: Int): Color {
        if (CustomClientColor.state) return CustomClientColor.getColor(alpha)
        when (ClientColorMode.get().lowercase()) {
            "cherry" -> return ColorUtils.mixColors(
                Color(206, 58, 98),
                Color(215, 171, 168),
                fadespeed.get() / 5.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "water" -> return ColorUtils.mixColors(
                Color(35, 69, 148),
                Color(108, 170, 207),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "magic" -> return ColorUtils.mixColors(
                Color(255, 180, 255),
                Color(181, 139, 194),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "tree" -> return ColorUtils.mixColors(
                Color(18, 155, 38),
                Color(76, 255, 102),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "darknight" -> return ColorUtils.mixColors(
                Color(93, 95, 95),
                Color(203, 200, 204),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "sun" -> return ColorUtils.mixColors(
                Color(255, 143, 0),
                Color(252, 205, 44),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "flower" -> return ColorUtils.mixColors(
                Color(184, 85, 199),
                Color(182, 140, 195),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)

            "loyoi" -> return ColorUtils.mixColors(
                Color(255, 131, 0),
                Color(255, 131, 124),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
            "soniga" -> return ColorUtils.mixColors(
                Color(255, 100, 255),
                Color(100, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
            "may" -> return ColorUtils.mixColors(
                Color(255, 80, 255),
                Color(255, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
            "mint" -> return ColorUtils.mixColors(
                Color(85, 255, 180),
                Color(85, 255, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
            "cero" -> return ColorUtils.mixColors(
                Color(170, 0, 170),
                Color(170, 255, 170),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
            "azure" -> return ColorUtils.mixColors(
                Color(0, 90, 255),
                Color(0, 180, 255),
                fadespeed.get() / 7.0 * if (updown.get()) 1 else -1,
                index
            ).setAlpha(alpha)
        }
        return Color(-1)
    }
}