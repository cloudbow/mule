/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.api.metadata;

import org.mule.api.metadata.descriptor.OperationMetadataDescriptor;
import org.mule.extension.api.annotation.param.metadata.Content;
import org.mule.extension.api.metadata.MetadataResolver;
import org.mule.extension.api.metadata.MetadataResolvingException;
import org.mule.metadata.api.model.MetadataType;

import java.util.List;

/**
 * Provides access to the Processor's Metadata resolving methods.
 */
public interface MetadataAware
{

    /**
     * Returns the list of types that can be described, by the {@link org.mule.extension.api.metadata.MetadataResolver}
     * associated to this Processor
     *
     * @return Successful {@link Result} if the keys are successfully resolved
     * Failure {@link Result} if there is an error while retrieving the keys
     * @throws MetadataResolvingException
     */
    Result<List<MetadataKey>> getMetadataKeys() throws MetadataResolvingException;

    /**
     * Given a {@link MetadataKey} resolves the {@link MetadataType} of the {@link Content}
     * parameter using the {@link MetadataResolver} associated to the current processor.
     *
     * @param key the {@link MetadataKey} of the type which's structure has to be resolved
     * @return the {@link MetadataType} of the {@link Content} parameter
     * @throws MetadataResolvingException
     */
    Result<MetadataType> getContentMetadata(MetadataKey key) throws MetadataResolvingException;

    /**
     * Given a {@link MetadataKey} resolves the {@link MetadataType} of the Processors's output
     * using the {@link MetadataResolver} associated to the current processor.
     *
     * @param key {@link MetadataKey} of the type which's structure has to be resolved
     * @return the {@link MetadataType} of the output
     * @throws MetadataResolvingException
     */
    Result<MetadataType> getOutputMetadata(MetadataKey key) throws MetadataResolvingException;

    /**
     * Resolves the {@link OperationMetadataDescriptor} for the current operation using
     * only the Static Java types of the Processor's parameters, attributes and output.
     *
     * @return An {@link OperationMetadataDescriptor} with the Static Metadata representation
     * of the Processor.
     * Successful {@link Result} if the Metadata is successfully retrieved
     * Failure {@link Result} when the Metadata retrieval of any element fails for any reason
     * @throws MetadataResolvingException
     */
    Result<OperationMetadataDescriptor> getMetadata() throws MetadataResolvingException;

    /**
     * Resolves the {@link OperationMetadataDescriptor} for the current processor using
     * Static and Dynamic resolving of the Processor's parameters, attributes and output.
     * <p>
     * If {@link Content} or Output of the operation have a {@link MetadataResolver} associated
     * that can be used to resolve the Dynamic MetadataTypes, then the {@link OperationMetadataDescriptor}
     * will contain those Dynamic types instead of the Static Java type declaration.
     * <p>
     * When neither {@link Content} nor Output have Dynamic types, then invoking this method is the
     * same as invoking {@link this#getMetadata()}
     *
     * @param key {@link MetadataKey} of the type which's structure has to be resolved,
     *            used both for input and ouput types
     *            Successful {@link Result} if the Metadata is successfully retrieved
     *            Failure {@link Result} when the Metadata retrieval of any element fails for any reason
     * @throws MetadataResolvingException
     */
    Result<OperationMetadataDescriptor> getMetadata(MetadataKey key) throws MetadataResolvingException;
}

