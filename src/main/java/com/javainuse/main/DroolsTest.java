package com.javainuse.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.javainuse.engine.RuleFactory;
import com.javainuse.gui.MainFrame;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.StatefulSession;
import org.drools.core.WorkingMemory;

public class DroolsTest {

	public static void main(String[] args) throws Exception {
//		DroolsTest droolsTest = new DroolsTest();
//		droolsTest.executeDrools();

		final RuleFactory ruleFactory = new RuleFactory();
		final StatefulSession session = ruleFactory.getStatefulSession(ruleFactory.createRuleBase(ruleFactory.createPackage()));
		final MainFrame mainFrame = new MainFrame(session);

	}

//	public void executeDrools() throws DroolsParserException, IOException {
//
//		PackageBuilder packageBuilder = new PackageBuilder();
//
//		String ruleFile = "/com/rule/Rules.drl";
//		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
//
//		Reader reader = new InputStreamReader(resourceAsStream);
//		packageBuilder.addPackageFromDrl(reader);
//		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
//		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
//		ruleBase.addPackage(rulesPackage);
//
//		WorkingMemory workingMemory = ruleBase.newStatefulSession();
//
//		Product product = new Product();
//		product.setType("diamond");
//
//		workingMemory.insert(product);
//		workingMemory.fireAllRules();
//
//		System.out.println("The discount for the product " + product.getType()
//				+ " is " + product.getDiscount());
//	}



}
