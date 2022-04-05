package br.com.fiap.recyclerviewteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val variavelRecyclerView = findViewById<RecyclerView>(R.id.id_do_RecyclerView)
        variavelRecyclerView.adapter = ListaComTodosOsItens(contex = this, produtos = listOf(
            Produto(
                nome = "Cesta de frutas",
                descricao = "Laranja, Maça, Uva",
                valor = 19.99
            ),
            Produto(
                nome = "Caixa de frutas",
                descricao = "Melancia, Banana, Pera",
                valor = 15.85
            ),
            Produto(
                nome = "Sacola de frutas",
                descricao = "Morango, Maça, Amora",
                valor = 10.43
            )
        ))

        variavelRecyclerView.layoutManager = LinearLayoutManager(this) // para executar um RecyclerView é necessario declarar qual tipo
                                                                              // de layout sera exibido as views, esse comando pode ser feito dessa forma
                                                                              // ou diretamente no layout (exemplo em activity_main)

    }
}