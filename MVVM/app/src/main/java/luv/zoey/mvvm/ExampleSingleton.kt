package luv.zoey.mvvm

import luv.zoey.mvvm.models.User

object ExampleSingleton {

    val singletonUser : User by lazy{
        User("zooey4u@gmail.com","Jeon","image.png")
    }

}