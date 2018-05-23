# cerbtk - simple blockchain test
Just to see how a blockchain approach could solve some fundamental issues. Its a badly hack, most work was done by Adrian (see credits).

## API

instance is available at http://localhost:23230
As for now, it offers the following endpoints:
* `GET /blocks` for listing all existing blocks in the chain
* `POST /blocks/write` for mining new block

## Credit

This project uses some open source libraries:
* [Apache Commons Codec](https://github.com/apache/commons-codec)
* [JavaLin](https://javalin.io/)
* [Jackson Module Kotlin](https://github.com/FasterXML/jackson-module-kotlin)
* based on code of [Adrian Marszałek](https://github.com/adikm/kotcoin)
 
