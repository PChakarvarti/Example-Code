import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun HighlightedText() {
    val text = "This is some text with words that will be highlighted in green and bold"

    val style = SpanStyle(
        color = Color.Green,
        fontWeight = FontWeight.Bold
    )

    val wordsToHighlight = listOf("highlighted", "green", "bold")

    val regex = Regex(wordsToHighlight.joinToString("|"))

    val annotatedString = annotatedString {
        append(text)
        regex.findAll(text).forEach {
            val (start, end) = it.range
            val word = it.value
            span(start, end, style) {
                append(word)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(annotatedString)
    }
}
