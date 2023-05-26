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
