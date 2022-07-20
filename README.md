# EnviroBankBackend-

```

// 20220605081320
// http://localhost:8080/users
[
  {
    "id": 1,
    "email": "md@gmail.com",
    "password": "$2a$10$bmdGvRwILjBIHJcXKTC1TudCTeYSmF/rzh6KHXo.O5wzAyy4bRr1m",
    "name": "mphathisi",
    "surname": "Dayimani",
    "idNumber": "98784343221",
    "roles": [
      {
        "id": 1,
        "name": "admin"
      }
    ],
    "bankAccounts": [
      {
        "bank_account_id": 11,
        "accountNumber": "12340821",
        "accountType": "SAVINGS",
        "accountStatus": "ACTIVE",
        "availableBalance": 94.00,
        "latestBalance": 94.00
      },
      {
        "bank_account_id": 9,
        "accountNumber": "12349023",
        "accountType": "SAVINGS",
        "accountStatus": "ACTIVE",
        "availableBalance": 1500.00,
        "latestBalance": 1500.00
      }
    ],
    "enabled": true,
    "accountNonLocked": true,
    "username": "md@gmail.com",
    "authorities": [
      {
        "authority": "admin"
      }
    ],
    "credentialsNonExpired": true,
    "accountNonExpired": true
  },
  {
    "id": 2,
    "email": "testing@gmail.com",
    "password": "$2a$10$JSCFBqHemcv9.fDFr.nin./t715yJfUGj6Ph0PuEPvz2cymQJrIjq",
    "name": "mphathisi",
    "surname": "Dayimani",
    "idNumber": "98784343221",
    "roles": [
      
    ],
    "bankAccounts": [
      
    ],
    "enabled": true,
    "accountNonLocked": true,
    "username": "testing@gmail.com",
    "authorities": [
      
    ],
    "credentialsNonExpired": true,
    "accountNonExpired": true
  },
]

Login
http://localhost:8080/users

{
    "id": 7,
    "email": "password@testing.com",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3LHBhc3N3b3JkQHRlc3RpbmcuY29tIiwiaXNzIjoiQ29kZUphdmEiLCJyb2xlcyI6IlthZG1pbl0iLCJpYXQiOjE2NTgzNDA1MTYsImV4cCI6MTY1ODQyNjkxNn0.GVt9GEymnjCDBaY-m6ancSuS5QvCtYd5uq2XSwtsNaZSQdwA4LzundUDzESmJ_rbovG41kqsa7mrybv-_34ddA",
    "name": "Change",
    "surname": "password",
    "idNumber": "374387433",
    "roles": [
        "admin"
    ],
    "bankAccounts": [
        {
            "bank_account_id": 40,
            "accountNumber": "12343455",
            "accountType": "SAVINGS",
            "accountStatus": "ACTIVE",
            "availableBalance": 100000,
            "latestBalance": 100000
        }
    ],
    "userAccounts": "[12343455]"
}







```
