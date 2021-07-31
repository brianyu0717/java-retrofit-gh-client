# retrofit library example

Using the Retrofit library to call the Cat facts API

## Notes

* ```CatFactsService``` uses the  retrofit interface ```CatFactsRetrofit``` to make the HTTP calls.
* ```RetrofitFactory``` builds a ```Retrofit``` with the baseUrl and Jackson
* ```Main``` uses the ```RetrofitFactory``` to build a ```CatFactsService```
* The data model is segregated between the internal use (Fact) and Retrofit use (FactDTO)
