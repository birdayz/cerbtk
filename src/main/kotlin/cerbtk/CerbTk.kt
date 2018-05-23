package cerbtk

import io.javalin.Javalin

val cerbtk = Blockchain

fun main(args: Array<String>) {
    val app = Javalin.start(23230)
    app.get("/blocks") { ctx ->
        ctx.json(cerbtk.chain)
    }
    app.post("/blocks/write") { ctx ->
        val minedBlock = cerbtk.mineBlock(ctx.body())
        ctx.json(minedBlock)
    }
}
