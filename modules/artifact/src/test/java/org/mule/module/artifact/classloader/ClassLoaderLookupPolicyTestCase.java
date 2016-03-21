/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.artifact.classloader;

import org.mule.tck.junit4.AbstractMuleTestCase;
import org.mule.tck.size.SmallTest;

@SmallTest
public class ClassLoaderLookupPolicyTestCase extends AbstractMuleTestCase
{

    /*
    //@Test
    //public void isBlockedFQClassName() throws Exception
    //{
    //    final ClassLoaderLookupPolicy lookupPolicy = new ClassLoaderLookupPolicy(Collections.emptySet(), Collections.singleton("org.mycompany.MyClass"));
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null, null, lookupPolicy);
    //    assertTrue(classLoader.isBlocked("org.mycompany.MyClass"));
    //    assertFalse(classLoader.isBlocked("MyClass"));
    //    assertFalse(classLoader.isBlocked("org.mycompany.MyClassFactory"));
    //}
    //
    //@Test
    //public void isBlockedNotFQClassName() throws Exception
    //{
    //    Set<String> overrides = new HashSet<>(1);
    //    overrides.add("-MyClass");
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null,
    //                                                                                  overrides, null);
    //    assertTrue(classLoader.isBlocked("MyClass"));
    //    assertFalse(classLoader.isBlocked("MyClassFactory"));
    //    assertFalse(classLoader.isBlocked("org.mycompany.MyClass"));
    //}
    //
    //@Test
    //public void isBlockedPackageName() throws Exception
    //{
    //    Set<String> overrides = new HashSet<>(1);
    //    overrides.add("-org.mycompany");
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null,
    //                                                                                  overrides, null);
    //    assertTrue(classLoader.isBlocked("org.mycompany.MyClass"));
    //    assertTrue(classLoader.isBlocked("org.mycompany.somepackage.MyClass"));
    //}
    //
    //@Test
    //public void isOverriddenFQClassName() throws Exception
    //{
    //    Set<String> overrides = new HashSet<>(1);
    //    overrides.add("org.mycompany.MyClass");
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null,
    //                                                                                  overrides, null);
    //    assertTrue(classLoader.isOverridden("org.mycompany.MyClass"));
    //    assertFalse(classLoader.isOverridden("MyClass"));
    //    assertFalse(classLoader.isOverridden("org.mycompany.MyClassFactory"));
    //}
    //
    //@Test
    //public void isOverriddenNotFQClassName() throws Exception
    //{
    //    Set<String> overrides = new HashSet<>(1);
    //    overrides.add("MyClass");
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null,
    //                                                                                  overrides, null);
    //    assertTrue(classLoader.isOverridden("MyClass"));
    //    assertFalse(classLoader.isOverridden("MyClassFactory"));
    //    assertFalse(classLoader.isOverridden("org.mycompany.MyClass"));
    //}
    //
    //@Test
    //public void isOverriddenPackageName() throws Exception
    //{
    //    Set<String> overrides = new HashSet<>(1);
    //    overrides.add("org.mycompany");
    //    FineGrainedControlClassLoader classLoader = new FineGrainedControlClassLoader(new URL[0], null,
    //                                                                                  overrides, null);
    //    assertTrue(classLoader.isOverridden("org.mycompany.MyClass"));
    //    assertTrue(classLoader.isOverridden("org.mycompany.somepackage.MyClass"));
    //}
     */
}