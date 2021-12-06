package br.edu.ifsp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.sdmlistpad.Model.Produto
import br.edu.ifsp.sdmlistpad.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class Produtoadapter (options: FirestoreRecyclerOptions<Produto>)
    : FirestoreRecyclerAdapter<Produto, Produtoadapter.ProdutoViewHolder>(options)
{


    inner class ProdutoViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
    val nomeVH =  view.findViewById<TextView>(R.id.nome)
    val descricaoVH =  view.findViewById<TextView>(R.id.descricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.produto_celula,parent,false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int, model: Produto) {
       holder.nomeVH.text = model.nome
        holder.descricaoVH.text = model.descricao
    }


}