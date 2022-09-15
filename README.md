**Personal Favorite Restaurants Website**
----
  Returns json data about my favorite restaurants in Seoul.
 <br>**Restaurants**
| METHOD | URL                                       |
|--------|-------------------------------------------|
| POST   | https://127.0.0.1:8080/restaurants/create |
| GET    | https://127.0.0.1:8080/restaurants        |
| GET    | https://127.0.0.1:8080/restaurant/{id}    |
| PUT    | https://127.0.0.1:8080/restaurant/{id}    |
| DELETE | https://127.0.0.1:8080/restaurant/{id}    |

**Users**
| METHOD | URL                                |
| ------ | :--------------------------------- |
| POST   | https://127.0.0.1:8080/user/create |
| GET    | https://127.0.0.1:8080/users       |
| GET    | https://127.0.0.1:8080/user/{id}   |
| PUT    | https://127.0.0.1:8080/user/{id}   |
| DELETE | https://127.0.0.1:8080/user/{id}   |


*  **URL Params**

   **Required:**
   `id=[Long Type]`

* **Data Params**
User class

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** 

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**
