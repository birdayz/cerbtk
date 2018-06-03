// (c) 2018 infinimesh, Inc
// www.infinimesh.io
//
// (c) 2018 Adrian Marszałek

package cerbtk
import io.javalin.Javalin

val cerbtk = Blockchain

fun main(args: Array<String>) {
    val app = Javalin.start(23230)
    app.get("/device") { ctx ->
        ctx.json(cerbtk.chain)
    }
    app.post("/device/write") { ctx ->
        val minedBlock = cerbtk.mineBlock(ctx.body())
        ctx.json(minedBlock)
    }
}
