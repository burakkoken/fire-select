package com.codnect.fireselect.core;

/**
 * Created by Burak Koken on 25.2.2018.
 *
 * @author Burak Koken
 */
public class MetadataContext {

    private MetadataCollector metadataCollector;

    public MetadataContext() {
        metadataCollector = new MetadataCollector();
    }

    /**
     *
     * @return
     */
    public MetadataCollector getMetadataCollector() {
        return metadataCollector;
    }

    /**
     *
     * @param metadataCollector
     */
    public void setMetadataCollector(MetadataCollector metadataCollector) {
        this.metadataCollector = metadataCollector;
    }
}
