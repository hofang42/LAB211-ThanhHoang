/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Menu;
import java.util.List;
import Model.Candidate;
import Model.CandidateList;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import Utils.Validation;

/**
 *
 * @author hoang
 */
public class CandidateManagement extends Menu {

    private CandidateList candidateList;
    private Validation val;

    public CandidateManagement() {
        super("CANDIDATE MANAGEMENT SYSTEM", new String[]{"Experience", "Fresher", "Intern", "Search", "Exit"});
        candidateList = new CandidateList();
        val = new Validation();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createExperience();
                break;
            case 2:
                createFresher();
                break;
            case 3:
                createIntern();
                break;
            case 4:
                searchCandidate();
                break;
            case 5:
                exitMenu();
                break;
        }
    }

    public void createExperience() {
        Candidate c = val.getCandidate();
        c.setType(1);
        String expYear = val.getString("Enter experience year");
        while(!val.validYearOfExperience(expYear)) {
            expYear = val.getString("Enter valid year of experience");
        }
        String proSkill = val.getString("Enter professional skill");
        Experience e = new Experience(expYear, proSkill, c);
        candidateList.createExperience(e);
        
    }

    public void createFresher() {
        Candidate c = val.getCandidate();
        c.setType(2);
        String graduatedTime = val.getString("Enter graduatet time");
        System.out.print("Education Rank\n1. Excellence\n2. Good\n3. Fair\n4. Poor\nEnter graduation rank: ");
        int graduationRankInt = val.checkInputIntLimit(1, 4);
        String graduationRankStr = "";
        if (graduationRankInt == 1) graduationRankStr = "Excellence";
        if (graduationRankInt == 2) graduationRankStr = "Good";
        if (graduationRankInt == 3) graduationRankStr = "Fair";
        if (graduationRankInt == 4) graduationRankStr = "Poor";
        String universityName = val.getString("Enter university name");
        Fresher f = new Fresher(graduatedTime, graduationRankStr, universityName, c);
        candidateList.createFresher(f);
    }

    public void createIntern() {
        Candidate c = val.getCandidate();
        c.setType(3);
        String major = val.getString("Enter major");
        int semester = val.getInt("Enter semester");
        String universityName = val.getString("Enter university name");

        Intern i = new Intern(major, semester, universityName, c);
        candidateList.createIntern(i);
    }

    public void searchCandidate() {
        printCandidateList();
        String keyword = val.getString("Input Candidate name (First name or Last name)");
        System.out.print("1. Experience\n2. Fresher\n3. Intern\nEnter type of candidate: ");
        int type = val.checkInputIntLimit(1, 3);
        System.out.println("The candidates found: ");
        printCandidateSearch(candidateList.search(p -> p.checkCandidateExist(keyword, type)));
    }

    public void printCandidateList() {
        System.out.println("List of candidate");
        System.out.println("=============EXPERIENCE CANDIDATE=============");
        printCandidateSearch(candidateList.getCandidateByType(1));
        System.out.println("=============FRESHER CANDIDATE================");
        printCandidateSearch(candidateList.getCandidateByType(2));
        System.out.println("=============INTERN CANDIDATE=================");
        printCandidateSearch(candidateList.getCandidateByType(3));
    }

    public void printCandidateSearch(List<Candidate> cs) {
        for (Candidate c : cs) {
            System.out.println(c);
        }
    }

}
