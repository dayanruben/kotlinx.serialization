// This file was automatically generated from serializers.md by Knit tool. Do not edit.
package example.exampleSerializer20

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.descriptors.*

object ColorAsStringSerializer : KSerializer<Color> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("my.app.Color", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Color) {
        val string = value.rgb.toString(16).padStart(6, '0')
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): Color {
        val string = decoder.decodeString()
        return Color(string.toInt(16))
    }
}

@OptIn(ExperimentalSerializationApi::class)
@KeepGeneratedSerializer
@Serializable(with = ColorAsStringSerializer::class)
class Color(val rgb: Int)


fun main() {
    val green = Color(0x00ff00)
    println(Json.encodeToString(green))
    println(Json.encodeToString(Color.generatedSerializer(), green))
}  
