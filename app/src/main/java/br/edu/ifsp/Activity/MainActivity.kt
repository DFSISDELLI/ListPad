package br.edu.ifsp.Activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.Data.ProdutoAdapter
import br.edu.ifsp.sdmlistpad.Data.Database
import br.edu.ifsp.sdmlistpad.Model.Produto
import br.edu.ifsp.sdmlistpad.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var produtoAdapter: ProdutoAdapter

    val db = Database(this)
    var produtoLista = ArrayList<Produto>()
    private var productAdapter: ProdutoAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   updateUI()

    }
    private fun updateUI()
    {
        val db = Firebase.firestore
        val query: Query = db.collection("produtos").orderBy("nome")
        val options: FirestoreRecyclerOptions<Produto> = FirestoreRecyclerOptions.Builder<Produto>()
            .setQuery(query, Produto :: class.java).build()

        productAdapter = ProdutoAdapter(options)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter


    }

    override fun onStart() {
        super.onStart()
    updateUI()



    }

}
