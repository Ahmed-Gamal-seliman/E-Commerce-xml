package com.example.data.data.model.new_order.helper_extentions


import com.example.data.data.model.new_order.Brand
import com.example.data.data.model.new_order.CartItemsItemEntity
import com.example.data.data.model.new_order.CategoryEntity
import com.example.data.data.model.new_order.DataItemEntity
import com.example.data.data.model.new_order.MetadataEntity
import com.example.data.data.model.new_order.OrderEntity
import com.example.data.data.model.new_order.ProductEntity
import com.example.domain.models.Category
import com.example.domain.models.order.CartItemsItem
import com.example.domain.models.order.DataItem
import com.example.domain.models.order.Metadata
import com.example.domain.models.order.Order
import com.example.domain.models.order.Product

fun CartItemsItemEntity.toCartItemsItem(): CartItemsItem {
    return CartItemsItem(
        product= this.productEntity?.toProduct(),
        price = this.price,
        count=this.count,

        )
}







fun CategoryEntity.toCategory(): Category {
    return Category(
        image=image,
        name= name,
        id=id,
        slug=slug
    )
}






fun DataItemEntity.toDataItem(): DataItem
{
    return DataItem(
        cartItems = cartItems?.map {
            it?.toCartItemsItem()
        }
    )
}



fun MetadataEntity.toMetadata():Metadata{
    return Metadata(

    )
}

fun OrderEntity.toOrder(): Order {
    return Order(

        data = data?.map {

            it?.toDataItem()

        }
    )
}








fun ProductEntity.toProduct(): Product {
    return Product(
        imageCover= imageCover,
        title=title,
        category = categoryEntity?.toCategory(),
        ratingsQuantity = ratingsQuantity,
        brand = this.brand?.toBrand()

    )
}

fun Brand.toBrand():com.example.domain.models.order.Brand{
    return com.example.domain.models.order.Brand(
        image= this.image,
        name= this.name,
        id= this.id,
        slug= this.slug
    )
}