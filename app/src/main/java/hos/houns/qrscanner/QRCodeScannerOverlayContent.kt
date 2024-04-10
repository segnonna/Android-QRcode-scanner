package hos.houns.qrscanner

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun QRCodeScannerOverlayContent(borderColor: Color) {
    val radius = 16.dp
    val paddingHorizontal = 44F
    val configuration = LocalConfiguration.current
    val screenWidthPx = configuration.screenWidthDp.dp
    val squareSize = screenWidthPx - (paddingHorizontal.dp * 2)

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = .6f))
                .padding(
                    horizontal = paddingHorizontal.dp,
                    vertical = 70.dp
                ),
            contentAlignment = Alignment.TopStart,
        ) {
            Canvas(
                modifier = Modifier
                    .size(squareSize, squareSize)
                    .border(4.dp, borderColor, RoundedCornerShape(radius))

            ) {
                // Source
                drawRoundRect(
                    size = Size(squareSize.toPx(), squareSize.toPx()),
                    cornerRadius = CornerRadius(radius.toPx(), radius.toPx()),
                    color = Color.Transparent,
                    blendMode = BlendMode.Clear
                )
            }
        }
    }
}