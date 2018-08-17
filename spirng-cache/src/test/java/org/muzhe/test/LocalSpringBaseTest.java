package org.muzhe.test;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author muzhe-wang on 18/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-cachetest.xml")
@ActiveProfiles("development")
public abstract class LocalSpringBaseTest extends TestCase {

}
