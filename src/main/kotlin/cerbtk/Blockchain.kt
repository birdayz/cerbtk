// (c) 2018 infinimesh, Inc
// www.infinimesh.io
//
// (c) 2018 Adrian Marszałek
//
// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package cerbtk

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0, "0", "Genesis block", 0))
    }

    fun mineBlock(data: Any): Block {
        val proofOfWork = generateProofOfWork(latestBlock.proofOfWork)
        val block = Block(chain.size, latestBlock.hash, data, proofOfWork)

        addNewBlock(block)

        return latestBlock
    }

    private fun addNewBlock(block: Block) {
        if (isNewBlockValid(block)) chain.add(block)
    }

    private fun generateProofOfWork(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 8 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }

    private fun isNewBlockValid(newBlock: Block): Boolean =
            ((newBlock.index == latestBlock.index + 1) || (newBlock.previousHash == latestBlock.hash))

}
