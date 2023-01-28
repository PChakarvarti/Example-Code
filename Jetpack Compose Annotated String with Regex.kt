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
    val text = "This is some text with words that will be highlighted in different styles"

    val regexRedItalic = Regex("is|in")
    val regexGreenBold = Regex("some|with")

    val greenBoldStyle = SpanStyle(
        color = Color.Green,
        fontWeight = FontWeight.Bold
    )

    val redItalicStyle = SpanStyle(
        color = Color.Red,
        fontStyle = FontStyle.Italic
    )

    val regexMap = mapOf(
        regexRedItalic to redItalicStyle,
        regexGreenBold to greenBoldStyle
    )

    val annotatedString = annotatedString {
        append(text)
        regexMap.forEach { (regex, style) ->
            regex.findAll(text).forEach {
                val (start, end) = it.range
                val word = it.value
                span(start, end, style) {
                    append(word)
                }
            }
        }
    }

    Column {
        Text(annotatedString)
    }
}
