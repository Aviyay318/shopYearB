package org.example.shopyearb.Response;

public class MentorResponse {
    private boolean accepted;

    public MentorResponse(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
