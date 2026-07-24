package com.raviteja.voting.model;

public class Candidate {

    private int candidateId;
    private String candidateName;
    private String partyName;

    public Candidate() {
    }

    public Candidate(int candidateId, String candidateName, String partyName) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyName = partyName;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    @Override
    public String toString() {
        return "Candidate [candidateId=" + candidateId +
                ", candidateName=" + candidateName +
                ", partyName=" + partyName + "]";
    }
}