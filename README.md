# Presupuesto MVC v2🔐

> [!NOTE]
> A este proyecto se le ha cambiado las etiquetas **jsp** por etiquetas **jstl**.

## 🗣️ Explicaci&oacute;n del proyecto:
* Al usuario se le muestra un formulario inicial con dos checkbox(Seguro de Edificio y Seguro de Contenido).
* Puede elegir ambas opciones o una de ellas.
* Una vez seleccionado el seguro o seguros que quiere se le redirigir&aacute; a las siguientes vistas:
  [Vista Edificio]:

    El usuario deber&aacute; ingresar los siguientes datos:
    * Tipo de edificio. (piso, casa, adosado, duplex o chalet).
    * Numero de habitaciones. (1, 2, 3, 4 o m&aacute;s de 4).
    * Fecha de construcci&oacute;n. (antes de 1950, entre 1950 y 1990 , entre 1991 y 2005, entre 2006 y 2015 o despu&eacute;s de 2015).
    * Tipo de construcci&oacute;n. (hormig&oacute;n o madera)
    * Valor estimado en el mercado. (menos de 50.000, entre 50.001 y 80.000, entre 80.001 y 100.000, entre 100.001 y 150.000 o m&aacute;s de 150.000) 

  [Vista Contenido]:

  El usuario deber&aacute; ingresar los siguientes datos:
  * Cubrir daños accidentales.(s&iacute; o no).
  * Cantidad asegurada.(10.000, 20.000, 30.000, 50.000 o 100.000).
  * Franquicia.(Ninguna, 500 o 1.000).

* Una vez ingresado los datos en el seguro o seguros correspondientes se le redirigir&aacute; a la Vista **"verContenido"** d&oacute;nde se le mostrar&aacute; al usuario:
   * El seguro o seguros que a elegido junto a los datos que ha rellenado y el total del seguro.

## ⚙️ Especificaciones:

- **IDE utilizado para el proyecto:** _NetBeans 19_
- **JDK usado:** _JDK 11_
- **Java EE 7**
- **Proyecto subido mediante:** _GitHub Desktop_

## ℹ️ Informaci&oacute;n del proyecto:

- **Autor:** _Alberto S&aacute;nchez Mac&iacute;as_
- **Curso** _DAW 2-B_
- **Asignatura:** _Desarrollo Web en Entorno Servidor_
- **Profesor:** _Jes&uacute;s Garc&iacute;a Garrijo_
- **Instituto:** _IES Albarregas_
