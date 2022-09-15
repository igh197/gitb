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
User Class: 
| Parameter Name | Data Type | Description| 
| -------------- |-----------|---------------------------------|
| id | Long int | primary key of User class|
| name | String | name of user|
| account | String | account of user |
| password | String | password of user, will be encrypted by password encoder of Spring Security |
| email | String | email address of user |
| auth | String | It will be the authority of user |
| createdAt | LocalDateTime | created date and time of user |
| updatedAt | LocalDateTime | updated date and time of user |
| restauarants | List`<Restaurant>` | One to Many relation with Restaurant class |

Restaurant Class: 
| Parameter Name | Data Type | Description| 
| -------------- |-----------|---------------------------------|
| id | Long int | primary key of Restaurant class|
| name | String | name of Restaurant |
| category | String | main cotegory of restaurant |
| address | String | address of restaurant |
| openTime | LocalTime | open time of restaurant |
| closeTime | LocalTime | close time of restaurant |
| logo | BLOB | logo image of restaurant |
| createdAt | LocalDateTime | created date and time of restaurant |
| updatedAt | LocalDateTime | updated date and time of restaurant |
| descrition | String | information about restaurant |
| member | Member | Foreign key related to Member class which is many to one relation |






* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

	return to page right before event.
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** 

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**
