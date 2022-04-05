package br.com.fiap.recyclerviewteste


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaComTodosOsItens (

    private val produtos : List<Produto>,
    private val contex: Context // variavel default para usar no inflater!!

        ) : RecyclerView.Adapter<ListaComTodosOsItens.variavelViewHolder>() { // dentro do adapter colocamos a classe do viewHolder que criamos
                                                                              // neste caso "variavelViewHolder"



    class variavelViewHolder( viewRecebida : View) : RecyclerView.ViewHolder(viewRecebida) {

        fun vincula(produto: Produto) {
            val nomeView = itemView.findViewById<TextView>(R.id.nome)
            nomeView.text = produto.nome
            val descricaoView = itemView.findViewById<TextView>(R.id.descricao) // esse itemView represente o layout que a gente transformou em uma view
            descricaoView.text = produto.descricao                              // no processo de inflate na função onCreateViewHolder
            val valorView = itemView.findViewById<TextView>(R.id.valor)
            valorView.text = produto.valor.toString()
        }

    }


    // dentro dessa função abaixo vamos criar a view que sera passada para construtor do ViewHolder responsavel por acessar todas as views do layout que criamos
    // é necessario criar uma classe para poder passar essa view para o contrutor do viewHolder e essa classe geralmente é criada dentro do proprio adapter
    // a classe foi criada acima, e é ela que retornamos nessa função

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): variavelViewHolder {

        val variavelInflater = LayoutInflater.from(contex)                                  // aqui estamos fazendo um processo que chama inflar uma view ou seja
        val view = variavelInflater.inflate(R.layout.itens_produto,parent,false) // criar uma view unica para cada objeto de produtos retornado

        return variavelViewHolder(view) // view passada para o construtor do ViewHolder(variavelViewHolder)
    }

    override fun onBindViewHolder(holder: variavelViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto) // essa função esta sendo criada dentro do ViewHolder

    }

    override fun getItemCount(): Int {
        return produtos.size
    }

}
