package com.example.data.data.model.user

import com.example.domain.models.user.User
import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val userEntity: UserEntity? = null,

	@field:SerializedName("token")
	val token: String? = null
)
{
	fun toUser():User{
		return User(
			name = userEntity?.name,
			email = userEntity?.email,
			role = userEntity?.role,
		)
	}
}

data class UserEntity(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
