package day6;

/**
 * Created by douglas on 09/12/2017.
 */
public class Bank {

    String blocks;
    int loop;

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        return blocks != null ? blocks.equals(bank.blocks) : bank.blocks == null;
    }

    @Override
    public int hashCode() {
        return blocks != null ? blocks.hashCode() : 0;
    }
}
