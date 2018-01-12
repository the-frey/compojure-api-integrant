# compojure-api-integrant

Some defaults to get up-and-running with Compojure API and Integrant in dev as quickly as possible.

## Usage

I'll probably package this as a template at some point. For now, grab the code, check the deps are up-to date and then `git init` a fresh repo for your API project.

### Run in development

`env MONGO_URL='mongodb://127.0.0.1/dev' lein repl`

    user=> (go)
    ... some logging...
    :initiated
    
Then you can def things like mongo via the system map, which can be used to call methods that require a connection:

    user=> (ns bifrost-alpha.db.workflow)
    ;; => nil

    bifrost-alpha.db.workflow=> (def mongodb (:adapter/mongo integrant.repl.state/system))
    ;; => '#mongodb

    bifrost-alpha.db.workflow=> (count (get-by-id mongodb "http://coop.co.uk/def/workflow/ambient-date-code-checks/5a3a7d628350cc44e447597b"))    

Hit the configured port in `config.edn` in your browser and the app should be running.

### Production

Some more work needs to happen to make this reusable for production. I'll look at this ASAP.

### Heroku

Can be easily deployed to Heroku with these steps:

FIXME

### Run the application locally

`lein ring server`

### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/server.jar
```

### Packaging as war

`lein ring uberwar`

## License

Copyright ©  FIXME
