package com.brauner.advent.day13;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackageScannerTest {
	@Test
	public void sneakThroughFirewall() throws Exception {
		PackageScanner scanner = new PackageScanner();
		System.out.println("scan: " + scanner.sneakThroughFirewall("src/test/resources/firewallTest.txt"));

		scanner = new PackageScanner();
		System.out.println("scan: " + scanner.sneakThroughFirewall("src/test/resources/firewall.txt"));

	}

	@Test
	public void sneakThroughFirewallWithoutBeingCaught() throws Exception {
		PackageScanner scanner = new PackageScanner();
		System.out.println("delay: " + scanner.sneakThroughFirewallWithoutBeingCaught("src/test/resources/firewallTest.txt"));

		scanner = new PackageScanner();
		System.out.println("delay: " + scanner.sneakThroughFirewallWithoutBeingCaught("src/test/resources/firewall.txt"));

	}

}