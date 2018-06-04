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

package com.infinimesh.registry.cerbtk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BlockchainTest {

    @Test
    fun `Get latest block, chain initialized, returns genesis block`() {
        val chain = Blockchain
        val latestBlock = chain.latestBlock

        assertEquals(0, latestBlock.index)
        assertEquals("Genesis block", latestBlock.data)
        assertEquals(0, latestBlock.proofOfWork)
    }

    @Test
    fun `Mine block, block added to the chain`() {
        val chain = Blockchain

        val minedBlock = chain.mineBlock("data")

        assertEquals(minedBlock, chain.latestBlock)
    }

    @Test
    fun `Mine block, assert created values`() {
        val chain = Blockchain
        val genesisBlock = chain.latestBlock

        val minedBlock = chain.mineBlock("data")

        val expectedProofOfWork = 8

        assertEquals(genesisBlock.hash, minedBlock.previousHash)
        assertEquals("data", minedBlock.data)
        assertEquals(genesisBlock.index + 1, minedBlock.index)
        assertEquals(expectedProofOfWork, minedBlock.proofOfWork)
        assertNotNull(minedBlock.hash)
        assertNotNull(minedBlock.timestamp)
    }

}
