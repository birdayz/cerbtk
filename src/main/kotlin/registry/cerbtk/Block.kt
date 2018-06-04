// (c) 2018 infinimesh, Inc
// www.infinimesh.io
//
// (c) 2018 Adrian Marszałek

package registry.cerbtk

import org.apache.commons.codec.digest.DigestUtils
import java.util.*

class Block(val index: Int,
            val previousHash: String,
            val data: Any,
            val proofOfWork: Int) {

    val hash = calculateHash()
    val timestamp: Long = Date().time

    private fun calculateHash(): String {
        val input = (index.toString() + previousHash + timestamp + data).toByteArray()
        return DigestUtils.sha256Hex(input)
    }
}
