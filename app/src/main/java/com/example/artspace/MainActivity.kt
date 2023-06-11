package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp( modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }

//    result = 1

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when(result){
            1 -> ImageTile(Images = R.drawable.leonardo, titleResource = stringResource(R.string.monalisa ), NameResource = stringResource(R.string.leonardo_da_vinci) , yearResource = stringResource(R.string._1503_19) )
            2 -> ImageTile(Images = R.drawable.johannes , titleResource = stringResource(R.string.Girl_with_a_Perl_Earling) , NameResource = stringResource(R.string.Johannes_Vermeer) , yearResource = stringResource(R.string._1665) )
            3 -> ImageTile(Images = R.drawable.vincent , titleResource = stringResource(R.string.Vincent_Van_Gogh) , NameResource = stringResource(R.string.The_Starry_Night) , yearResource = stringResource(R.string._1889) )
            4 -> ImageTile(Images = R.drawable.gustav , titleResource = stringResource(R.string.Gustave_Klimt) , NameResource = stringResource(R.string.The_Kiss) , yearResource = stringResource(R.string._1907_08))
            5 -> ImageTile(Images = R.drawable.sandro , titleResource = stringResource(R.string.Sandro_Bortticelli) , NameResource = stringResource(R.string.The_Birth_of_venus) , yearResource = stringResource(R.string._1484_86) )
            6 -> ImageTile(Images = R.drawable.jan , titleResource = stringResource(R.string.Jan_Van_Eyck) , NameResource = stringResource(R.string.The_Arnolfini_Portrait) , yearResource = stringResource(R.string._1434) )
            7 -> ImageTile(Images = R.drawable.hieronymus , titleResource = stringResource(R.string.Hieronymus_Bosch) , NameResource = stringResource(R.string.The_Garden_of_Earthly_Delights) , yearResource = stringResource(R.string._1503) )
            8 -> ImageTile(Images = R.drawable.edouard , titleResource = stringResource(R.string.Edouaard_Manet) , NameResource = stringResource(R.string.Le_Deejeuner_sur_Iherbe) , yearResource = stringResource(R.string._1863) )
            9 -> ImageTile(Images = R.drawable.piet , titleResource = stringResource(R.string.Piet_Mondrian) , NameResource = stringResource(R.string.Composition_with_Red_Blue_And_Yellow) , yearResource = stringResource(R.string._1930) )
            10 -> ImageTile(Images = R.drawable.claude, titleResource = stringResource(R.string.Claude_Monet) , NameResource = stringResource(R.string.Impressions_Sunrise) , yearResource = stringResource(R.string._1874) )
            11 -> ImageTile(Images = R.drawable.caspar , titleResource = stringResource(R.string.Caspar_David_Friedrich) , NameResource = stringResource(R.string.Wanderer_above_the_Sea_of_Fog) , yearResource = stringResource(R.string._1819) )
            else -> ImageTile(Images = R.drawable.marcel , titleResource = stringResource(R.string.Marcel_Duchamp) , NameResource = stringResource(R.string.Nude_Descending_a_StairCase_No2) , yearResource = stringResource(R.string._1912) )

        }

        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Button(
                onClick = { result - 1 },
                modifier = modifier.weight(0.5f)
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = modifier.padding(20.dp))

            Button(
                onClick = {
                    result + 1
                },
                modifier = modifier.weight(0.5f)
            ) {
                Text(text = "Next")
            }

        }
    }
}


@Composable
fun ImageTile(Images:Int,  titleResource: String, NameResource: String, yearResource: String ,modifier: Modifier = Modifier){

        Image(
            painter = painterResource(id = Images) ,
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
//                .border(border = BorderStroke(2.dp, Color.Gray),
//                        shape = RectangleShape
//                    ).padding(20.dp)
        )

        Spacer(modifier = modifier.padding(bottom = 50.dp))

        Card(
            modifier = modifier,
        ){
            Column(
                modifier = modifier
                    .padding(16.dp)
            ) {

                Text(
                    text = titleResource,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Light
                )

                Row( modifier = modifier) {
                    Text(
                        text = NameResource,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "($yearResource)")
                }
            }
        }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}