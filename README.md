

# ForoHub 💻💬




![Static Badge](https://img.shields.io/badge/java-17-green)
![Static Badge](https://img.shields.io/badge/springboot-v3.2.5-green)
![Badge en Desarollo](https://img.shields.io/badge/status-EN%20DESARROLLO-blue)
![GitHub last commit](https://img.shields.io/github/last-commit/diego-vilca/Foro-Hub)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](https://choosealicense.com/licenses/mit/)

ForoHub es una API REST diseñada para crear una plataforma de foros educativos y colaborativos. En ForoHub, un *usuario* autenticado puede participar activamente en la comunidad creando *tópicos* relacionados con diversos *cursos*. Esta interacción no solo permite a los usuarios compartir conocimientos y resolver dudas, sino que también fomenta un ambiente de aprendizaje colaborativo y de apoyo mutuo.

***Funcionalidades:***
- crear Usuario
- crear Curso
- crear Topico
- listar Topicos
- buscar Topico por id
- modificar Topico
- eliminar Topico 
- autentición con Spring Security y JWT
- documentación local con Swagger
  
</br>

## Tecnologías Utilizadas
- **Java 17**
- **SpringBoot 3.3.1**
- **MySQL**
- **Insomnia/Postman**
- **JWT**
- **OpenAPI**
- **IntelliJ IDEA 2024.1.1**

</br>

## DER
![DER](https://github.com/user-attachments/assets/1fcaaca9-0d37-44b0-92f8-f5fa34584a35)

</br>

## Acceso Al Proyecto
Para utilizar el programa debes descargar el [archivo.zip](https://github.com/diego-vilca/Foro-Hub/tree/main/foro) o clonar el proyecto a la ubicación que desees:

```bash
  git clone https://github.com/diego-vilca/Foro-Hub.git
  ```
</br>


## Variables De Entorno

Para que el proyecto funcione correctamente, asegúrate de configurar las siguientes variables de entorno:

- `DB_HOST`: Host de la base de datos.
- `DB_NAME`: Nombre de la base de datos.
- `DB_USER`: Usuario de la base de datos.
- `DB_PASSWORD`: Contraseña de la base de datos.
- `JWT_SECRET`: Clave secreta para la generación de tokens JWT.
- `JWT_EXPIRATION`: Tiempo de expiración de los tokens JWT (en milisegundos).


</br>

## Configuración de Variables de Entorno

Puedes configurar las variables de entorno en tu sistema operativo o crear un archivo `.env` en el directorio raíz del proyecto con el siguiente contenido:

```env
DB_HOST=your_database_host
DB_NAME=your_database_name
DB_USER=your_database_user
DB_PASSWORD=your_database_password
JWT_SECRET=your_jwt_secret
JWT_EXPIRATION=your_jwt_expiration_time
```

</br>

>[!IMPORTANT]
>Para probar la API es necesario crear en primer lugar un usuario para obtener el JWT token que permita el acceso a los endpoints protegidos.

## API
### Usuario

#### Crear Usuario

```http
  POST /usuario
```
- Descripción: Crea un nuevo usuario.
- Body (JSON):
```http
{
  "nombre": "string",
  "correoElectronico": "string",
  "contrasenia": "string"
}
```
- Respuesta Exitosa:
  - Código: 201 CREATED
  - Cuerpo:


```http
{
  "id": "number",
  "nombre": "string",
  "correoelectronico": "string",
  "rol": "string"
}
```

### Curso

#### Crear Curso

```http
  POST /curso
```
- Descripción: Crea un nuevo curso.
- Body (JSON):
```http
{  
  "nombre": "string",
  "categoria": "string"
}

```
- Respuesta Exitosa:
  - Código: 201 CREATED
  - Cuerpo:


```http
{  
  "id": "number",
  "nombre": "string",
  "categoria": "string"
}
```
### Topico

#### Crear Topico

```http
  POST /topico
```
- Descripción: Crea un nuevo topico.
- Body (JSON):
```http
{  
  "idAutor": "number",
  "titulo": "string",
  "mensaje": "string",
  "nombreCurso": "string"
}

```
- Respuesta Exitosa:
  - Código: 201 CREATED
  - Cuerpo:


```http
{  
  "id": "number",
  "titulo": "string",
  "mensaje": "string",
  "fecha": "date-time"
}
```
#### Listar Topico

```http
  GET /topico
```
- Descripción: Lista todos los tópicos.

- Respuesta Exitosa:
  - Código: 200 OK
  - Cuerpo:


```http
{
  "totalElements": "number",
  "totalPages": "number",
  "size": "number",
  "content": [
    {
      "id": "number",
      "titulo": "string",
      "mensaje": "string",
      "fecha": "date-time",
      "estado": "string",
      "idAutor": "number",
      "nombreCurso": "string"
    }
  ]
}
```

#### Buscar Topico por Id

```http
  GET /topico/{id}
```
- Descripción: Busca un tópico por su ID.

- Respuesta Exitosa:
  - Código: 200 OK
  - Cuerpo:


```http
{
    "id": "number",
    "titulo": "string",
    "mensaje": "string",
    "fecha": "date-time",
    "estado": "string",
    "idAutor": "number",
    "nombreCurso": "string"
}
```
#### Modificar Topico

```http
  PUT /topico/{id}
```
- Descripción: Modifica un tópico existente.
- Body (JSON):
```http
{  
  "titulo": "string",
  "mensaje": "string"
}

```
- Respuesta Exitosa:
  - Código: 200 OK
  - Cuerpo:


```http
{  
  "id": "number",
  "titulo": "string",
  "mensaje": "string",
  "fecha": "date-time"
}
```
#### Eliminar Topico

```http
  DELETE /topico/{id}
```
- Descripción: Elimina un tópico.
- Respuesta Exitosa:
  - Código: 204 NO CONTENT

</br>

>[!NOTE]
>Próximamente se añadirán los demás endpoints que restan finalizar y el deploy de la api en la nube.

</br>

## Autor

- [@diego-vilca](https://github.com/diego-vilca)
  
</br>

## License

Este proyecto está licenciado bajo la [licencia MIT](https://choosealicense.com/licenses/mit/)

