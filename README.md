# UserManagementApi
Restful Api User Management Using Springboot, Jpa, Lombok, And SQL


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



# Contact API Spec

## Create Contact

EndPoint : POST /api/contacts

Request Header:

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName": "Fannan",
  "lastName": "Fauzan Fardhurohman",
  "email": "fannan@example.com",
  "phone": "08123456789"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstName": "Fannan",
    "lastName": "Fauzan Fardhurohman",
    "email": "fannan@example.com",
    "phone": "08123456789"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Email format invalid, phone format invalid, etc"
}
```

## Update Contact

EndPoint : PUT /api/contacts/{idContacts}

Request Header:

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName": "Fannan",
  "lastName": "Fauzan Fardhurohman",
  "email": "fannan@example.com",
  "phone": "08123456789"
}
```

Response Body (Success) :

```json
{
  "id": "random-string",
  "firstName": "Fannan",
  "lastName": "Fauzan Fardhurohman",
  "email": "fannan@example.com",
  "phone": "08123456789"
}
```

Response Body (Failed) :

```json
{
  "errors": "Email format invalid, phone format invalid, etc"
}
```

## Get Contact

EndPoint : GET /api/contacts/{idContacts}

Request Header:

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "id": "random-string",
  "firstName": "Fannan",
  "lastName": "Fauzan Fardhurohman",
  "email": "fannan@example.com",
  "phone": "08123456789"
}
```

Response Body (Failed,404) :

```json
{
  "errors": "Contact is not found"
}
```

## Search Contact

EndPoint : GET /api/contacts

Query Param:

- name : String, contact first name or last name, using like query, optional
- phone : String, contact phone, using like query, optional
- email : Sring, contact email, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Request Header:

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "random-string",
      "firstName": "Fannan",
      "lastName": "Fauzan Fardhurohman",
      "email": "fannan@example.com",
      "phone": "08123456789"
    },
    {
      "id": "random-string",
      "firstName": "Fannan1",
      "lastName": "Fauzan Fardhurohman",
      "email": "fannan@example.com",
      "phone": "08123456789"
    }
  ],
  "paging": {
    "currentPage": 0,
    "total_page": 10,
    "size": 10
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "Unauthorized"
}
```

## Remove Contact

EndPoint : DELETE /api/contacts/{idContacts}

Request Header:

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "Data successfully deleted"
}
```

Response Body (Failed) :

```json
{
  "errors": "Contacts Not Found"
}
```


# Address Api Spec

## Create Address

Endpoint : POST /api/contacts/{idContacts}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "What Street",
  "city": "Bandung",
  "province": "West Java",
  "country": "Indonesia",
  "postalCode": "40553"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "randomString",
    "street": "What Street",
    "city": "Bandung",
    "province": "West Java",
    "country": "Indonesia",
    "postalCode": "40553"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Contacts is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContacts}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "What Street",
  "city": "Bandung",
  "province": "West Java",
  "country": "Indonesia",
  "postalCode": "40553"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "randomString",
    "street": "What Street",
    "city": "Bandung",
    "province": "West Java",
    "country": "Indonesia",
    "postalCode": "40553"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContacts}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "randomString",
    "street": "What Street",
    "city": "Bandung",
    "province": "West Java",
    "country": "Indonesia",
    "postalCode": "40553"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContacts}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContacts}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "randomString",
      "street": "What Street",
      "city": "Bandung",
      "province": "West Java",
      "country": "Indonesia",
      "postalCode": "40553"
    },
    {
      "id": "randomString",
      "street": "What Street",
      "city": "Bandung",
      "province": "West Java",
      "country": "Indonesia",
      "postalCode": "40553"
    },
    {
      "id": "randomString",
      "street": "What Street",
      "city": "Bandung",
      "province": "West Java",
      "country": "Indonesia",
      "postalCode": "40553"
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors": "Contact is not found"
}
```
