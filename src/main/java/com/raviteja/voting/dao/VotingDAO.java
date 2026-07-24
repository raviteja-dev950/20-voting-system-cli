package com.raviteja.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.raviteja.voting.model.Candidate;
import com.raviteja.voting.util.DBConnection;

public class VotingDAO {

	public void addCandidate(Candidate candidate) {

	    String sql = "INSERT INTO CANDIDATES VALUES (?, ?, ?)";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, candidate.getCandidateId());
	        ps.setString(2, candidate.getCandidateName());
	        ps.setString(3, candidate.getPartyName());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Candidate added successfully.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void viewCandidates() {

	    String sql = "SELECT * FROM CANDIDATES";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("\n----- CANDIDATES -----");

	        while (rs.next()) {

	            System.out.println(
	                    rs.getInt("CANDIDATE_ID") + " | " +
	                    rs.getString("CANDIDATE_NAME") + " | " +
	                    rs.getString("PARTY_NAME"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void searchCandidate(int candidateId) {

	    String sql = "SELECT * FROM CANDIDATES WHERE CANDIDATE_ID = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, candidateId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            System.out.println("Candidate ID : " + rs.getInt("CANDIDATE_ID"));
	            System.out.println("Name         : " + rs.getString("CANDIDATE_NAME"));
	            System.out.println("Party        : " + rs.getString("PARTY_NAME"));

	        } else {

	            System.out.println("Candidate not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void updateCandidate(int candidateId, String partyName) {

	    String sql = "UPDATE CANDIDATES SET PARTY_NAME = ? WHERE CANDIDATE_ID = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, partyName);
	        ps.setInt(2, candidateId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Candidate updated successfully.");
	        } else {
	            System.out.println("Candidate not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void deleteCandidate(int candidateId) {

	    String sql = "DELETE FROM CANDIDATES WHERE CANDIDATE_ID = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, candidateId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Candidate deleted successfully.");
	        } else {
	            System.out.println("Candidate not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void castVote(int voteId, String voterName, int candidateId) {

	    String sql = "INSERT INTO VOTES VALUES (?, ?, ?, SYSDATE)";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, voteId);
	        ps.setString(2, voterName);
	        ps.setInt(3, candidateId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Vote cast successfully.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void viewVotes() {

	    String sql = "SELECT * FROM VOTES";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("\n----- VOTES -----");

	        while (rs.next()) {

	            System.out.println(
	                    rs.getInt("VOTE_ID") + " | " +
	                    rs.getString("VOTER_NAME") + " | " +
	                    rs.getInt("CANDIDATE_ID") + " | " +
	                    rs.getDate("VOTE_DATE"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}public void electionResult() {

	    String sql =
	            "SELECT C.CANDIDATE_NAME, C.PARTY_NAME, COUNT(V.VOTE_ID) AS TOTAL_VOTES " +
	            "FROM CANDIDATES C " +
	            "LEFT JOIN VOTES V ON C.CANDIDATE_ID = V.CANDIDATE_ID " +
	            "GROUP BY C.CANDIDATE_NAME, C.PARTY_NAME " +
	            "ORDER BY TOTAL_VOTES DESC";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("\n----- ELECTION RESULT -----");

	        while (rs.next()) {

	            System.out.println(
	                    rs.getString("CANDIDATE_NAME") + " | " +
	                    rs.getString("PARTY_NAME") + " | Votes : " +
	                    rs.getInt("TOTAL_VOTES"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}