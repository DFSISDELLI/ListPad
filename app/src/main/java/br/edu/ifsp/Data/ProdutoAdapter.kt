package br.edu.ifsp.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.sdmlistpad.Model.Produto
import br.edu.ifsp.sdmlistpad.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions

private val <T> FirestoreRecyclerOptions<T>.size: Int
    get() {
        TODO()
    }

class ProdutoAdapter(val produtoLista: FirestoreRecyclerOptions<Produto>): RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHoleder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoAdapter.ProdutoViewHoleder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.produto_celula, parent, false)
        return ProdutoViewHoleder(view)
    }

    override fun onBindViewHolder(holder: ProdutoAdapter.ProdutoViewHoleder, position: Int) {
        holder.nomeVH.text = Produto(position).nome
    }

    override fun getItemCount(): Int {
        return produtoLista.size
    }

    inner class ProdutoViewHoleder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeVH = view.findViewById<TextView>(R.id.nome)

    }
}

