package com.raviteja.voting.service;

import com.raviteja.voting.dao.VotingDAO;
import com.raviteja.voting.model.Candidate;

public class VotingService {

    VotingDAO dao = new VotingDAO();

    public void addCandidate(Candidate candidate) {
        dao.addCandidate(candidate);
    }

    public void viewCandidates() {
        dao.viewCandidates();
    }

    public void searchCandidate(int candidateId) {
        dao.searchCandidate(candidateId);
    }

    public void updateCandidate(int candidateId, String partyName) {
        dao.updateCandidate(candidateId, partyName);
    }

    public void deleteCandidate(int candidateId) {
        dao.deleteCandidate(candidateId);
    }

    public void castVote(int voteId, String voterName, int candidateId) {
        dao.castVote(voteId, voterName, candidateId);
    }

    public void viewVotes() {
        dao.viewVotes();
    }

    public void electionResult() {
        dao.electionResult();
    }
}