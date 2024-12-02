import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuaslab6.R
import com.example.tes.R
import com.example.projectuaslab6.Recipe
import com.example.projectuaslab6.RecipeAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipes = listOf(
            Recipe("Pasta Salad", "A delightful blend of cooked pasta tossed with fresh vegetables...", "20 min", "Level 0", R.drawable.pasta_salad),
            Recipe.Recipe(
                "Vegetable Kebab",
                "Grilled skewers of fresh vegetables...",
                "30 min",
                "Level 0",
                R.drawable.vegetable_kebab
            ),
            Recipe("Smoothie Bowl", "A frozen smoothie topped with fresh fruit...", "10 min", "Level 0", R.drawable.smoothie_bowl),
            Recipe("Stir-Fried Mixed Vegetables", "Fresh vegetables like carrots, green beans...", "15 min", "Level 0", R.drawable.stir_fried_mixed_vegetables)
        )

        val recyclerView: RecyclerView = findViewById(R.id.recipeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecipeAdapter(recipes)
    }
}
