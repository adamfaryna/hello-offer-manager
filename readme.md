
---

#Hello Offer Manager!
_Simple example of Spring Boot + REST + Emdedded MongoDB + React_

## Introduction

This simple app demonstrates use of Spring Boot with various other technologies: Embedded MonboDB, React, Webpack.

It is created with use of SOLID and TDD principles - in both Spring helps a lot. 

Both interfaces are provided REST API and browser.

# Some informations

Authentication and authorization is omitted at this moment. It will be provided in future releases so stay tuned.

## How to run

Simply run

`./mwnw spring-boot:run`

and that's it, server is app and running. You can make a REST API calls as described below or just enter the browser view at `http://localhost:8080` to play with offers.

## REST API

You can use any tool to make REST API calls to Hello Offer Manager, we prefer to use `curl` from cmd.

GET /api/offers/{id} - (requires offer id param) gets offer with provided `id`
GET /api/offers - gets all offers
PUT /api/offers/{id} - (requires offer id param) edit or add offer with provided `id`
POST /api/offers - (requires passed single offer without id in request body ) saves offer to database
DELETE /api/offers/{id} - (requires offer id param) removes offer with provided id

JSON offer structure:
{
	"id": "...",
	"name: "...",
	"description":,
	"currency": "...",
	"price": "..."
}

## Have a Fun!
