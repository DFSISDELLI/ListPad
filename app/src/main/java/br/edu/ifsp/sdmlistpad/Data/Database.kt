package br.edu.ifsp.sdmlistpad.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.edu.ifsp.sdmlistpad.Data.Database.Companion.COD
import br.edu.ifsp.sdmlistpad.Model.Produto
import java.util.*
import kotlin.collections.ArrayList

class Database(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_Version) {

    companion object {
        private val DATABASE_NAME = "produto.db"
        private val DATABASE_Version = 1
        private val TABLE_NAME = "Produtos"
        private val COD = "COD"
        private val NOME = "Nome"
        private val DESCRICAO = "Descrição"


    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME ($COD INTEGER PRIMARY KEY AUTOINCREMENT, $NOME TEXT, $DESCRICAO TEXT)"



        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun inserirProduto(produto: Produto): Long {

        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COD, produto.COD)
        values.put(NOME, produto.nome)
        values.put(DESCRICAO, produto.descricao)

        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result

    }

    fun listarProduto(): ArrayList<Produto> {

        val listaProduto = ArrayList<Produto>()
        val query = "SELECT * FROM $TABLE_NAME ORDER BY $NOME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val c = Produto(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2))
            listaProduto.add(c)
        }

        cursor.close()
        db.close()
        return listaProduto

        }
    }



