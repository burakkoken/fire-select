package com.codnect.fireselect.core;

import android.util.Log;

import com.codnect.fireselect.annotation.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Process the annotation metadata.
 *
 * Created by Burak Koken on 25.2.2018.
 *
 * @author Burak Koken
 */
public class AnnotationMetadataProcessor implements MetadataSourceProcessor{

    private static final String LOG_TAG = AnnotationMetadataProcessor.class.getSimpleName();

    private MetadataContext metadataContext;
    private ManagedResources managedResources;
    private List<Class> categorizedClasses;
    private Set<String> processedModelNames;

    public AnnotationMetadataProcessor(MetadataContext metadataContext, ManagedResources managedResources){
        this.metadataContext = metadataContext;
        this.managedResources = managedResources;
        categorizedClasses = new ArrayList<>();
        processedModelNames = new HashSet<>();
    }

    /**
     * Prepare the sources to create metadata from the annotation
     * metadata.
     */
    @Override
    public void prepare() {

        /* categorize all annotated classes */
        for(Class annotatedClass : managedResources.getAnnotatedClasses()) {
            categorizeAnnotatedClass(annotatedClass);
        }

    }

    /**
     * Process the annotations of the annotated classes.
     */
    @Override
    public void process() {

    }

    /**
     * Categorize the specified annotated class.
     *
     * @param annotatedClass annotated class
     */
    private void categorizeAnnotatedClass(Class annotatedClass){

        if(annotatedClass.isAnnotationPresent(Model.class)) {
            categorizedClasses.add(annotatedClass);
        } else {
            Log.w(LOG_TAG, "Encountered a non-categorized annotated class [" + annotatedClass.getName() +"]");
        }

    }

}
