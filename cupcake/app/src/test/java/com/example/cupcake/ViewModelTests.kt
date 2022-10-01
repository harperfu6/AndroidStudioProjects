package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {} // ここでマッピングを定義しているpriceを監視しないとマッピングが呼ばれず、正しく価格表示されない
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }
}