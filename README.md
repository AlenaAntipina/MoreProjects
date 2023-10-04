# AstonMovieCenter

 
## AuthenticationController

### Регистрация пользователя:     
 **POST** - localhost:8081/api/auth/reg

### Авторизация:
 **POST** - localhost:8081/api/auth/login  

### Верификация:
 **POST** - localhost:8081/api/auth/verify/{token}

 
## UserController
 
### Получение юзера по id (для всех пользователей):     
 **GET** - localhost:8081/api/users/{id} 

### Поиск пользователей по фамилии, имени, почте (только для админа):
 **GET** - localhost:8081/api/users  

### Обновление имени и фамилии залогиненного юзера (для всех пользоватеелй):
 **PUT** - localhost:8081/api/users 
