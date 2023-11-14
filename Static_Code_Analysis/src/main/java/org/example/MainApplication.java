package org.example;


import org.eclipse.jgit.api.errors.GitAPIException;
import org.example.analysis.StaticCodeAnalysis;
import org.example.git.GitHandler;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the GitHub repository URL: ");
        String repositoryUrl = scanner.nextLine();

        System.out.print("Enter the local path to clone the repository: ");
        String localPath = scanner.nextLine();

        System.out.print("Enter the path to the CSV report file: ");
        String csvReportFilePath = scanner.nextLine();

        //System.out.print("Enter the path to the PMD ruleset file: ");
        //String rulesetFilePath = scanner.nextLine();
        // Hardcoded ruleset file path
        String rulesetFilePath = "C:\\Users\\ummea\\OneDrive\\Documents\\Wahid - OOPs\\Implementation_Project\\Static_Code_Analysis\\custom-ruleset.xml";

        try {
            // Clone GitHub repository
            GitHandler.cloneRepository(repositoryUrl, localPath);

            // Run PMD analysis and generate CSV report
            StaticCodeAnalysis.analyzeAndGenerateReport(localPath + "/src", csvReportFilePath, rulesetFilePath);

            System.out.println("PMD analysis and report generation completed successfully.");
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }
}

