package gov.sa.scisp.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Base64
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import gov.sa.scisp.R


/**
 * Created by "Mohamad Abuzaid" on 31/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Stable
fun Modifier.mirror(): Modifier = composed {
    if (LocalLayoutDirection.current == LayoutDirection.Rtl)
        this.scale(scaleX = -1f, scaleY = 1f)
    else
        this
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

fun convertBase64ImgToBitmap(base64ImgString: String): Bitmap {

    val base64String = base64ImgString.replace("data:image/png;base64,", "")

    val decodedString: ByteArray = Base64.decode(base64String, Base64.DEFAULT)

    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}

fun <T : Parcelable> Bundle.extractParcelable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, clazz)
    } else {
        getParcelable(key)
    }
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

fun <T : Any, R : Any> Collection<T?>.allNotNull(block: (List<T>) -> R) {
    if (this.all { it != null }) {
        block(this.filterNotNull())
    }
}

fun <T> List<T>.safeSubList(fromIndex: Int, toIndex: Int = this.size): List<T> =
    this.subList(fromIndex.coerceAtLeast(0), toIndex.coerceAtMost(this.size))

fun <T> List<T>.secondOrNull(): T? {
    return if (size < 2) null else this[1]
}