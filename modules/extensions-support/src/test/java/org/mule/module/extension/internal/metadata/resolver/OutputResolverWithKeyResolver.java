/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension.internal.metadata.resolver;

import org.mule.api.metadata.MetadataKey;
import org.mule.extension.api.metadata.MetadataContext;
import org.mule.extension.api.metadata.MetadataResolver;
import org.mule.metadata.api.model.MetadataType;
import org.mule.module.extension.internal.metadata.MetadataService;

import java.util.List;

public class OutputResolverWithKeyResolver implements MetadataResolver
{

    @Override
    public List<MetadataKey> getMetadataKeys(MetadataContext context)
    {
        return MetadataService.getKeys(context);
    }

    @Override
    public MetadataType getOutputMetadata(MetadataContext context, MetadataKey key)
    {
        return MetadataService.getMetadata(key);
    }
}
