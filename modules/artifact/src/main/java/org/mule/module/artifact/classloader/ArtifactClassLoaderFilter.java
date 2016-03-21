/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.artifact.classloader;

import static org.mule.util.Preconditions.checkArgument;
import org.mule.module.artifact.descriptor.ArtifactDescriptor;

import java.util.Collections;
import java.util.Set;

/**
 * Filters classes and resources using a {@link ArtifactDescriptor} describing
 * exported/blocked names.
 * <p>
 * An exact blocked/exported name match has precedence over a prefix match
 * on a blocked/exported prefix. This enables to export classes or
 * subpackages from a blocked package.
 * </p>
 */
public class ArtifactClassLoaderFilter implements ClassLoaderFilter
{

    public static final ArtifactClassLoaderFilter NULL_CLASSLOADER_FILTER = new ArtifactClassLoaderFilter(Collections.EMPTY_SET, Collections.EMPTY_SET);

    public static final String EXPORTED_CLASS_PACKAGES_PROPERTY = "artifact.export.classPackages";
    public static final String EXPORTED_RESOURCE_PACKAGES_PROPERTY = "artifact.export.resourcePackages";

    private static final char PACKAGE_SEPARATOR = '.';
    private static final String EMPTY_PACKAGE = "";
    private static final char RESOURCE_SEPARATOR = '/';

    private final Set<String> exportedClassPackages;
    private final Set<String> exportedResourcePackages;

    /**
     * Creates a new classLoader filter
     *
     * @param exportedClassPackages class package names to export. Can be empty
     * @param exportedResourcePackages resource package names to export. Can be empty
     */
    public ArtifactClassLoaderFilter(Set<String> exportedClassPackages, Set<String> exportedResourcePackages)
    {
        checkArgument(exportedClassPackages != null, "Exported class packages cannot be null");
        checkArgument(exportedResourcePackages!= null, "Exported resource packages cannot be null");

        this.exportedClassPackages = exportedClassPackages;
        this.exportedResourcePackages = exportedResourcePackages;
    }

    @Override
    public boolean exportsClass(String className)
    {
        final String packageName = getPackageName(className);

        return exportedClassPackages.contains(packageName);
    }

    @Override
    public boolean exportsResource(String name)
    {
        final String resourcePackage = getResourceFolder(name);

        return exportedResourcePackages.contains(resourcePackage);
    }

    private String getResourceFolder(String resourceName)
    {
        if (resourceName == null)
        {
            return EMPTY_PACKAGE;
        }
        else
        {
            String pkgName = (resourceName.charAt(0) == RESOURCE_SEPARATOR) ? resourceName.substring(1) : resourceName;
            pkgName = (pkgName.lastIndexOf(RESOURCE_SEPARATOR) < 0) ? EMPTY_PACKAGE : pkgName.substring(0, pkgName.lastIndexOf(RESOURCE_SEPARATOR));
            return pkgName;
        }
    }

    private String getPackageName(String className)
    {
        if (className == null)
        {
            return EMPTY_PACKAGE;
        }
        else
        {
            return (className.lastIndexOf(PACKAGE_SEPARATOR) < 0) ? EMPTY_PACKAGE : className.substring(0, className.lastIndexOf('.'));
        }
    }
}
