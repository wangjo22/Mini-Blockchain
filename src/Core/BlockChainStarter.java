package Core;

import Util.Util;

import java.util.ArrayList;

public class BlockChainStarter {
    public static void main(String[] args) {
        Block block1 = new Block(1, 0, null, new ArrayList());
        block1.mine();
        block1.getInformation();

        Block block2 = new Block(2, 0, block1.getBlockHash(), new ArrayList());
        block2.addTransaction(new Transaction("Youngjo Kim", "Joyce Dong", 1000.0));
        block2.addTransaction(new Transaction("Youngjo Kim", "Peter Dong", 3000.0));
        block2.mine();
        block2.getInformation();

        Block block3 = new Block(3, 0, block2.getBlockHash(), new ArrayList());
        block3.addTransaction(new Transaction("Joycelyn Dong", "Youngjo Kim", 10.0));
        block3.mine();
        block3.getInformation();

        Block block4 = new Block(4, 0, block3.getBlockHash(), new ArrayList());
        block4.addTransaction(new Transaction("Youngjo Kim", "Vera Zhang", 167.0));
        block4.mine();
        block4.getInformation();
    }
}
