import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.featherandroidtasks.ui.theme.FeatherAndroidTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatherAndroidTasksTheme {
                // Sample data for food items
                val foodItems = listOf(
                    "Pizza",
                    "Burger",
                    "Sushi",
                    "Salad",
                    "Pasta",
                    "Tacos",
                )

                // Search query state
                var searchQuery by remember { mutableStateOf(TextFieldValue()) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Search bar
                    BasicTextField(
                        value = searchQuery.text,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textStyle = LocalTextStyle.current.copy(color = Color.Black),
                        singleLine = true,
                        placeholder = { Text(text = "Search for food...") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Food item list
                    LazyColumn {
                        items(foodItems) { foodItem ->
                            FoodItemCard(foodItem = foodItem)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FoodItemCard(foodItem: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_food_placeholder),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(text = foodItem, style = MaterialTheme.typography.h6)
        }
    }
}
