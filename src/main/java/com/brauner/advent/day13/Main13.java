package com.brauner.advent.day13;

import java.io.IOException;

/**
 * Created by douglas on 13/12/2017.
 */
public class Main13 {

    public static void main(String[] args) {
        PackageScanner scanner = new PackageScanner();
        try {
            System.out.println("delay: " + scanner.sneakThroughFirewallWithoutBeingCaught("src/test/resources/firewall.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
