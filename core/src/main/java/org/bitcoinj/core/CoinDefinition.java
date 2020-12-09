package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {
    public static final String coinName = "LifetionCoin";
    public static final String coinTicker = "LTP";
    public static final String coinURIScheme = "lifetioncoin";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[L]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://explorer.lifetioncoin.org/#/ALL/mainnet/home/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "https://explorer.lifetioncoin.org/#/ALL/testnet/home/";

    public static final String DONATION_ADDRESS = "LfjEaScKx3wxmiksQ5QiQpxxUd6ueGETUu";  //Hash Engineering donation LifetionCoin address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2 * 60);  // 2 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 14000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Dash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70208;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70209;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 7977;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17977;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 76;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 16;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 204;   //common to all coins
    public static final long oldPacketMagic = 0xffdc3ab2;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xffdc3ab2;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1573278185;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (573173);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "0x0000032e8b86e9e24ba26fbf815aa656bc0aea20227a45c5d1d36f5dbc532ed3"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "0xac41ab0badca6b3322e39070218bf0ae93962b690c546b0c6cfa249d6461008a";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "0x4d617962652c20626c6f636b636861696e206973206120746563686e6f6c6f6779206372656174656420627920616c69656e73202d2030392c204e6f76656d6265722032303139";
    static public String genesisTxOutBytes = "040da80760a13218294ecf3ef36e2fbc13e93decb26f381e82ae115de03b6df0a046d0a016c5d953ce7dd8d53c98a2c4f231a985016cde439194333dd15f5820da";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.lifetioncoin.org",
            "dnsseed.cointobanks.com",
    };

    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 127;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xbf0c6bbd;      //
    public static final String testnetGenesisHash = "0x00000166aeca9446019ff5c6a85053e4706680823908397379ff54995821e047";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1577196880;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (573372);                         //main.cpp: LoadBlockIndex

    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.lifetioncoin.org",
            "test.dnsseed.lifetioncoin.org",
    };

    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04f42fbbdaac0a14fca2b01f2313635ff3bfdefb07b585d150708c5bcd49af9d82af66b6027ccc9d0d8e7e4bbe4dfd1f496dd66d2983a1d17c2d74f442b83afc65";
    public static final String TESTNET_SATOSHI_KEY = "041afddc105779e892d578faf7a64f9cfbc7e971cf79fabae97073a3e8f8251114d4cf3e2b27437ee0964e5152c120ca21445199513bb02f551ef0b2769d073e68";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.lifetioncoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.lifetioncoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.lifetioncoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
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
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "LPWsspw9BRbygDqZ2StoKtoes1Ss8xye9b";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XBhbXkQ52uDSJTdzuvFJwtutDQURK5rh4pXARzPJJG5wy8JWNMH8";
}
