package com.javainuse.engine;

import com.javainuse.main.DroolsTest;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.StatefulSession;
import org.drools.core.StatelessSession;
import org.drools.core.rule.Package;

import java.io.*;

// Klasa do ładowania reguł

public class RuleFactory {

    final String ruleFile = "/com/rule/Rules.drl";

    public Package createPackage() throws DroolsParserException, IOException {
        PackageBuilder packageBuilder = new PackageBuilder();
        InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
        return rulesPackage;
//        builder.addPackageFromDrl(source);
//        Package pkg = builder.getPackage();
//        return pkg;
    }

    public RuleBase createRuleBase(Package _package) throws Exception{
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(_package);
        return ruleBase;
    }

    public StatefulSession getStatefulSession(RuleBase ruleBase){
        StatefulSession session = ruleBase.newStatefulSession();
        return session;
    }

    public StatelessSession getStatelessSession(RuleBase ruleBase){
        StatelessSession session = ruleBase.newStatelessSession();
        return session;
    }
}
