/*
 * Copyright 2013 Google Inc.
 * Copyright 2015 Andreas Schildbach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.*;
import org.bitcoinj.quorums.LLMQParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;

import static com.google.common.base.Preconditions.*;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends AbstractBitcoinNetParams {
    private static final Logger log = LoggerFactory.getLogger(MainNetParams.class);

    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public static final int MAINNET_MAJORITY_DIP0001_WINDOW = 4032;
    public static final int MAINNET_MAJORITY_DIP0001_THRESHOLD = 3226;

    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.proofOfWorkLimit;
        dumpedPrivateKeyHeader = 204;
        addressHeader = CoinDefinition.AddressHeader;
        p2shHeader = CoinDefinition.p2shHeader;
        port = CoinDefinition.Port;
        packetMagic = CoinDefinition.PacketMagic;
        bip32HeaderP2PKHpub = 0x0488b21e; // The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderP2PKHpriv = 0x0488ade4; // The 4 byte header that serializes in base58 to "xprv"
        genesisBlock.setDifficultyTarget(CoinDefinition.genesisBlockDifficultyTarget);
        genesisBlock.setTime(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.genesisBlockNonce);

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        id = ID_MAINNET;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        spendableCoinbaseDepth = CoinDefinition.spendableCoinbaseDepth;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals(CoinDefinition.genesisHash), genesisHash);

        //CoinDefinition.initCheckpoints(checkpoints);

        dnsSeeds = new String[] {
                "dnsseed.lifetioncoin.org"
        };

        httpSeeds = null; /*new HttpDiscovery.Details[] {*/

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(  1500, Sha256Hash.wrap("0000002a6f470ca3366e844d7a55e63fe3ba28d006cec784275431af8cad9c02"));
        checkpoints.put(  4991, Sha256Hash.wrap("00000117d23d6fb1ce93f9a8b8052e6c164e7a2861f69f23dbaf875dde509a61"));
        checkpoints.put(  9918, Sha256Hash.wrap("0000001ce91e8d96e99f138b5f9fcb44d67e143640eb16e78d95fc46691c9c0b"));
        checkpoints.put( 16912, Sha256Hash.wrap("00000007c57814944052853ae415c4232ca63b803e95f82ebec41108262bfdd1"));
        checkpoints.put( 23912, Sha256Hash.wrap("00000001c424070a9784ff5d472646d627d01881e6ee4552df5b3c33af3b93ef"));
        checkpoints.put( 35457, Sha256Hash.wrap("0000002ea1c6f97888c04467e0ed356da6242d7414529fd2866874b24f3c1154"));
        checkpoints.put( 45479, Sha256Hash.wrap("00000018d9cdd60e3e828ba3f1331531457b233cd5e1b55705358c3ece514157"));
        checkpoints.put( 55895, Sha256Hash.wrap("0000006049e6c27c717b432120ebff1c48f01574f017d68b3fa5082286f6c767"));
        checkpoints.put( 68899, Sha256Hash.wrap("0000004ae9a077acbfa7af80200a0878b73dec850257d9c23b57f83c827160a3"));
        checkpoints.put( 74619, Sha256Hash.wrap("000000699bbcb2a7d36432ff162e4177ab488c4bae76be9d7a2eb27be72f5997"));
        checkpoints.put( 75095, Sha256Hash.wrap("0000000dfe2cfe4edfe8564fa6e82e84ddf68db52996197924c548a0e3787011"));
        checkpoints.put( 88805, Sha256Hash.wrap("000001299cfbdb8eae7b1116a7e3adf160a118b6dfed427276f6e8e86f07f9c8"));
        checkpoints.put(107996, Sha256Hash.wrap("0000000a47c458279eb39e1a8f3c440d50e2217daa2cf913f0d8e9149892cd55"));
        checkpoints.put(137993, Sha256Hash.wrap("0000006a61b466674df435eb383b7169e51ea1cbf9d52f80dc8791555ae92ddb"));
        checkpoints.put(167996, Sha256Hash.wrap("0000000549cb95e21e8f8bf9949175b1be6e9697653e2673aaad6fd582287ad1"));
        checkpoints.put(207992, Sha256Hash.wrap("000000aa83b270d6f354d3801f6c8662bfd467e44df20b3748cd6baab71798c0"));

        addrSeeds = new int[] {
                0xd161874e,
                0xb23e1bf9,
                0xd161bfab,
                0x5f6fe300,
                0x5f6fe31f,
                0xd17e0217
        };

        strSporkAddress = "LfjEaScKx3wxmiksQ5QiQpxxUd6ueGETUu";
        budgetPaymentsStartBlock = 328008;
        budgetPaymentsCycleBlocks = 16616;
        budgetPaymentsWindowBlocks = 100;

        DIP0001Window = MAINNET_MAJORITY_DIP0001_WINDOW;
        DIP0001Upgrade = MAINNET_MAJORITY_DIP0001_THRESHOLD;
        DIP0001BlockHeight = 782208;

        fulfilledRequestExpireTime = 60*60;
        masternodeMinimumConfirmations = 15;
        superblockStartBlock = 614820;
        superblockCycle = 16616;
        nGovernanceMinQuorum = 10;
        nGovernanceFilterElements = 20000;

        powDGWHeight = 34140;
        powKGWHeight = 15200;
        powAllowMinimumDifficulty = false;
        powNoRetargeting = false;

        instantSendConfirmationsRequired = 6;
        instantSendKeepLock = 24;

        DIP0003BlockHeight = 1028160;
        deterministicMasternodesEnabledHeight = 1047200;
        deterministicMasternodesEnabled = true;

        DIP0008BlockHeight = 1088640;

        // long living quorum params
        llmqs = new HashMap<LLMQParameters.LLMQType, LLMQParameters>(3);
        llmqs.put(LLMQParameters.LLMQType.LLMQ_50_60, LLMQParameters.llmq50_60);
        llmqs.put(LLMQParameters.LLMQType.LLMQ_400_60, LLMQParameters.llmq400_60);
        llmqs.put(LLMQParameters.LLMQType.LLMQ_400_85, LLMQParameters.llmq400_85);
        llmqChainLocks = LLMQParameters.LLMQType.LLMQ_400_60;
        llmqForInstantSend = LLMQParameters.LLMQType.LLMQ_50_60;

        BIP65Height = 619382; // 00000000000076d8fcea02ec0963de4abfd01e771fec0863f960c2c64fe6f357

        coinType = 5;
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }

    @Override
    protected void verifyDifficulty(StoredBlock storedPrev, Block nextBlock, BigInteger newTarget) {

        long newTargetCompact = calculateNextDifficulty(storedPrev, nextBlock, newTarget);
        long receivedTargetCompact = nextBlock.getDifficultyTarget();
        int height = storedPrev.getHeight() + 1;

        if (/*height >= powDGWHeight &&*/ height <= 68589) {
            double n1 = convertBitsToDouble(receivedTargetCompact);
            double n2 = convertBitsToDouble(newTargetCompact);

            if (java.lang.Math.abs(n1 - n2) > n1 * 0.5 )
                throw new VerificationException("Network provided difficulty bits do not match what was calculated: " + Long.toHexString(newTargetCompact) + " vs " + Long.toHexString(receivedTargetCompact));
        } else {
            if (newTargetCompact != receivedTargetCompact)
                throw new VerificationException("Network provided difficulty bits do not match what was calculated: " + Long.toHexString(newTargetCompact) + " vs " + Long.toHexString(receivedTargetCompact));
        }
    }

    static double convertBitsToDouble(long nBits) {
        long nShift = (nBits >> 24) & 0xff;

        double dDiff =
                (double)0x0000ffff / (double)(nBits & 0x00ffffff);

        while (nShift < 29)
        {
            dDiff *= 256.0;
            nShift++;
        }
        while (nShift > 29)
        {
            dDiff /= 256.0;
            nShift--;
        }

        return dDiff;
    }
}
