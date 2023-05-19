# Online-Book-Library-Application-v-1.0
# Online-Book-Library-Application - Help

## API Reference

#### User register

```http
  POST /user/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `firstName, lastName, email, password, address, role` | `JSON` | Permitted for all |

#### User Login

```http
  POST /user/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email, password` | `JSON` | Permitted for all |


#### Show book list

```http
  GET /books/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Authentication Token` | `Header ` | Permitted for ADMIN and CUSTOMER |

#### Show book list by bookId

```http
  GET /books/id/{bookId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `bookId` | `Long ` | Permitted for ADMIN and CUSTOMER |

#### Show book list by author name

```http
  GET /books/author/{author}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `authorName` | `String ` | Permitted for ADMIN and CUSTOMER |



