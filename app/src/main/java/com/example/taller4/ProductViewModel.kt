import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<MutableList<Product>>(mutableListOf())
    val products: LiveData<MutableList<Product>> get() = _products

    fun addProduct(product: Product) {
        _products.value?.add(product)
        _products.value = _products.value // Trigger LiveData update
    }
}