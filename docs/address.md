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
