package com.example.data.data

import com.example.domain.models.Category

sealed class CategoryState {

    class Success<T>(category: T?): CategoryState()
    class Fail<T>(error: T?): CategoryState()
}