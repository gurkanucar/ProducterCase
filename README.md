
# Producter Test Case

#### Requirements:

Spring Boot application with maven should be developed to handle the following specifications using GraphQL. Imagine that the application is basketball player registration for a basketball team. A Player can be added, deleted and also all players in the system can be listed.

- Please write 2 mutations and 1 query to complete specifications.
- 1 mutation for single player add.
- 1 mutation for single player delete.
- 1 query is for listed all basketball players in the system.
- Player has name, surname and position.
- Positions for Player
    - Point guard(PG),
    - Shooting guard(SG),
    - Small forward(SF),
    - Power forward(PF),
    - Center(C)
- Please consider input validation especially for mutation services.
- Please consider that a basketball team has maximum capacity during implementation.
- Please use a relational database, it could be MySQL. You can use Spring boot with H2 Database to demonstrate and test your proof of concept.
- Please write a unit test with any test framework, JUnit is enough for us.
- Please send your codes via any public repository which is located on Github or Bitbucket.


## How to run?


```bash
  git clone https://github.com/gurkanucar/ProducterCase.git

  cd ProducterCase

  mvn spring-boot:run
```


## Running Tests

To run tests, run the following command

```bash
  mvn test
```


## Usage/Examples

#### Api Endpoint
`/apis/graphql`

#### Get All Players


- `get all players - request`
```graphql
query {
  getAllPlayer {
    position name surname id   
  }
}
```

- `get all players - response`
```javascript
{
    "data": {
        "getAllPlayer": [
            {
                "position": "PF",
                "name": "Michael",
                "surname": "Jordan",
                "id": "1"
            },
            {
                "position": "C",
                "name": "LeBron",
                "surname": "James",
                "id": "2"
            },
           .............
        ]
    }
}
```

#### Add player

- `add player - request`
```graphql
mutation {
  addPlayer (
    createPlayer :{
        name: "Hidayet",
        surname:"Turkoglu",
        position:"SF"
     }
    )
    {
    name position
    }
}
```

- `add player - response`
```javascript
{
    "data": {
        "getAllPlayer": [
            {
                "position": "PF",
                "name": "Michael",
                "surname": "Jordan",
                "id": "1"
            },
            {
                "position": "C",
                "name": "LeBron",
                "surname": "James",
                "id": "2"
            },
           .............
        ]
    }
}
```



#### Delete player

- `delete player by id - request`
```graphql
mutation {
  deletePlayer(id:2)
}
```

- `delete player by id - response`
```javascript
{
    "data": {
        "deletePlayer": true
    }
}
```
## Live Demo

- [https://producter-case.herokuapp.com/apis/graphql](https://producter-case.herokuapp.com/apis/graphql)

