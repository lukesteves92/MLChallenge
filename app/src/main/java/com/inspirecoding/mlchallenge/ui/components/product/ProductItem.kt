package com.inspirecoding.mlchallenge.ui.components.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.ui.shape.Shapes

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    imageRes: String?,
    title: String,
    price: String,
    onDetailsClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = Shapes.large)
            .padding(8.dp)
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(imageRes)
                    .apply(block = fun ImageRequest.Builder.() {
                        error(R.drawable.no_image_available)
                        placeholder(R.drawable.no_image_available)
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier
                .height(80.dp)
                .background(Color.LightGray, shape = Shapes.large),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = price,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF00A650)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onDetailsClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3483FA))
            ) {
                Text(text = stringResource(id = R.string.tb_ml_challenge_details_screen), color = Color.White)
            }
        }
    }
}