package model

import java.time.format.DateTimeFormatter
import java.util.*

class Order {
    private var id: String? = null
    private var order: String? = null
    private var descricao: String? = null
    private var status: String? = null
    private var comentario: Array<String>? = null
    private var data: String? = null

    constructor(id: String?, order: String?, descricao: String?, status: String?) {
        this.id = id
        this.order = order
        this.descricao = descricao
        this.status = status
        this.data = Calendar.getInstance().time.toString()
    }



    fun getId(): String? {
        return id
    }

    fun getOrder(): String? {
        return order
    }

    fun getDescricao(): String? {
        return descricao
    }

    fun getStatus(): String? {
        return status
    }

    fun getComentario(): Array<String>? {
        return comentario
    }

    fun getData(): String? {
        return data
    }


}