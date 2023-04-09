package data

import model.Order

object OrderSingleton {
    private var selectedOrder: Order? = null

    fun setSelectedOrder(order: Order) {
        selectedOrder = order
    }

    fun getSelectedOrder(): Order? {
        return selectedOrder
    }
}
