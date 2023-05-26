# User Api Specs

## Register User

- End point : POST /api/users

Request Body :
```json
{
  "username": "fannan",
  "password": "rahasia123",
  "name": "fannan fauzan"
}
```
Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Username must not blank, ???"
}
```


## Login User
- End point : POST /api/auth/login

Request Body :
```json
{
  "username": "fannan",
  "password": "rahasia123"
}
```
Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt": 23123123412 // miliseconds
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "username or password wrong"
}
```


## Get User
- End point : GET /api/users/current

Request Header:
 
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : {
   "username" : "fannan",
    "name": "fannan fauzan"
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```

## Update User
- End point : PATCH /api/users/current

Request Header:

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name": "fannan fauzan", // put if only want to update name
  "password": "new password" // put if only want to update password
}
```

Response Body (Success) :

```json
{
  "data" : {
   "username" : "fannan",
    "name": "fannan fauzan"
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```

## Logout User
- End point : DELETE /api/auth/logout

Request Header:

- X-API-TOKEN : Token (Mandatory)
  Response Body (Success) :

```json
{
  "data" : "Ok"
}
```