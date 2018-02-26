package com.codnect.fireselect.core;

import com.codnect.fireselect.scan.PackageMetadataScanner;

/**
 * Helps to create the metadata from the metadata sources.
 *
 * Created by Burak Koken on 24.2.2018.
 *
 * @author Burak Koken
 */
public class MetadataBuilder {

    private final MetadataSources metadataSources;

    public MetadataBuilder(MetadataSources metadataSources) {
        this.metadataSources = metadataSources;
    }

    /**
     * Create metadata from the metadata sources.
     */
    public void build(){
        MetadataContext metadataContext = new MetadataContext();
        /* prepare managed resources */
        ManagedResources managedResources = prepareManagedResources();
        /* process the metadata */
        MetadataSourceProcessor processor = new AnnotationMetadataProcessor(metadataContext, managedResources);
        processor.prepare();
        processor.process();
    }

    /**
     * Prepare managed resources to create metadata.
     *
     * @return managed resources
     */
    private ManagedResources prepareManagedResources(){
        ManagedResources managedResources = new ManagedResources(metadataSources);
        PackageMetadataScanner.scan(managedResources);
        return managedResources;
    }

}
