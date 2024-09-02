package com.inspirecoding.mlchallenge.ui.components.bottomsheet.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.extensions.string.imageToSecureProtocol
import com.inspirecoding.mlchallenge.ui.components.bottomsheet.title.BottomSheetTitle
import com.inspirecoding.mlchallenge.ui.components.button.ButtonOutline
import com.inspirecoding.mlchallenge.ui.theme.color.BackgroundColor
import com.inspirecoding.mlchallenge.ui.theme.color.LightBlack

@Composable
fun DetailsScreen(product: ResultDomain, onClickDeny: () -> Unit)
{
    val context = LocalContext.current

    BottomSheetTitle(title = stringResource(id = R.string.tb_ml_challenge_details_screen)) {
        onClickDeny.invoke()
    }

    Scaffold(
        topBar = {},
        bottomBar = {
            ButtonOutline(
                border = BorderStroke(1.dp, Color.Black),
                textStyle = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                ),
                text = stringResource(id = R.string.bt_ml_challenge_details),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(product.permalink))
                    context.startActivity(intent)
                }
            )
        },
        containerColor = BackgroundColor,
        content = { values ->
            Column(
                modifier = Modifier
                    .padding(values)
                    .scrollable(rememberScrollState(), Orientation.Horizontal)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(product.thumbnail.imageToSecureProtocol())
                            .apply(block = fun ImageRequest.Builder.() {
                                error(R.drawable.no_image_available)
                                placeholder(R.drawable.no_image_available)
                            }).build()
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = product.title.orEmpty(),
                    modifier = Modifier.padding(top = 16.dp, bottom = 6.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = LightBlack,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                )

                Button(
                    modifier = Modifier
                        .padding(16.dp),
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3483FA))
                ) {
                    Text(text = product.condition.orEmpty() , color = Color.White)
                }

            }
        }
    )
}