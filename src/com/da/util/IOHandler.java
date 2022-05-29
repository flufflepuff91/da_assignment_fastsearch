/*
 * Project: Assignment 4 Datastructures and Algorithms Stack
 * Author:  Anonym
 * Last Change:01.01.2022
 */

package com.da.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


/**
 * Class that handles all necessary input/output operations.
 *
 * Recommendation: Do not change this.
 *
 * @author Koitz-Hristov
 */
public class IOHandler {
    /**
     * Reads the input file and parses it such the line containing the input is returned as a String array.
     *
     * @param filename the input file.
     * @return input as a String
     */
    public String [] readInput(String filename) {
        String[] strings = null;
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            line = bufferedReader.readLine();
            strings = line.split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }


    /**
     * Prints the result to an output file that has the same name as the input file but instead of the
     * extension ".in" the extension ".out" and is stored within the "testdata/output" folder.
     *
     * @param result        the result of the task implementation to be stored in an output file.
     * @param inputFilename the name of the input file.
     */
    public void printResultToOutputFile(String result, String inputFilename) {
        String output_filename = inputFilename.replace(".in", ".out");
        output_filename = output_filename.replace("input", "output");
        File outputFile = new File(output_filename);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error: Could not write to file " + outputFile.getAbsolutePath());
            System.exit(-1);
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
