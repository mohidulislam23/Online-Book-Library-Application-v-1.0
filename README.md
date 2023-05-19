# Online-Book-Library-Application-v-1.0
# Online-Book-Library-Application - Help

# Library Application

This is intended as a quick reference and showcase. For more complete info, see the [Github-info page.](https://github.com/mohidulislam23/Online-Book-Library-Application-v-1.0) 


## Deployment

To deploy this project run

### Database

Create Database on MySQL:

```bash
  CREATE DATABASE library;
```
### Clone the LibraryApplication and others in a local repository
 
```bash
  git clone git@github.com:mohidulislam23/Online-Book-Library-Application-v-1.0.git;
```

### Run the SecurityModuleApplication
 Select SecurityModuleApplication and run it. It will Create ``users`` and ``books`` tables in ``library`` Database. 

### API Access
 You can Access the api using api access software like [Postman](https://www.postman.com/downloads/) , [isomania](https://insomnia.rest/download). See example from ``demo imgs`` and ``demo data`` folder.
 

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

#### Show book list by author name and book name

```http
  GET /books/author/{author}/{bookName}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `authorName, bookName` | `String, String ` | Permitted for ADMIN and CUSTOMER |

#### Create Book Details

```http
  POST /books/create/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `bookId, authorName, bookName` | `Long, String, String ` | Permitted for ADMIN  |

#### Update a Book's Details

```http
  POST /books/update/{bookId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `authorName, bookName` | `String, String ` | Permitted for ADMIN  |

#### Delete a Book

```http
  POST /books/delete/{bookId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `bookId` | `Long ` | Permitted for ADMIN  |


## Authors

- [@mohidulislam23](https://github.com/mohidulislam23)

