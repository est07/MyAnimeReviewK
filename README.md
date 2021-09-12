# My Anime Review

Esta aplicación fue realizada con el objetivo de implementar diferentes componentes como ViewModel, LiveData, corrutinas para el manejo de hilos, uso de flow para realizar consultas a las API utilizadas y inyectar dependencias con Koin ademas de realizar la navegación entre pantallas, con el paquete de AndroidX.


## Using :

[Retrofit](http://square.github.io/retrofit/)

[Moshi](https://github.com/square/moshi)

[RxAndroid](https://github.com/ReactiveX/rxandroid)

[Picasso](https://github.com/square/picasso)

[AndroidX](https://developer.android.com/jetpack/androidx)

[Coroutines](https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html)

[Koin](https://github.com/InsertKoinIO/koin)

#Project structure 

El proyecto fue realizado con el patrón de diseño de clean architecture por lo cual esta compuesto por tres package los cuales son data, domain,  y presentation.

En el package de data se encuentran los packages de mapper se el cual contiene los componentes que nos permiten comunicar la capa de data con la de presentation siguiendo el patrón de  clean architecture, y en el package service se encuentran los componentes que nos permiten realizar consultas al API de https://jikan.docs.apiary.io/#reference/0/season-archive.

En el package de domain se encuentran los componentes que nos permiten la comunicación de esta capa con la de data y presentation, ademas de los datos que se envían entre estas, también si existe una lógica de negoció se manejaría en esta capa, debido a que en esta app no hay lógica de negocio esta capa no cuenta con casos de uso.

En el package de presentation se encuentran todos los componentes que son utilizados para mostrar las vistas.

# En las imagenes mostradas a continuación se puede observar el funcionamiento del app.

 Lista de Anime Top

<img src="/Images/AnimeReviewSuccess.gif" width="225" height="450">

 Error de conexión en la Lista de Anime Top

<img src="/Images/AnimeReviewError.gif" width="225" height="450">

 Error de conexión en el Detalle del Anime
 
 <img src="/Images/AnimeReviewDetailError.gif" width="225" height="450">

# How it looks

A continuación se puede observar los Screenschots de cada una de las vistas del app.

<img src="/Images/Screenshot_1631407226.png" width="225" height="450">
<img src="/Images/Screenshot_1631407259.png" width="225" height="450">
<img src="/Images/Screenshot_1631407273.png" width="225" height="450">
<img src="/Images/Screenshot_1631407278.png" width="225" height="450">
<img src="/Images/Screenshot_1631407299.png" width="225" height="450">

# Resources:

https://www.raywenderlich.com/5365-jetpack-navigation-controller
https://www.raywenderlich.com/5046-android-architecture-components-viewmodel
https://www.raywenderlich.com/4980-android-architecture-components-livedata
https://www.raywenderlich.com/8984-mvvm-on-android
https://www.raywenderlich.com/5730-dependency-injection-with-koin
https://developer.android.com/jetpack/androidx/releases/navigation
https://medium.com/androiddevelopers/coroutines-on-android-part-i-getting-the-background-3e0e54d20bb
https://developer.android.com/kotlin/flow
https://github.com/public-apis/public-apis#anime
https://jikan.docs.apiary.io/#reference/0/season-archive


