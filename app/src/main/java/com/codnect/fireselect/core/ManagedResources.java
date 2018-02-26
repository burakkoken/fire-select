package com.codnect.fireselect.core;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Burak Koken on 25.2.2018.
 *
 * @author Burak Koken
 */
public class ManagedResources {

    private LinkedHashSet<Class> annotatedClasses;
    private LinkedHashSet<String> annotatedPackages;

    public ManagedResources(MetadataSources metadataSources){
        annotatedClasses = new LinkedHashSet<>();
        annotatedPackages = new LinkedHashSet<>();
        annotatedClasses.addAll(metadataSources.getAnnotatedClasses());
        annotatedPackages.addAll(metadataSources.getAnnotatedPackages());
    }

    /**
     * Get the annotated classes set.
     *
     * @return annotated classes set
     */
    public Set<Class> getAnnotatedClasses() {
        return annotatedClasses;
    }

    /**
     * Add the class containing annotations to read its metadata.
     *
     * @param annotatedClass The class containing annotations
     */
    public void addAnnotatedClass(Class annotatedClass) {
        annotatedClasses.add(annotatedClass);
    }

    /**
     * Get the annotated packages set.
     *
     * @return annotated packages set
     */
    public Set<String> getAnnotatedPackages() {
        return annotatedPackages;
    }

    /**
     * Add the package name to read the metadata of the classes
     * containing annotations in the java package.
     *
     * @param packageName Java package name
     */
    public void addAnnotatedPackage(String packageName) {
        annotatedPackages.add(packageName);
    }

}
