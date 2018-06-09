package org.deeplearning4j.base;

public interface BaseFetcherInterface {

    String getName();

    /**
     * get training files
     */
    String getTrainingFilesURL();

    String getTrainingFilesMD5();

    String getTrainingFilesFilename();

    String getTrainingFilesFilename_unzipped();

    String getTrainingFileLabelsURL();

    String getTrainingFileLabelsMD5();

    String getTrainingFileLabelsFilename();

    String getTrainingFileLabelsFilename_unzipped();

    /**
     *
     * get test files
     *
     */
    String getTestFilesURL();

    String getTestFilesMD5();

    String getTestFilesFilename();

    String getTestFilesFilename_unzipped();

    String getTestFileLabelsURL();

    String getTestFileLabelsMD5();

    String getTestFileLabelsFilename();

    String getTestFileLabelsFilename_unzipped();

}
