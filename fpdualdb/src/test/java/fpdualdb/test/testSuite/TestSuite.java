package fpdualdb.test.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fpdualdb.test.conector.ConectorTest;
import fpdualdb.test.manager.ActorManagerTest;

@RunWith(Suite.class)
@SuiteClasses({ ConectorTest.class, ActorManagerTest.class })
public class TestSuite {

	
}
