# Hacker News Stories

## Deployment

This repository is connected to a Heroku account, and it automatically deploys the master branch on update.
You can see the page for Top Stories live [here](https://hnstories.herokuapp.com/stories/top).

Note that it's a free Heroku account, and it sleeps after 30 minutes of inactivity. So, it takes more time for the first visit.

## Run locally

### Prerequisites
To run the app, you need `docker` to be installed.

### Run Server

Run the following command:

```bash
docker-compose up server
```

### Run Tests

Run the following command:

```bash
docker-compose up test
```
