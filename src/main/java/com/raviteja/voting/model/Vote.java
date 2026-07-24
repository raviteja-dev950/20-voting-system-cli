package com.raviteja.voting.model;

import java.sql.Date;

public class Vote {

    private int voteId;
    private String voterName;
    private int candidateId;
    private Date voteDate;

    public Vote() {
    }

    public Vote(int voteId, String voterName, int candidateId, Date voteDate) {
        this.voteId = voteId;
        this.voterName = voterName;
        this.candidateId = candidateId;
        this.voteDate = voteDate;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    @Override
    public String toString() {
        return "Vote [voteId=" + voteId +
                ", voterName=" + voterName +
                ", candidateId=" + candidateId +
                ", voteDate=" + voteDate + "]";
    }
}