package ru.smak.calculationtester363.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.smak.calculationtester363.R
import ru.smak.calculationtester363.models.CardModel
import ru.smak.calculationtester363.ui.theme.CalculationTester363Theme

@Composable
fun TestCard(
    card: CardModel,
    userValue: String,
    modifier: Modifier = Modifier,
    background: Color = Color.Unspecified,
    onUserInput: (String)->Unit = {},
    onCheckResult: ()->Unit = {},
){
    val task = "${card.op1} ${card.operation.symbol} ${card.op2} = "

    OutlinedCard(
        colors = CardDefaults.outlinedCardColors(
            containerColor = background
        )
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    task,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    softWrap = false
                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = userValue,
                    onValueChange = onUserInput,
                    modifier = Modifier.widthIn(max = 80.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    singleLine = true,
                )
            }

            OutlinedIconButton(
                onClick = onCheckResult,
                modifier = Modifier.requiredSize(64.dp),
                enabled = false,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.twotone_check_circle_48),
                    stringResource(R.string.answer_button),
                )
            }
        }
    }
}

@Preview
@Composable
fun TestCardPreview(){
    CalculationTester363Theme {
        TestCard(
            CardModel(),
            "",
            Modifier.fillMaxWidth().padding(8.dp)
        )
    }
}