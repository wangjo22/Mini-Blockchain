package Core;

import Util.Util;

public class BlockChainStarter {
    public static void main(String[] args) {
        System.out.println(Util.getHash("Youngjo Kim"));

        int nonce = 0;
        while(true) {
            if(Util.getHash(nonce + "").substring(0, 6).equals("111111")) {
                System.out.println("Answer: " + nonce);
                System.out.println("Hash: " + Util.getHash(nonce + ""));
                break;
            }
            ++nonce;
        }
    }
}
