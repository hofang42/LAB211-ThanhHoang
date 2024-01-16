/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class CandidateList {

    private List<Candidate> candidates;

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public CandidateList() {
        candidates = new ArrayList<>();
    }

    public int size() {
        return candidates.size();
    }

    public void createExperience(Experience e) {
        int id = size() + 1;
        e.setId(id);
        candidates.add(e);
    }

    public void createFresher(Fresher f) {
        int id = size() + 1;
        f.setId(id);
        candidates.add(f);
    }

    public void createIntern(Intern i) {
        int id = size() + 1;
        i.setId(id);
        candidates.add(i);
    }

    public List<Candidate> search(Predicate<Candidate> p) {
        List<Candidate> cs = new ArrayList<>();
        for (Candidate c : candidates) {
            if (p.test(c)) {
                cs.add(c);
            }
        }
        return cs;
    }

    public List<Candidate> getCandidateByType(int type) {
        List<Candidate> cs = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c.getType() == type) {
                cs.add(c);
            }
        }

        return cs;
    }

}
