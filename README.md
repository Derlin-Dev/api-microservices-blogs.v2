#url del proyecto:

- https://roadmap.sh/projects/todo-list-api

# Proyecto API DE PRATAFORMA DE BLOGS

## Descripción

Esta API proporciona funcionalidades para gestionar una plataforma de blogs. Permite la creación, edición y eliminación de publicaciones, comentarios y repuestas, autenticación basada en tokens.

## Tecnologías Utilizadas

- Java con Spring Boot
- Spring Security (JWT para autenticación)
- API Gateway con Spring Cloud
- Eureka Server para descubrimiento de servicios
- Server config para el manejo de las configuraciones desde github
- Base de datos PostgreSQL
- Docker para contenedorización


## Funcionalidades

- Registro de usuarios
- Autenticación con JWT
- CRUD de publicaciones (Crear, Leer, Actualizar, Eliminar)
- CRUD de coentarios y repuestas.

## Requisitos

- Tener instalado Java 17+
- Docker y Docker Compose
- PostgreSQL (opcional si se usa Docker)
- IntelliJ IDEA o VS Code

## Instalación y Ejecución

Sigue estos pasos para descargar y ejecutar el proyecto en tu máquina utilizando Docker Compose:

1. Clona el repositorio:

    ```bash
    git clone https://github.com/Derlin-Dev/api-microservices-blogs.v2.git
    cd microservices-blogs
    ```

2. Construye y levanta los contenedores de la aplicación y la base de datos con Docker Compose:

    ```bash
    docker-compose up --build
    ```

   Esto levantará tanto la aplicaciónes de Spring Boot como una instancia de PostgreSQL. La API estará disponible en `http://localhost:8081`.

3. Accede a la API desde tu cliente REST favorito o desde la línea de comandos usando `curl`.

## Variables de Entorno

El archivo `docker-compose.yml` está configurado para tomar las siguientes variables de entorno:

- `JWT_SECRET`: Clave secreta para firmar los tokens JWT.
- `DATABASE_URL`: URL de la base de datos PostgreSQL.
  
Asegúrate de configurar estos valores correctamente en el archivo `.env`.

## Endpoints

| Método  | URL                                        | Autenticación | Body (Ejemplo) |
|---------|-------------------------------------------|---------------|----------------|
| **Auth-service** ||||
| POST    | `/auth/signup`                            | No            | `{ "userName": "derlin001", "password": "123456", "email": "derlin001@gmail.com", "roles": "USER" }` |
| POST    | `/auth/login`                             | No            | `{ "userName": "derlin001", "password": "123456" }` |
| **Post-services** ||||
| GET     | `/post/get`                               | No            | -              |
| GET     | `/post/get/{id}`                          | No            | -              |
| POST    | `/post/new`                               | Sí            | `{ "titulo": "Introducción en Spring Boot", "contenido": "Este es un post para tener una introducción a Spring Boot", "tag": "Tech" }` |
| PUT     | `/post/put/{id}`                          | Sí            | `{ "titulo": "Introducción a Spring Boot 'Actualizado'", "contenido": "Spring Boot es un marco que simplifica la creación de aplicaciones Java...", "tag": "SpringBoot",             "numeroDeCometarios": 0 }` |
| DELETE  | `/post/delete/{id}`                       | Sí            | -              |
| **Comment-services** ||||
| GET     | `/comment/post/{id}`                      | No            | -              |
| GET     | `/comment/user/{id}`                      | Sí            | -              |
| POST    | `/comment/user/new`                      | Sí             | `{ "userId": "4", "postId": "1", "comment": "Este es un comentario al post...." }` |
| PUT     | `/comment/user/put/{id}`                  | Sí            | `{ "comment": "Este es un comentario actualizado...." }` |
| DELETE  | `/comment/user/delete/{id}`               | Sí            | -              |
| POST    | `/answers/new`                            | Sí            | `{ "idUserComment": 7, "idUserAnswers": 5, "answers": "Esta es una respuesta al comentario 2.", "commentId": 4 }` |

##Seguridad y Autenticación

La API utiliza tokens JWT para la autenticación.
Los endpoints protegidos requieren el token en el encabezado Authorization: Bearer <token>.
Los roles de usuario determinan los permisos para acceder a ciertos endpoints

## Uso de la API

1. **Registro**: Los usuarios pueden registrarse enviando una petición POST a `/auth/signup` con su nombre, correo, contraseña y rol.
   
2. **Autenticación**: Para iniciar sesión, los usuarios deben enviar su usuario y contraseña a `/auth/login`. Si las credenciales son correctas, recibirán un token JWT que deben usar en las peticiones posteriores.

3. **CRUD de Tareas**: Después de autenticarse, los usuarios "ADMIN" pueden gestionar sus publicaciones.

### Autorización

Los endpoints que requieren autorización deben incluir el token JWT en el encabezado `Authorization` con el formato:

## NOTA

- Este es un proyecto en el que seguire trabaando para imprementar nuevas  funcionalidad y mejorando algunas de ellas.
- No estoy usando lonbok en este proyecto por un tema de error en con mi IDE. Aun estoy tratando de corregi.
- Cualquier duda o sugerencia, contáctame en perfil de GitHub o mi linkedin "https://www.linkedin.com/in/derlin-v-peguero/".

