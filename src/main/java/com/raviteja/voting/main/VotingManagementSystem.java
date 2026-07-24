package com.raviteja.voting.main;

import java.util.Scanner;

import com.raviteja.voting.model.Candidate;
import com.raviteja.voting.service.VotingService;

public class VotingManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VotingService service = new VotingService();

        while (true) {

            System.out.println("\n=============================");
            System.out.println(" Voting System");
            System.out.println("=============================");
            System.out.println("1. Add Candidate");
            System.out.println("2. View Candidates");
            System.out.println("3. Search Candidate");
            System.out.println("4. Update Candidate");
            System.out.println("5. Delete Candidate");
            System.out.println("6. Cast Vote");
            System.out.println("7. View Votes");
            System.out.println("8. Election Result");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Candidate candidate = new Candidate();

                System.out.print("Enter Candidate ID: ");
                candidate.setCandidateId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Candidate Name: ");
                candidate.setCandidateName(sc.nextLine());

                System.out.print("Enter Party Name: ");
                candidate.setPartyName(sc.nextLine());

                service.addCandidate(candidate);
                break;

            case 2:

                service.viewCandidates();
                break;

            case 3:

                System.out.print("Enter Candidate ID: ");
                service.searchCandidate(sc.nextInt());
                break;

            case 4:

                System.out.print("Enter Candidate ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Party Name: ");
                String party = sc.nextLine();

                service.updateCandidate(id, party);
                break;

            case 5:

                System.out.print("Enter Candidate ID: ");
                service.deleteCandidate(sc.nextInt());
                break;

            case 6:

                System.out.print("Enter Vote ID: ");
                int voteId = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Voter Name: ");
                String voter = sc.nextLine();

                System.out.print("Enter Candidate ID: ");
                int candidateId = sc.nextInt();

                service.castVote(voteId, voter, candidateId);
                break;

            case 7:

                service.viewVotes();
                break;

            case 8:

                service.electionResult();
                break;

            case 9:

                System.out.println("Project 20 Done Bye!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice!");
            }
        }
    }
}