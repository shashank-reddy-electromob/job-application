package org.electromob.jobapplications;

public class job_update_class {

    public String jobstring,laststring,vacancystringl;

    public job_update_class() {
    }

    public job_update_class(String jobstring, String laststring, String vacancystringl) {
        this.jobstring = jobstring;
        this.laststring = laststring;
        this.vacancystringl = vacancystringl;
    }

    public String getJobstring() {
        return jobstring;
    }

    public void setJobstring(String jobstring) {
        this.jobstring = jobstring;
    }

    public String getLaststring() {
        return laststring;
    }

    public void setLaststring(String laststring) {
        this.laststring = laststring;
    }

    public String getVacancystringl() {
        return vacancystringl;
    }

    public void setVacancystringl(String vacancystringl) {
        this.vacancystringl = vacancystringl;
    }
}
