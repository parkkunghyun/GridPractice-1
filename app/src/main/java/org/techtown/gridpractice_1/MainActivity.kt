package org.techtown.gridpractice_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.gridpractice_1.model.Topic
import org.techtown.gridpractice_1.ui.theme.GridPractice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridPractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicList(modifier = Modifier.padding(
                       start = dimensionResource(id = R.dimen.padding_small),
                        top =  dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small)
                    )
                    )
                }
            }
        }
    }
}

@Composable
fun TopicList(topicList: List<Topic> = DataSource.topics, modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topicList) {
            topic -> TopicCard(topic = topic)
        }
    }
    /*
    LazyColumn(modifier = modifier) {
        items(topicList) {
            it -> Topic(it, modifier = Modifier.padding(8.dp))
        }
    }
     */
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row() {
            Image(contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(68.dp)
                    .aspectRatio(1f),
                painter = painterResource(id = topic.imageResourceId), contentDescription = "image")
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = LocalContext.current.getString(topic.titleResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_small)
                    ))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null,
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)))
                    Text(text = topic.amount.toString()
                    , style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start =  dimensionResource(id = R.dimen.padding_small)))
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TopicPreview() {
   Surface {
       TopicList(modifier = Modifier.padding(
           start = dimensionResource(id = R.dimen.padding_small),
           top =  dimensionResource(id = R.dimen.padding_small),
           end = dimensionResource(id = R.dimen.padding_small)
       )
       )
   }
}