package com.cvent.maven;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import java.io.File;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.model.common.ValidationResult;

/**
 * Goal which validates a RAML file
 * @goal validate-raml
 * @phase process-sources
 */
public class RAMLValidator extends AbstractMojo {
    /**
     * Location of the file.
     * @parameter
     * @required
     */
    private File ramlFile;

    /**
     * Runs the validations
     * @throws MojoExecutionException
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD")
    public void execute() throws MojoExecutionException {

        File f = ramlFile;

        RamlModelResult ramlModelResult = new RamlModelBuilder().buildApi(f);
        if (ramlModelResult.hasErrors()) {
            for (ValidationResult validationResult : ramlModelResult.getValidationResults()) {
                getLog().info("RAML validation error: " + validationResult.getMessage());
            }
            throw new MojoExecutionException("RAML validation failed!");
        } else {
            getLog().info("RAML validation succeeded!");
        }
    }
}
