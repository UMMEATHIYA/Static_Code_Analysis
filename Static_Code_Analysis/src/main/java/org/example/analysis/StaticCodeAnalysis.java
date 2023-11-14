package org.example.analysis;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;
import net.sourceforge.pmd.renderers.CSVRenderer;
import net.sourceforge.pmd.renderers.Renderer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StaticCodeAnalysis {
    public static void analyzeAndGenerateReport(String sourceDirectory, String csvReportFilePath, String rulesetFilePath) {
        PMDConfiguration pmdConfiguration = new PMDConfiguration();
        pmdConfiguration.setInputPaths(sourceDirectory);
        pmdConfiguration.setRuleSets(rulesetFilePath);

        try (Writer writer = new FileWriter(csvReportFilePath)) {
            Renderer renderer = new CSVRenderer();
            renderer.setWriter(writer);
            PMD.doPMD(pmdConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

