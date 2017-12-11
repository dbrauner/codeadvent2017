package com.brauner.advent.day6;

import java.util.ArrayList;

/**
 * Created by douglas on 09/12/2017.
 */
public class MemoryReallocation {

    /**
     * Redistributes memory across banks
     *
     * @param bankList banks with memory blocks
     * @return cycles to balance before it reaches infinite-loop
     */
    public int balanceBankList(int[] bankList) {
        int loops = 0;

        ArrayList<String> seenBefore = new ArrayList<>();

        while (true) {

            int index = findBiggestBank(bankList);
            int value = bankList[index];
            bankList[index] = 0;

            while (value > 0) {
                index++;
                if (index >= bankList.length)
                    index = 0;
                bankList[index]++;
                value--;
            }
            loops++;
            if (seenBefore.contains(toString(bankList)))
                return loops;
            seenBefore.add(toString(bankList));
        }

    }

    public int balanceBankListWithLoopSize(int[] bankList) {
        int loops = 0;

        ArrayList<Bank> seenBefore = new ArrayList<>();

        while (true) {

            int index = findBiggestBank(bankList);
            int value = bankList[index];
            bankList[index] = 0;

            while (value > 0) {
                index++;
                if (index >= bankList.length)
                    index = 0;
                bankList[index]++;
                value--;
            }
            loops++;
            Bank bank = toBank(bankList);
            bank.setLoop(loops);
            if (seenBefore.contains(bank)) {
                int indexFirstBank = seenBefore.indexOf(bank);
                return bank.getLoop() - seenBefore.get(indexFirstBank).getLoop();
            }

            seenBefore.add(bank);
        }

    }

    private int findBiggestBank(int[] bankList) {
        int biggest = 0;
        int maxValue = 0;

        for (int i = bankList.length - 1; i >= 0 ; i--) {
            if (bankList[i] >=maxValue) {
                biggest = i;
                maxValue = bankList[i];
            }
        }
        return biggest;
    }

    private String toString(int[] bankList) {
        StringBuilder str = new StringBuilder();

        for (int bank : bankList){
            str.append(bank);
        }
        return str.toString();
    }

    private Bank toBank(int[] bankList) {
        Bank bank = new Bank();
        bank.setBlocks(toString(bankList));
        return bank;
    }
}
