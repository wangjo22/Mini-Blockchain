package Core;

import Util.Util;

import java.util.ArrayList;

public class Block {
    private int blockID;
    private int nonce;
    private String previousBlockHash;
    private ArrayList<Transaction> transactionList;

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public ArrayList getTransactionList() {
        return transactionList;
    }

    public Block(int blockID, int nonce, String previousBlockHash, ArrayList transactionList) {
        this.blockID = blockID;
        this.nonce = nonce;
        this.previousBlockHash = previousBlockHash;
        this.transactionList = transactionList;
    }

    public void setTransactionList(ArrayList transactionList) {
        this.transactionList = transactionList;
    }

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }


    public void getInformation() {
        System.out.println("---------------------------------------------");
        System.out.println("Block Number: " + this.getBlockID());
        System.out.println("Block Nonce: " + this.getNonce());
        System.out.println("Transaction size: " + this.getTransactionList().size());
        for(Transaction tran : this.transactionList) {
            tran.getInformation();
        }
        System.out.println("Previous Block Hash: " + this.getPreviousBlockHash());
        System.out.println("Block Hash: " + this.getBlockHash());
        System.out.println("---------------------------------------------");
    }


    public String getBlockHash() {
        String transactionInformatioins = "";
        for(Transaction tr : this.transactionList) {
            transactionInformatioins += tr.getInformation();
        }
        return Util.getHash(this.nonce + transactionInformatioins + this.previousBlockHash);
    }

    public void mine() {
        while(true) {
            if(getBlockHash().substring(0, 4).equals("0000")) {
                System.out.println(blockID + " block is mined successfully");
                break;
            }
            nonce++;
        }
    }
}
