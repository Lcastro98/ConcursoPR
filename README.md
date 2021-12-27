# ConcursoPR

En este reto vamos a modelar un concurso de preguntas y respuestas, la intención es diseñar una solución que permita tener un banco de preguntas con diferentes opciones para una única respuesta, además cada pregunta debe estar en una categoría o un grupos de preguntas similares del mismo nivel, por cada ronda se deberá asignar un premio a conseguir, las rondas del juego son nivel que van aumentando en la medida que el jugador gana premios.

**Use Case/Problem**

Lo que se busca en este juego es pre-construir una serie de preguntas con 4 opciones de respuesta y una de ella válida, además de una categoría asociada con el mismo nivel de
dificultad. Cada pregunta debe estar categorizada y debe existir mínimo 5 preguntas por categoría donde por cada ronda se debe extraer una pregunta de esa categoría de forma aleatoria, debe existir 5 rondas en todo el juego, cada ronda otorga premios (puntos o dinero) cuando el jugador acierta correctamente.

El acomulado de premios está dentro del concurso pero si dado el caso el jugador pretender salir de juego puede retirarse antes de responder a la pregunta, si por el contrario el jugador pierde entonces saldría del juego sin el acomulado que llevaría en ese momento.

## Tabla de Contentenido
1. [Información General](#informacion-general)
2. [Tecnologías](#tecnologias)
3. [Instalación](#instalacion)
4. [A tener en cuenta](#a-tener-en-cuenta)


### Información General
Para la solución de este reto se propone la creación de una aplicación de escritorio siguiendo la estructura Modelo Vista Controlador.


### Tegnologías
La aplicación se desarrolla en lenguaje Java en el IDE Netbeans y la base de datos se crea en MySQL.


### Instalación
Clone el repositorio 
```
$ git clone https://github.com/Lcastro98/ConcursoPR.git
```

### A tener en cuenta
- Se requiere tener la base de datos creada de manera local para que el programa pueda almacenar y usar los datos. En la carpeta utils están los archivos sql para la creación de las tablas.
- Agregar al proyecto en Netbeans las librerias json-simple-1.1.1.jar y mysql-connector-java-8.0.26.jar que se encuentran en la carpeta libs.
- Asegúrese que el archivo db_credentials.json ubicado en el paquete utils tenga sus credenciales del workbench para poder realizar la conexión a la base de datos.
